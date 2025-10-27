package com.example.app;

import com.example.app.model.Member;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet("/setting/withdraw")
public class SettingWithdrawServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/setting/withdraw.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member logonUser = (Member) req.getSession().getAttribute("logonUser");
        String id = logonUser.getId();

        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        sqlSession.delete("mappers.MemberMapper.deleteById", id);

        req.getRequestDispatcher("/setting/withdraw-result.jsp").forward(req,resp);

    }
}
