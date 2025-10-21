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
import java.time.LocalDateTime;

@WebServlet("/community/new")
public class CommunityNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("logonUser") == null) {
            resp.sendRedirect("/login");
            return;
        }
        Member logonUser = (Member) req.getSession().getAttribute("logonUser");
        req.setAttribute("author", true);
        req.setAttribute("logonUser", req.getSession().getAttribute("logonUser"));
        req.setAttribute("logonUserNickname", logonUser.getNickname());

        req.getRequestDispatcher("/community/new.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member logonUser = (Member) req.getSession().getAttribute("logonUser");

        String topic = req.getParameter("topic");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Article article = new Article();
        article.setTopic(topic);
        article.setTitle(title);
        article.setContent(content);
        article.setWriterId(logonUser.getId());

        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        int r =
                sqlSession.insert("mappers.ArticleMapper.insertOne", article);

        sqlSession.close();
        if( r == 1 ) {
            resp.sendRedirect("/community");
        } else {
            req.getRequestDispatcher("/community/new-fail.jsp").forward(req, resp);
            //resp.sendRedirect("/community/new");
        }




    }
}
