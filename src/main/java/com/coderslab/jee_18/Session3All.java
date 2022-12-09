package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mySession = req.getSession();
        Enumeration<String> enumerationOfMySession = mySession.getAttributeNames(); // "użyj dodatkowej zmiennej sesyjnej, która będzie przechowywać (w tablicy lub w kolekcji) wszystkie klucze" ?? Enumeration czy to zalicza sie do tablicy albo kolekcji?
        resp.setContentType("text/html");
        resp.getWriter().write("<table>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            Key\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            Value\n" +
                "        </td>\n" +
                "    </tr>");
        while(enumerationOfMySession.hasMoreElements()){
            String nameOfKey = enumerationOfMySession.nextElement();
            mySession.getAttribute(nameOfKey);
            resp.getWriter().write("<tr> <td>" +nameOfKey+ "</td><td>" + mySession.getAttribute(nameOfKey) + "</td></tr>");
        }
        resp.getWriter().write("</table>");
    }
}
