package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post5")
public class From5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double degress=Double.parseDouble(req.getParameter("degress"));

        if(req.getParameter("conversionType").equals("celcToFahr")){
            double fahrDegress = 32+((9.0/5.0) * degress);
            resp.getWriter().println("Fahrenheit: " + fahrDegress);
        }else{
            double celDegress = (5.0/9.0) * (degress -32);
            resp.getWriter().println("Celsjusz: " + celDegress);
        }
    }

}
