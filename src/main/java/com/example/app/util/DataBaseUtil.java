package com.example.app.util;


import com.example.app.vo.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseUtil {
    /*
        insert into member(id, password, email, name, nickname, interest, agree)
        values('master', '1q2w3e4r', 'master@test.com', '윤형호', '마스터', null, true);
        values(?, ?, ?, ?, ?, ?, ?)
     */
    public static int insertMember(String id, String password, String email, String name, String nickname, String interest, boolean agree) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database-dev.cf4smeaw68a2.ap-northeast-2.rds.amazonaws.com:3306/community", "admin", "gus2503938");

            PreparedStatement ps =
                    conn.prepareStatement("insert into member(id, password, email, name, nickname, interest, agree) values(?,?,?,?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, password);
            ps.setObject(3, email);
            ps.setObject(4, name);
            ps.setObject(5, nickname);
            ps.setObject(6, interest);
            ps.setObject(7, agree);

            int r = ps.executeUpdate();
            conn.close();
            return r;
        } catch (Exception e) {
            System.out.println("ERR" + e);
            return -1;
        }
    }

    /*
        select * frim member where id=?
     */
    public static Member selectMemberById(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database-dev.cf4smeaw68a2.ap-northeast-2.rds.amazonaws.com:3306/community", "admin", "gus2503938");

            PreparedStatement ps = conn.prepareStatement("select * from member where id = ?");
            ps.setObject(1, id);

            ResultSet rs = ps.executeQuery();
            Member member = null;
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getObject("id", String.class));
                member.setPassword(rs.getObject("password", String.class));
                member.setEmail(rs.getObject("email", String.class));
                member.setName(rs.getObject("name", String.class));
                member.setNickname(rs.getObject("nickname", String.class));
                member.setInterest(rs.getObject("interest", String.class));
                member.setAgree(rs.getObject("agree", boolean.class));
            }
            conn.close();
            return member;
        } catch (Exception e) {
            System.out.println("ERR...!" + e);
            return null;
        }
    }

    /*
        select * from member where nickname=?
     */
    public static Member selectMemberByNickname(String nickname) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database-dev.cf4smeaw68a2.ap-northeast-2.rds.amazonaws.com:3306/community", "admin", "gus2503938");

            PreparedStatement ps = conn.prepareStatement("select * from member where nickname = ?");
            ps.setObject(1, nickname);

            ResultSet rs = ps.executeQuery();
            Member member = null;
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getObject("id", String.class));
                member.setPassword(rs.getObject("password", String.class));
                member.setEmail(rs.getObject("email", String.class));
                member.setName(rs.getObject("name", String.class));
                member.setNickname(rs.getObject("nickname", String.class));
                member.setInterest(rs.getObject("interest", String.class));
                member.setAgree(rs.getObject("agree", boolean.class));
            }
            conn.close();
            return member;
        } catch (Exception e) {
            System.out.println("ERR...!!!!!" + e);
            return null;
        }
    }


}

