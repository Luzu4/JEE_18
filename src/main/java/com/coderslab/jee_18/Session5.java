package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session5")
public class Session5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int randomNumber1 =(int)Math.floor(Math.random()*100);
        int randomNumber2 =(int)Math.floor(Math.random()*100);
        HttpSession mySession = req.getSession();
        mySession.setAttribute("captcha",randomNumber1+randomNumber2);

        resp.getWriter().write("<form method=\"post\" action=\"/session5\">\n" +
                "  Name:\n" +
                "  <input type=\"text\" name=\"name\">\n" +
                "  <br>\n" +
                "  Surname:\n" +
                "  <input type=\"text\" name=\"surname\">\n" +
                "  <br>\n" +
                "  Email:\n" +
                "  <input type=\"email\" name=\"email\">\n" +
                "  <br>\n" +
                "  Wpisz sume "+ randomNumber1 +" + "+ randomNumber2+":\n" +
                "  <input type=\"number\" name=\"captcha\">\n" +
                "  <br>\n" +
                "  <input type=\"submit\" name=\"Submit\">\n" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(Integer.parseInt(req.getParameter("captcha")) == (int)req.getSession().getAttribute("captcha")){
            resp.getWriter().println("Correct");
        }else{
            resp.getWriter().println("User Answer = "+req.getParameter("captcha"));
            resp.getWriter().println("Server Answer = " + req.getSession().getAttribute("captcha"));
            resp.getWriter().println("SMTH WENT WRONG");
        }
    }
}
