package com.coderslab.jee_18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/session4")
public class Session4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mySession = req.getSession();
        List<CartItem> CartItems = new ArrayList<>();
        CartItem newItem = new CartItem(req.getParameter("name"),Integer.parseInt(req.getParameter("quantity")), Double.parseDouble(req.getParameter("price")));
        if(!Objects.isNull(mySession.getAttribute("CartItems"))){
            CartItems = (ArrayList<CartItem>)mySession.getAttribute("CartItems");
        }
        CartItems.add(newItem);
        mySession.setAttribute("CartItems", CartItems);
        double sumPrice = 0;
        for(CartItem singleItem: CartItems){
            resp.getWriter().println("Name: " + singleItem.getName() + " - " +
                    singleItem.getQuantity() + " x " +
                    singleItem.getPrice() + "zl = " +
                    (singleItem.getQuantity() * singleItem.getPrice()));
            sumPrice += singleItem.getQuantity() * singleItem.getPrice();
        }
        resp.getWriter().println("SUMA: " + sumPrice + "zl");

    }
}
