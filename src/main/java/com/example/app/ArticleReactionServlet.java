package com.example.app;

import com.example.app.model.ArticleLike;
import com.example.app.model.Member;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet("/article/reaction")
public class ArticleReactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 엄격하게 구현하면,, 유효성 검증 null 체크 등을 해야될거임..("/article") 처리하는 서블릿 처럼
        int articleNo = Integer.parseInt(req.getParameter("no"));

        Member logonUser = (Member)req.getSession().getAttribute("logonUser");
        String memeberId = logonUser.getId();

        ArticleLike t = new ArticleLike();
        t.setArticleNo(articleNo);
        t.setMemberId(memeberId);

        SqlSession sqlSession = MyBatisUtil.build().openSession(false);
        ArticleLike found =
                sqlSession.selectOne("mappers.ArticleLikeMapper.selectByMemberIdAndArticleNo", t);
        try {
            if (found != null) {
                //sqlSession.delete("mappers.ArticleLikeMapper.selectByMemberIdAndArticleNo", t);
                sqlSession.delete("mappers.ArticleLikeMapper.deleteByIdx", found.getIdx());
                sqlSession.update("mappers.ArticleMapper.decreaseLikeCnt", articleNo);
            } else {
                sqlSession.insert("mappers.ArticleLikeMapper.insertOne", t);
                sqlSession.update("mappers.ArticleMapper.increaseLikeCnt", articleNo);
            }
            sqlSession.commit();
        } catch (Exception e){
            System.out.println(e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        resp.sendRedirect("/article?no="+articleNo);
    }
}
