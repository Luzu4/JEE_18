package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/get4")
public class Get4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //?company=coderslab&learn=php&learn=java&learn=ruby&learn=python
        Map<String, String[]> parameterMap = req.getParameterMap();

        for(Map.Entry<String,String[]> entry : parameterMap.entrySet()){
            resp.getWriter().println(entry.getKey()+":");
            for(String value : entry.getValue()){
                resp.getWriter().println("  - " + value);
            }
        }

    }
}
