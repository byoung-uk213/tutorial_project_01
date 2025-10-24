package com.example.app;

import com.example.app.model.Article;
import com.example.app.model.WriteCounter;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet("/community")
public class CommunityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("logonUser") != null) {
            req.setAttribute("auth", true);
        } else {
            req.setAttribute("auth", false);
        }
        //===============================
        int page = req.getParameter("page") != null ?
                Integer.parseInt(req.getParameter("page")) : 1;
        String keyword = req.getParameter("keyword") != null ? req.getParameter("keyword") : "";

        SqlSession sqlSession = MyBatisUtil.build().openSession(true);

        sqlSession.selectList("mappers.ArticleMapper.selectByOffset", (page - 1) * 10);

        Map param = Map.of("offset", (page - 1) * 10, "keyword", "%" + keyword + "%");
        List<Article> articles =
                sqlSession.selectList("mappers.ArticleMapper.selectLikeKeywordByOffset", param);

        //int count = sqlSession.selectOne("mappers.ArticleMapper.countAll");
        int count = sqlSession.selectOne("mappers.ArticleMapper.countLikeKeyword",
                                                                            "%"+keyword+"%");
        int lastPage = count / 10 + (count % 10 > 0 ? 1 : 0);

        List<Article> top5Likes =
            sqlSession.selectList("mappers.ArticleMapper.selectTop5Likes", LocalDate.now().minusDays(7));

        List<WriteCounter> top5Writer =
                sqlSession.selectList("mappers.ArticleMapper.selectTop5Writer");

        req.setAttribute("top5Writer", top5Writer);
        req.setAttribute("top5Likes", top5Likes);
        req.setAttribute("articles", articles);
        req.setAttribute("lastPage", lastPage);
        req.setAttribute("page", page);
        req.setAttribute("count", count);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/community.jsp").forward(req, resp);
    }
}
