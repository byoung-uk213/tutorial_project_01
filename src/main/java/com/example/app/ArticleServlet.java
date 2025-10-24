package com.example.app;

import com.example.app.model.Article;
import com.example.app.model.Comment;
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
import java.util.Map;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String no = req.getParameter("no");
        if (no == null || !no.matches("\\d+")) {
            resp.sendRedirect("/community");
            return;
        }
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        sqlSession.update("mappers.ArticleMapper.updateViewCnt", Integer.parseInt(no));
        Article found = sqlSession.selectOne("mappers.ArticleMapper.selectByNo", Integer.parseInt(no));
        if (found == null) {
            resp.sendRedirect("/community");
            return;
        }
        // 좋아요 관련 데이터를 세팅해서
        Member logonUser = (Member) req.getSession().getAttribute("logonUser");
        if (logonUser == null) {
            req.setAttribute("alreadyLike", false);
        } else {
            Map map = Map.of("memberId", logonUser.getId(), "articleNo", no);
            int cnt = sqlSession.selectOne("mappers.ArticleLikeMapper.countByMemberIdAndArticleNo", map);
            req.setAttribute("alreadyLike", cnt == 1);
        }

        // 제어메뉴를 보이게 할껀지 아니지도 설정
        if(logonUser == null || !found.getWriterId().equals(logonUser.getId())) {
            req.setAttribute("owner", false);
        } else {
            req.setAttribute("owner", true);
        }
        // 댓글 관려
        List<Comment> comments
                = sqlSession.selectList("mappers.CommentMapper.selectByArticleNo", Integer.parseInt(no));
        req.setAttribute("comments", comments);

        sqlSession.close();

        req.setAttribute("auth", req.getSession().getAttribute("logonUser") != null);
        req.setAttribute("article", found);


        req.getRequestDispatcher("/article.jsp").forward(req, resp);
    }
}
