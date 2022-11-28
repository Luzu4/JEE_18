package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/get3")
public class Get3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String width = req.getParameter("width");
        String height = req.getParameter("height");

        if(Objects.isNull(width)){
            width="5";
        }
        if(Objects.isNull(height)){
            height="10";
        }

        int intWidth = Integer.parseInt(width);
        int intHeight = Integer.parseInt(height);
        resp.getWriter().print("|" + "X");
        for(int i = 1 ; i<=intWidth;i++){
            resp.getWriter().print("|" + i);
        }
        for(int j = 1; j<=intHeight;j++){
            resp.getWriter().println();
            resp.getWriter().print("|" + j);
            for(int i = 1 ; i<=intWidth;i++){
                resp.getWriter().print("|" + i*j);
            }
        }


    }
}
