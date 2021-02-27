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

public class MainActivity extends AppCompatActivity {
    private static final String STRING = "STRING";
    private static final String STRING_ARR = "STRING_ARR";
    public static final String EXTRA_MESSAGE = "com.example.pizzabuilder.MESSAGE";
    private static final double TOPPING_PRICE = 0.50;

    //get @string/size_small_price and convert to a double
    private static double SIZE_SMALL_PRICE = 5.99;
    private static final double SIZE_MEDIUM_PRICE = 7.99;
    private static final double SIZE_LARGE_PRICE = 9.99;

    ArrayList<String> toppings = new ArrayList<String>();
    private int toppingsNum = 0;
    private String size = "";
    private static double size_price = 0;
    private double subtotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        //every time button is clicked
        //all radioButtons and checkBoxes have onClick = "setSubtotal"
        //in setSubtotal(View view), if radioV.isChecked() call setSize(), else if checkboxV.isChecked() call setToppings(); set textView of subtotal
//        calculateSubtotal(toppings);
//        Log.d(STRING, size.toString());
//        strToTextView(String.valueOf(subtotal), R.id.subtotal);


        //sets text if changes
//        this.SIZE_SMALL_PRICE = Double.valueOf(getString(R.string.size_small_price));
        //size_small and size_small_price in map
//        String text = res.getString(R.string.size_price, getString(R.string.size_small), " - ", getString(R.string.size_small_price));
//        TextView size_text = (TextView)findViewById(R.id.small); //R.id.small is the TextView id
//        size_text.setText(text);
    }

    /** Called when the user taps the Next button */
    public void sendMessage(View view) {
        //getSize(), getToppings()
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    public void setSize(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.small:
                if (checked)
                    this.size = getString(R.string.size_small);
                    this.size_price = SIZE_SMALL_PRICE;
                    break;
            case R.id.medium:
                if (checked)
                    this.size = getString(R.string.size_medium);
                    this.size_price = SIZE_MEDIUM_PRICE;
                    break;
            case R.id.large:
                if (checked)
                    this.size = getString(R.string.size_large);
                    this.size_price = SIZE_LARGE_PRICE;
                    break;
        }
        Log.d(STRING, size);
    }

    public void setToppings(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.mushroom:
                if (checked)
                    this.toppings.add(getString(R.string.mushroom));
                else
                    this.toppings.remove(getString(R.string.mushroom));
                    break;
            case R.id.pepperoni:
                if (checked)
                    this.toppings.add(getString(R.string.pepperoni));
                else
                    this.toppings.remove(getString(R.string.pepperoni));
                    break;
            case R.id.cheese:
                if (checked)
                    this.toppings.add(getString(R.string.cheese));
                else
                    this.toppings.remove(getString(R.string.cheese));
                break;
            case R.id.chicken:
                if (checked)
                    this.toppings.add(getString(R.string.chicken));
                else
                    this.toppings.remove(getString(R.string.chicken));
                break;
            case R.id.green_olive:
                if (checked)
                    this.toppings.add(getString(R.string.green_olive));
                else
                    this.toppings.remove(getString(R.string.green_olive));
                break;
            case R.id.green_pepper:
                if (checked)
                    this.toppings.add(getString(R.string.green_pepper));
                else
                    this.toppings.remove(getString(R.string.green_pepper));
                Log.d(STRING_ARR, String.valueOf(toppings));
                break;
        }
        //after untoggling checkbox, it doesn't remove andd also doesn't log
        Log.d(STRING_ARR, String.valueOf(toppings));
        //if arrayList is null validation
    }


    public double calculateSubtotal(ArrayList<String> list) {
        //click size first
        if(list.size() == 0) {
            subtotal = size_price;
//            Log.d(STRING, "calculateSubtota == 0");
        }
        //click toppings first
        if(list.size() != 0) {
            Log.d(STRING, "calculateSubtotal != 0");
            subtotal = list.size() * TOPPING_PRICE + size_price;
        }
        return subtotal;
    }

    //fix setToppings(), not removing properly
    public void setSubtotal(View view) {
        Log.d(STRING, String.valueOf(view));
//        
        if(((RadioButton) view).isChecked()) {
            setSize(view);
            Log.d(STRING, "setSubtotal - radio");
        }
        else if(((CheckBox) view).isChecked()) {
            setToppings(view);
            Log.d(STRING, "setSubtotal - checkbox");
        }
        calculateSubtotal(toppings);
        strToTextView(String.valueOf(subtotal), R.id.subtotal);
    }

    public void strToTextView(String str, int textViewID) {
        TextView text = (TextView)findViewById(textViewID);
        text.setText(str);
    }

    //set @string/subtotal every time there's a click of radiobutton OR checkbox

    //validations happen after clicking Next button, must click on radioButton before clicking any checkBoxes
    private static void validations() {

    }

}