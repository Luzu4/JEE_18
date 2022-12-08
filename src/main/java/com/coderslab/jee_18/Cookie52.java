package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isCookieExist = false;
        for(Cookie single :req.getCookies()){
            if(single.getName().equals("cookie51")){
                single.setMaxAge(0);
                resp.addCookie(single);
                resp.getWriter().println("Witamy na Stronie Cookie52");
                isCookieExist=true;
            }
        }
        if(!isCookieExist){
            String message = "Nie odwiedziles jeszcze tej strony";
            resp.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, "UTF-8"));
        }
    }
}
