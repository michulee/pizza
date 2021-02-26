package com.example.pizzabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }

    //create instance of MainActivity
    //call getSize() and getToppings() in calculateSubtotal() that returns subtotal
    //assume 10% sales tax, return total in calculateTotal()

    //setDescription(), setSubtotal() in both receipt and table, setTax(), setTotal()

    MainActivity data = new MainActivity();

}