package com.example.app;

import com.example.app.model.LoginHistory;
import com.example.app.model.Member;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.util.List;

@WebServlet("/setting/history")
public class SettingHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("logonUser") == null){
            resp.sendRedirect("/login");
            return;
        }

        // 웹어플리케이션 기준,, 현재 로그인한 사용자 정복 필요하면
        // 요청자의 세션에서 찾아서 쓰면 된다. (전제는 .. 인증했을때 저장해놨다면..)
        Member logonUser = (Member) req.getSession().getAttribute("logonUser"); // 요청자 세션은 Map<String, Object> 형태

        SqlSession sqlSession = MyBatisUtil.build().openSession(true);

        List<LoginHistory> list =
                sqlSession.selectList("mappers.LoginHistoryMapper.selectByMemberId", logonUser.getId());

        req.setAttribute("list", list);
        req.setAttribute("auth", true);
        req.getRequestDispatcher("/setting/history.jsp").forward(req, resp);
    }
}
