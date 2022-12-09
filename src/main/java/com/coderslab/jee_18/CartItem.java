package com.coderslab.jee_18;

public class CartItem {
    private String name;
    private Integer quantity;
    private double price;


    public CartItem(String name, Integer quantity, double price){
        this.name=name;
        this.quantity=quantity;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }


}
