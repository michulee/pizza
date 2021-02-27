package com.example.pizzabuilder;

import android.util.Log;

import java.util.ArrayList;

public class OrderDetails {

    ArrayList<String> toppings = new ArrayList<String>();

    private double subtotal = 0;
    private double size_price = 0;
    private final double TOPPING_PRICE = 0.50;

//    private static double SIZE_SMALL_PRICE = 5.99;
//    private static final double SIZE_MEDIUM_PRICE = 7.99;
//    private static final double SIZE_LARGE_PRICE = 9.99;

    //should be in OrderDetails
    public double calculateSubtotal(ArrayList<String> list) {
        if(list.size() == 0) {
            return subtotal = size_price;
        }
//        Log.d(STRING, String.valueOf(size_price));
        return subtotal = list.size() * TOPPING_PRICE + size_price;
    }

    public double getSubtotal() {
        calculateSubtotal(toppings);
        return this.subtotal;
    }

    public double getSizePrice() {
        return this.size_price;
    }

    public void setSizePrice(double price) {
        this.size_price = price;
    }

    //instead of order.addItem(), use order.add() by using @override???
//    @Override
    public void addItem(String item) {
        ArrayList<String> itemList = new ArrayList<>();
        this.toppings.add(item);
    }

//    @Override
    public void removeItem(String item) {
        ArrayList<String> itemList = new ArrayList<>();
        this.toppings.remove(item);
    }

    public ArrayList<String> getToppings() {
        return this.toppings;
    }
}
