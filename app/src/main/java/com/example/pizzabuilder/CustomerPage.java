package com.example.pizzabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerPage extends AppCompatActivity {

    private final static String STRING = "STRING";

    private String pizzaDetails = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

        OrderDetails order = new OrderDetails();


        //can you set this subtotal into the global OrderDetails order??
//        String subtotal = intent.getStringExtra("subtotal");
//        displayDetails(String.valueOf(subtotal), R.id.subtotal);

        String subtotal = intent.getStringExtra("subtotal");
        displayDetails(String.valueOf(subtotal), R.id.subtotal);

        //need to set size and toppings into order object
        ArrayList<String> toppings = intent.getStringArrayListExtra("toppings");
        order.setToppings(toppings);
        double size = intent.getDoubleExtra("size", 0);
        order.setSizePrice(size);

        //make method to fix description
        displayDetails(order.getToppings(), order.getSize(), R.id.tblDesc1);

//        displayDetails(String.valueOf(order.getSubtotal()), R.id.tblPrice1);
//        displayDetails(String.valueOf(order.getTax()), R.id.tax);
//        displayDetails(String.valueOf(order.getTotal()), R.id.total);

        displayDetails(order.getSubtotal(), R.id.tblPrice1);
        displayDetails(order.getTax(), R.id.tax);
        displayDetails(order.getTotal(), R.id.total);
    }

    //assume 10% sales tax, return total in calculateTotal()

    //setDescription(), setSubtotal() in both receipt and table, setTax(), setTotal()



    //for item, desc, price, quantity (but item and quantity are fixed)
    public void displayDetails(String str, int textViewID) {
        TextView view = (TextView)findViewById(textViewID);
        view.setText(str);
    }

    public void displayDetails(Double num, int textViewID) {
        TextView view = (TextView)findViewById(textViewID);
        view.setText(String.valueOf(num));
    }

    public void displayDetails(ArrayList<String> list, String size, int textViewID) {
        TextView view = (TextView)findViewById(textViewID);
        String strList = listWithCommas(list);
        String desc = size.concat(": ").concat(strList);
        view.setText(desc);
    }

    public String listWithCommas(ArrayList<String> list) {
        String appendStr = "";
        for(String item : list) {
            if(item == list.get(list.size()-1)) {
                appendStr += item;
            } else {
                appendStr += item.concat(", ");
            }
        }
//        for(int i = 0; i < list.size()-1; i++) {
//            appendStr += (list.get(i) + ", ");
//        }
        return appendStr;
    }


}