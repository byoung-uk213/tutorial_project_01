package com.example.app;

import com.example.app.model.Member;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String keepLogin = req.getParameter("keepLogin");
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);

        Member found = sqlSession.selectOne("mappers.MemberMapper.selectById", id);

        if(found != null && found.getPassword().equals(password)) {
            //============================================================================
            if(keepLogin != null) {
                Cookie cookie = new Cookie("keepLogin", id);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(cookie);
            }
            //============================================================================
            int r = sqlSession.insert("mappers.LoginHistoryMapper.insertOne", id);

            req.getSession().setAttribute("logonUser", found);

            resp.sendRedirect("/index");
        } else {
            req.setAttribute("tryId", id);

            req.getRequestDispatcher("/login-fail.jsp").forward(req,resp);
        }

        sqlSession.close();
    }
}
