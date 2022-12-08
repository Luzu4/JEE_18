package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Cookie single : req.getCookies()){
            resp.getWriter().println(single.getName() + " = " + single.getValue());
            resp.setContentType("text/html");
            resp.getWriter().write("<a href=\"/removeCookie?name=" + single.getName()+ "\">" + single.getName()+"</a><br>");
        }
    }
}
