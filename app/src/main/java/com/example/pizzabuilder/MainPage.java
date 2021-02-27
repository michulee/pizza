package com.example.pizzabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    private static final String STRING = "STRING";
    private static final String STRING_ARR = "STRING_ARR";
    public static final String EXTRA_MESSAGE = "com.example.pizzabuilder.MESSAGE";

    private String size = "";
//    ArrayList<String> toppings = new ArrayList<String>();
//    private double subtotal = 0;
//    private static double size_price = 0;
//    private static final double TOPPING_PRICE = 0.50;

    private static double SIZE_SMALL_PRICE = 5.99;
    private static final double SIZE_MEDIUM_PRICE = 7.99;
    private static final double SIZE_LARGE_PRICE = 9.99;

    OrderDetails order = new OrderDetails();
    //order.setPrice(size_price);
    //want CustomerPage to house the variables

    //setText will be in activity classes
    //activity (view) classes should only call variables from OrderDetails and setText

    //subtotal = order.calculateSubtotal(); ..execute calculateSubtotal and access subtotal from OrderDetails or MainPage?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Next button */
    public void sendMessage(View view) {
        //getSize(), getToppings()
        Intent intent = new Intent(this, CustomerPage.class);
        startActivity(intent);
    }

    // TODO: 2/27/2021  SIZE_SMALL_PRICE here and set to string resource
    public void setSize(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        Resources res;

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.small:
                if (checked)
//                    this.size = getString(R.string.size_small);
                    //setSizePrice(0) or setSizeSmall(), setSizeMedium()..
                    order.setSizePrice(SIZE_SMALL_PRICE);
                    break;
            case R.id.medium:
                if (checked)
//                    this.size = getString(R.string.size_medium);
                    order.setSizePrice(SIZE_MEDIUM_PRICE);
                    break;
            case R.id.large:
                if (checked)
//                    this.size = getString(R.string.size_large);
                    order.setSizePrice(SIZE_LARGE_PRICE);
                    break;
        }
        Log.d(STRING, size);
        strToTextView(String.valueOf(order.getSubtotal()), R.id.subtotal);
    }

    // TODO: 2/27/2021  toppings not being remove after untoggle
    public void setToppings(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.mushroom:
                if (checked)
                    order.addItem("Mushroom");
                else
                    order.removeItem("Mushroom");
                    break;
            case R.id.pepperoni:
                if (checked)
                    order.addItem("Pepperoni");
                else
                    order.removeItem("Pepperoni");
                    break;
            case R.id.cheese:
                if (checked)
                    order.addItem("Cheese");
                else
                    order.removeItem("Cheese");
                break;
            case R.id.chicken:
                if (checked)
                    order.addItem("Chicken");
                else
                    order.removeItem("Chicken");
                break;
            case R.id.green_olive:
                if (checked)
                    order.addItem("Green olive");
                else
                    order.removeItem("Green Olive");
                break;
            case R.id.green_pepper:
                if (checked)
                    order.addItem("Green Pepper");
                else
                    order.removeItem("Green Pepper");
                break;
        }
        Log.d(STRING_ARR, String.valueOf(order.getToppings()));
        strToTextView(String.valueOf(order.getSubtotal()), R.id.subtotal);
    }

    //this utility class, should be somehwere else... but keep it here for now
    public void strToTextView(String str, int textViewID) {
        TextView text = (TextView)findViewById(textViewID);
        text.setText(str);
    }


}