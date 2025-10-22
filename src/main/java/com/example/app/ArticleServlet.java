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

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String no = req.getParameter("no");
        if(no == null || !no.matches("\\d+")) {
            resp.sendRedirect("/community");
            return;
        }
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        sqlSession.update("mappers.ArticleMapper.updateViewCnt", Integer.parseInt(no));

        Article found = sqlSession.selectOne("mappers.ArticleMapper.selectByNo", Integer.parseInt(no));
        if(found == null) {
            resp.sendRedirect("/community");
            return;
        }
        sqlSession.close();

        req.setAttribute("auth", req.getSession().getAttribute("logonUser") != null);
        req.setAttribute("article", found);
        req.getRequestDispatcher("/article.jsp").forward(req, resp);
    }
}
