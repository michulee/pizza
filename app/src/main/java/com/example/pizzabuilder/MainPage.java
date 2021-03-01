package com.example.pizzabuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;



public class MainPage extends AppCompatActivity {
    private static final String STRING = "STRING";
    private static final String STRING_ARR = "STRING_ARR";
    public static final String EXTRA_MESSAGE = "com.example.pizzabuilder.MESSAGE";
    private static final String KEY_TOPPINGS = "toppings";
    private static final String KEY_SUBTOTAL = "subtotal";
    private static final String KEY_SIZE = "size";



    OrderDetails order = new OrderDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        if (savedInstanceState != null) {
            order.setToppings(savedInstanceState.getStringArrayList(KEY_TOPPINGS));
            order.setSizePrice(savedInstanceState.getDouble(KEY_SIZE));

            displayDetails(order.getSubtotal(), R.id.subtotal);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble(KEY_SUBTOTAL, order.getSubtotal());
        outState.putDouble(KEY_SIZE, order.getSizePrice());
        outState.putStringArrayList(KEY_TOPPINGS, order.getToppings());
    }

    /** Called when the user taps the Next button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, CustomerPage.class);

        intent.putExtra("subtotal", order.getSubtotal());
        intent.putExtra("toppings", order.getToppings());
        intent.putExtra("size", order.getSizePrice());
        startActivity(intent);
    }

    // TODO: 2/27/2021  SIZE_SMALL_PRICE here and set to string resource
    // TODO: 2/28/2021 make only setSize required
    public void setSize(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        final double SIZE_SMALL_PRICE = 5.99;
        final double SIZE_MEDIUM_PRICE = 7.99;
        final double SIZE_LARGE_PRICE = 9.99;

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.small:
                if (checked)
                    order.setSizePrice(SIZE_SMALL_PRICE);
                    break;
            case R.id.medium:
                if (checked)
                    order.setSizePrice(SIZE_MEDIUM_PRICE);
                    break;
            case R.id.large:
                if (checked)
                    order.setSizePrice(SIZE_LARGE_PRICE);
                    break;
        }
        displayDetails(order.getSubtotal(), R.id.subtotal);
    }

    // TODO: 2/27/2021  toppings not being removed after untoggle
    public void setToppings(View view) {
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
                    order.addItem("Green Olive");
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
        displayDetails(order.getSubtotal(), R.id.subtotal);
    }

    public void displayDetails(String str, int textViewID) {
        TextView text = (TextView)findViewById(textViewID);
        text.setText(str);
    }

    public void displayDetails(double num, int textViewID) {
        TextView text = (TextView)findViewById(textViewID);
        text.setText(String.valueOf(num));
    }

}