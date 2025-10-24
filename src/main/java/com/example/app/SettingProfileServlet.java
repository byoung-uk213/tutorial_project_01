package com.example.app;

import com.example.app.model.Article;
import com.example.app.model.Member;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/setting/profile")
public class SettingProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("logonUser") == null){
            resp.sendRedirect("/login");
            return;
        }
        Member logonUser = (Member) req.getSession().getAttribute("logonUser");
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);


       Member member =
                sqlSession.selectOne("mappers.MemberMapper.selectById", logonUser.getId());



        req.setAttribute("member", member);
        req.getRequestDispatcher("/setting/profile.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");

        Member one = new Member();
        one.setId(id);
        one.setName(name);
        one.setNickname(nickname);
        one.setEmail(email);

        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        int r = sqlSession.update("mappers.ArticleMapper.updateTwo", one);
        sqlSession.close();

        resp.sendRedirect("/index");



    }
}
