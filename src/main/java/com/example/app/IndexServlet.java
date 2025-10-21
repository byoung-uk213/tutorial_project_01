package com.example.app;

import com.example.app.util.MyBatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSessionFactory;
import org.ocpsoft.prettytime.PrettyTime;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Locale;

@WebServlet("/index") // 이런식으로 2개 설정 가능
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("logonUser") == null) {
            req.setAttribute("auth", false);
        } else {
            req.setAttribute("auth", true);
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
