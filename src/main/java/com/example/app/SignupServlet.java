package com.example.app;

import com.example.app.model.Member;
import com.example.app.util.DataBaseUtil;
import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 전달받은 값들 뽑아서 insert 처리
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String interest = req.getParameter("interest");
        boolean agree = Boolean.parseBoolean(req.getParameter("agree"));

        Member member = new Member();
        member.setId(id);
        member.setPassword(password);
        member.setEmail(email);
        member.setName(name);
        member.setNickname(nickname);
        member.setInterest(interest);
        member.setAgree(agree);
        SqlSession sqlSession = MyBatisUtil.build().openSession(true);
        int r = 0;
        if(id.matches("[a-z0-9]{4,15}")
                && password.matches("(?=.*[a-z])(?=.*[0-9][a-z0-9]{6,})")) {
            Member found1 =
                    sqlSession.selectOne("mappers.MemberMapper.selectById", id);
            Member found2 =
                    sqlSession.selectOne("mappers.MemberMapper.selectByNickname", nickname);
            if(found1==null || found2==null) {
                r = sqlSession.insert("mappers.MemberMapper.insertOne", member);
            }
        }

//        Member found1 =
//                sqlSession.selectOne("mappers.MemberMapper.selectById", id);
//                // selectOne 하나만 나올때
//                // selectList 여러개 나올때
//        System.out.println(found1);
//        int r = sqlSession.insert("mappers.MemberMapper.insertOne", member);
//       // int r = DataBaseUtil.insertMember(id, password, email, name, nickname, interest, agree);
        sqlSession.close();

        if( r == 1 ) {
            req.setAttribute("nickname", nickname);
            req.getRequestDispatcher("/signup-success.jsp").forward(req,resp);
        } else {
            req.setAttribute("id", id);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("name", name);
            req.setAttribute("nickname", nickname);
            req.setAttribute("interest", interest);
            req.setAttribute("agree", agree);


            if( DataBaseUtil.selectMemberById(id) != null ) {
                req.setAttribute("mainError", "이미 사용되고 있는 아이디 입니다.");
            }
            if(DataBaseUtil.selectMemberById(nickname) != null ) {
                req.setAttribute("mainError", "이미 사용되고 있는 닉네임 입니다.");
            }
            req.getRequestDispatcher("/signup-fail.jsp").forward(req,resp);
        }
    }
}
// doDelete, doHead, doOptions, doPatch, doPut, doTrace, mybatis