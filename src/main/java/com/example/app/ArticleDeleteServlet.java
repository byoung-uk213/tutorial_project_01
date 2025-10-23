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

@WebServlet("/article/delete")
public class ArticleDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // no로 넘어오는 파라미터 넘어온 값 뽑아서
        int no = Integer.parseInt(req.getParameter("no"));

        // mybatis 연결해서 deleteByNo 호출
        // 삭제 전에 처리해야될 일들
        // 1. 요청자가 쓴글인경우에만 삭제가 되게 해야되고
        // 2. 삭제하고자 글을 좋아요 해둔 정보들을 전부 삭제해야지만, 글이 삭제
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        Member user = (Member) req.getSession().getAttribute("logonUser");
        Article article = sqlSession.selectOne("mappers.ArticleMapper.selectByNo", no);
        if(user != null && article != null && article.getWriterId().equals(user.getId())) {
            sqlSession.delete("mappers.ArticleLikeMapper.deleteByArticleNo", no);
            sqlSession.delete("mappers.ArticleMapper.deleteByNo", no);
        }

        // 작업끝나면.. 글 목록 보는 /community로 리다이렉트
        resp.sendRedirect("/community");
    }
}
