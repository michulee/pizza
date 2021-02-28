package com.example.pizzabuilder;

import java.util.ArrayList;

public class OrderDetails {

    private final static String STRING = "STRING";

    ArrayList<String> list = new ArrayList<String>();

    private double subtotal = 0;
    private double taxRate = 0.10;
    private double tax = 0;
    private double total = 0;
    private double size_price = 0;
    private String size = "";
    private final double TOPPING_PRICE = 0.50;

//    private final double SIZE_SMALL_PRICE = 5.99;
//    private final double SIZE_MEDIUM_PRICE = 7.99;
//    private final double SIZE_LARGE_PRICE = 9.99;

//    private double calculateSubtotal(ArrayList<String> list) {
//        if(list.size() == 0) {
//            return subtotal = size_price;
//        }
////        Log.d(STRING, String.valueOf(size_price));
//        return subtotal = list.size() * TOPPING_PRICE + size_price;
//    }

    public double getSubtotal() {
        if(list.size() == 0) {
            return subtotal = size_price;
        }
        return subtotal = list.size() * TOPPING_PRICE + size_price;
    }

    public double getTax() {
        getSubtotal();
        return this.tax = this.subtotal * this.taxRate;
    }

    public double getTotal() {
        //keep getSubtotal() and getTax() or remove??
        getSubtotal();
//        getTax();
        return this.total = this.subtotal * (1 + this.taxRate);
    }

    public void setSizePrice(double price) {
        if(price == 5.99) {
            this.size = "Small";
        }
        else if(price == 7.99) {
            this.size = "Medium";
        }
        else if(price == 9.99) {
            this.size = "Large";
        }
        this.size_price = price;
    }

    public double getSizePrice() {
        return this.size_price;
    }

    public String getSize() {
        return this.size;
    }

    //instead of order.addItem(), use order.add() by using @override???
//    @Override
    public void addItem(String item) {
        this.list.add(item);
    }

//    @Override
    public void removeItem(String item) {
        this.list.remove(item);
    }

    public ArrayList<String> getToppings() {
        return this.list;
    }

    public void setToppings(ArrayList<String> list) {
        this.list = list;
    }

}
