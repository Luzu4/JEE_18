package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getForm3")
public class Form3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int numberFromUser = Integer.parseInt(req.getParameter("page"));

        for(int i = numberFromUser; i>0;i--){
            if(numberFromUser%i == 0 ){
                resp.getWriter().println(i);
            }
        }

    }
}
