package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebServlet("/session2")
public class Session2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<form action=\"/session2\" method=\"post\">\n" +

                "    <label>\n" +
                "        <input type=\"number\" name=\"mark\">\n" +
                "    </label>\n" +
                "\n" +
                "    <input type=\"submit\" value=\"Send\">\n" +
                "</form>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> marks = new ArrayList<>();
        HttpSession mySession = req.getSession();


        if(!Objects.isNull(mySession.getAttribute("marks"))){
            marks=(ArrayList<Integer>) mySession.getAttribute("marks");
        }
        marks.add(Integer.parseInt(req.getParameter("mark")));
        mySession.setAttribute("marks",marks);

        double average=0;
        for(Integer mark: marks){
            average+=mark;
        }
        average = average/marks.size();

        resp.getWriter().println("Added Mark : "+req.getParameter("mark"));
        resp.getWriter().println("------------------------------------------");
        resp.getWriter().println("All Marks: " + req.getSession().getAttribute("marks"));
        resp.getWriter().println("------------------------------------------");
        resp.getWriter().println("Average: " + average);

    }
}
