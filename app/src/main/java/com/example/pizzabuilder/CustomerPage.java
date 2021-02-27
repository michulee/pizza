package com.example.pizzabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CustomerPage extends AppCompatActivity {

    private double taxRate = 10;
    private double total = 0;
    private String pizzaDetails = "";

    OrderDetails order = new OrderDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        MainPage pizza = new MainPage();
    }

    //assume 10% sales tax, return total in calculateTotal()

    //setDescription(), setSubtotal() in both receipt and table, setTax(), setTotal()

    public double calculateTotal(double subtotal) {
        return total;
    }

    //for item, desc, price, quantity (but item and quantity are fixed)
    public void displayDetails(String details, double price) {
        TextView descView = (TextView)findViewById(R.id.details);
        descView.setText(details);

        TextView priceView = (TextView)findViewById(R.id.price);
        priceView.setText(String.valueOf(price));
    }

    public void displayReceipt() {

    }


}