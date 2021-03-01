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

    /**
     * Gets subtotal based on the size and toppings.
     * @return subtotal of a pizza
     */
    public double getSubtotal() {
        if(list.size() == 0) {
            return subtotal = size_price;
        }
        return subtotal = list.size() * TOPPING_PRICE + size_price;
    }

    /**
     * Returns the estimated tax of a pizza from sales tax %.
     * @return estimated tax of a pizza
     */
    public double getTax() {
        getSubtotal();

        double tax = this.subtotal * this.taxRate;
        DecimalFormat df = new DecimalFormat("0.00");
        String str1 = df.format(tax);
        //parsing back to double will not keep format
        return this.tax = Double.parseDouble(str1);
    }

    /**
     * Returns the subtotal + tax of a pizza.
     * @return subtotal + tax of a pizza
     */
    public double getTotal() {
        getSubtotal();
        return this.total = this.subtotal * (1 + this.taxRate);
    }

    /**
     * Sets the size price of a pizza.
     * @param price price of a pizza size
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

    /**
     * Returns the size price of a pizza.
     * @return size price of a pizza
     */
    public double getSizePrice() {
        return this.size_price;
    }

    /**
     * Returns the size of a pizza.
     * @return size of a pizza
     */
    public String getSize() { return this.size; }

    /**
     * Returns a list of toppings.
     * @return list of toppings
     */
    public ArrayList<String> getToppings() {
        return this.list;
    }

    /**
     * Sets a list of toppings.
     * @param list list of toppings
     */
    public void setToppings(ArrayList<String> list) {
        this.list = list;
    }

    /**
     * Helper method that adds an item to a list.
     * @param item that will be added to a list
     */
    public void addItem(String item) {
        this.list.add(item);
    }

    /**
     * Helper method that removes an item from a list.
     * @param item that will be removed from a list
     */
    public void removeItem(String item) { this.list.remove(item); }

}
