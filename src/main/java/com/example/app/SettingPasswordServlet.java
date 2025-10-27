package com.example.app;

import com.example.app.model.Member;
import com.example.app.model.UpdatePassword;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet("/setting/password-changes")
public class SettingPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("logonUser") == null){
            resp.sendRedirect("/login");
            return;
        }
        req.getRequestDispatcher("/setting/password-changes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");
        String newPasswordConfirm = req.getParameter("newPasswordConfirm");

        Member logonUser = (Member) req.getSession().getAttribute("logonUser");
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        Member found = sqlSession.selectOne( "mappers.MemberMapper.selectById", logonUser.getId());

        if(!found.getPassword().equals(password)){
            req.setAttribute("error", "현재 비밀번호가 일치하지 않습니다.");
            req.getRequestDispatcher("/setting/password-changes-fail.jsp").forward(req, resp);

        } else  if(!newPassword.equals(newPasswordConfirm)) {
            req.setAttribute("error", "비밀번호가 서로 일치하지 않습니다.");
            req.getRequestDispatcher("/setting/password-changes-fail.jsp").forward(req, resp);

        } else if(found.getPassword().equals(newPassword)) {
            req.setAttribute("error", "변경하고자 하는 비밀번호가 현재 비밀번호와 일치합니다.");
            req.getRequestDispatcher("/setting/password-changes-fail.jsp").forward(req, resp);

        } else {
            UpdatePassword up = new UpdatePassword();
                up.setId(logonUser.getId());
                up.setPassword(newPassword);
            sqlSession.update("mappers.MemberMapper.updatePassword", up);
            resp.sendRedirect("/login");
        }











    }
}
