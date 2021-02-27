package com.example.pizzabuilder;

import android.util.Log;

import java.util.ArrayList;

public class OrderDetails {

    private double subtotal = 0;
    private double size_price = 0;
    private final double TOPPING_PRICE = 0.50;

    //should be in OrderDetails
    public double calculateSubtotal(ArrayList<String> list) {
        if(list.size() == 0) {
            return subtotal = size_price;
        }
//        Log.d(STRING, String.valueOf(size_price));
        return subtotal = list.size() * TOPPING_PRICE + size_price;
    }

}
