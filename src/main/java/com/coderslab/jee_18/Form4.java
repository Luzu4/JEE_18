package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post4")
public class Form4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        int c = Integer.parseInt(req.getParameter("c"));

        int delta = b*b - 4*a*c;

        if(delta>0){
            double x1 = Math.round((-b- Math.sqrt(delta))/(2*a)*100.0)/100.0;
            double x2 = (-b+ Math.sqrt(delta))/(2*a);
            resp.getWriter().println("X1 = " + x1);
            resp.getWriter().println("X2 = " + x2);

        } else if (delta==0){
            double x0 = (-b)/(2*a);
            resp.getWriter().println("X0 = " + x0);

        }else{
            resp.getWriter().println("Zeroooooooo");
        }
    }
}

