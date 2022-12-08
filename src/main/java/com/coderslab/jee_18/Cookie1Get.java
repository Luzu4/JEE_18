package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.isNull(req.getCookies())){
            resp.getWriter().println("BRAK");
        }else{
            for(Cookie single : req.getCookies()){
                resp.getWriter().println(single.getMaxAge());
                resp.getWriter().println(single.getName() + " = " +single.getValue());
            }
        }


    }
}
