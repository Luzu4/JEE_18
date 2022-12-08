package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie51")
public class Cookie51 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie newCookie = new Cookie("cookie51","alreadyBeenThere");
        resp.addCookie(newCookie);
        resp.setContentType("text/html");
        resp.getWriter().write("<a href=\"/cookie52\">Cookie52</a><br>");

    }


}
