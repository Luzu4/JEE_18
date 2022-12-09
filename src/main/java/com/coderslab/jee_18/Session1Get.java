package com.coderslab.jee_18;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!Objects.isNull(req.getSession().getAttribute("counter"))){
            resp.getWriter().println(req.getSession().getAttribute("counter"));
            req.getSession().setAttribute("counter",(int)req.getSession().getAttribute("counter")+1);
        }else{
            resp.getWriter().println("EMPTY");
        }

    }
}
