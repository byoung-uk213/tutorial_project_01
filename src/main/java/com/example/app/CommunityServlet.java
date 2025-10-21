package com.example.app;

import com.example.app.model.Article;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/community")
public class CommunityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("logonUser") != null) {
            req.setAttribute("auth", true);
        } else {
            req.setAttribute("auth", false);
        }
        //===============================
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);

        List<Article> articles = sqlSession.selectList("mappers.ArticleMapper.selectAll");

        req.setAttribute("articles", articles);

        req.getRequestDispatcher("/community.jsp").forward(req, resp);
    }
}
