package com.example.pizzabuilder;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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

    private final double SIZE_SMALL_PRICE = 5.99;
    private final double SIZE_MEDIUM_PRICE = 7.99;
    private final double SIZE_LARGE_PRICE = 9.99;

    public double getSubtotal() {
        if(list.size() == 0) {
            return subtotal = size_price;
        }
        return subtotal = list.size() * TOPPING_PRICE + size_price;
    }

    public double getTax() {
        getSubtotal();
        double tax = this.subtotal * this.taxRate;
//        BigDecimal bd = new BigDecimal(Double.toString(tax));
//        bd = bd.setScale(2, RoundingMode.HALF_UP);
//        return this.tax = bd.doubleValue();

        DecimalFormat df = new DecimalFormat("0.00");
//        df.setRoundingMode(RoundingMode.HALF_UP);
        String str1 = df.format(tax);
        //parsing back to double will not keep format
        return this.tax = Double.parseDouble(str1);
    }

    public double getTotal() {
        //keep getSubtotal() and getTax() or remove??
        getSubtotal();
//        getTax();
        return this.total = this.subtotal * (1 + this.taxRate);
    }

    /**
     *
     * @param price
     */
    public void setSizePrice(double price) {
        if(price == SIZE_SMALL_PRICE) {
            this.size = "Small";
        }
        else if(price == SIZE_MEDIUM_PRICE) {
            this.size = "Medium";
        }
        else if(price == SIZE_LARGE_PRICE) {
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

    public void addItem(String item) {
        this.list.add(item);
    }

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
