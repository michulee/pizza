package com.example.pizzabuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerPage extends AppCompatActivity {

    private final static String STRING = "STRING";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ADDRESS = "address";

    private String pizzaDetails = "";

    LinearLayout tbl;
    LinearLayout receipt;
    EditText editName, editPhone, editEmail, editAddress;
    TextView textName, textPhone, textEmail, textAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_page);



        Intent intent = getIntent();
        OrderDetails order = new OrderDetails();

        String subtotal = intent.getStringExtra("subtotal");
        displayDetails(String.valueOf(subtotal), R.id.subtotal);

        ArrayList<String> toppings = intent.getStringArrayListExtra("toppings");
        order.setToppings(toppings);
        double size = intent.getDoubleExtra("size", 0);
        order.setSizePrice(size);

        displayDetails(order.getToppings(), order.getSize(), R.id.tblDesc1);
        displayDetails(order.getSubtotal(), R.id.tblPrice1);
        displayDetails(order.getTax(), R.id.tax);
        displayDetails(order.getTotal(), R.id.total);

        tbl = (LinearLayout)findViewById(R.id.tbl);
        receipt = (LinearLayout)findViewById(R.id.receipt);
        tbl.setVisibility(View.GONE);
        receipt.setVisibility(View.GONE);

        editName = (EditText)findViewById(R.id.editName);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editAddress = (EditText)findViewById(R.id.editAddress);
        // TODO: 2/28/2021 save state of making all editText disappear and setting TextViews

        textName = (TextView)findViewById(R.id.textName);
        textPhone = (TextView)findViewById(R.id.textPhone);
        textEmail = (TextView)findViewById(R.id.textEmail);
        textAddress = (TextView)findViewById(R.id.textAddress);

        if (savedInstanceState != null) {
            //setText to all TextViews

            //str is empty
            String name = savedInstanceState.getString("KEY_NAME");
//            textName.setText(name);
            textName.setText(savedInstanceState.getString(KEY_NAME));
            editName.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //save all input
        outState.putString(KEY_NAME, String.valueOf(editName.getText()));
        outState.putString(KEY_PHONE, String.valueOf(editPhone.getText()));
        outState.putString(KEY_EMAIL, String.valueOf(editEmail.getText()));
        outState.putString(KEY_ADDRESS, String.valueOf(editAddress.getText()));

    }

    public void submitOrder(View view) {
        view.setVisibility(View.GONE);
        tbl.setVisibility(View.VISIBLE);
        receipt.setVisibility(View.VISIBLE);

        textName.setText(editName.getText());
        editName.setVisibility(View.GONE);

        textPhone.setText(editPhone.getText());
        editPhone.setVisibility(View.GONE);

        textEmail.setText(editEmail.getText());
        editEmail.setVisibility(View.GONE);

        textAddress.setText(editAddress.getText());
        editAddress.setVisibility(View.GONE);
        // TODO: 2/28/2021 validations, make inputs required
    }

    public void required() {

    }

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
        return appendStr;
    }


}