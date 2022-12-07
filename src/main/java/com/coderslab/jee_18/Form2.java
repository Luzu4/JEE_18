package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    List<String> vulgarisms = Arrays.asList("kurwa","chuj","dupa");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textFromUser = req.getParameter("textBox");
        if(Objects.nonNull(req.getParameter("awareness")) && req.getParameter("awareness").equals("on")){
            resp.getWriter().println(textFromUser);
        }else{
            for(String vulgarism : vulgarisms){
                textFromUser = textFromUser.replace(vulgarism,"*".repeat(vulgarism.length()));

            }
            resp.getWriter().println(textFromUser);
        }
        resp.getWriter().println("Awareness: " + req.getParameter("awareness"));



    }
}
