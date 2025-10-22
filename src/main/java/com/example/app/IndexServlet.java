package com.example.app;

import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.ocpsoft.prettytime.PrettyTime;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Locale;

@WebServlet("/index") // 이런식으로 2개 설정 가능
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
