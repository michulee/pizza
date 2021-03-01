package com.example.pizzabuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomerPage extends AppCompatActivity {

    private final static String STRING = "STRING";
    private final static String STRING2 = "STRING2";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CLICK = "isClicked";
    private static boolean isClicked = false;

    LinearLayout tbl;
    LinearLayout receipt;
    EditText editName, editPhone, editEmail, editAddress;
    TextView textName, textPhone, textEmail, textAddress;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_page);

        Intent intent = getIntent();
        OrderDetails order = new OrderDetails();

        order.setToppings(intent.getStringArrayListExtra("toppings"));
        order.setSizePrice(intent.getDoubleExtra("size", 0));

        //should be within submitOrder()
        displayDesc(order.getToppings(), order.getSize(), R.id.tblDesc1);
        displayDetails(order.getSubtotal(), R.id.subtotal);
        displayDetails(order.getSubtotal(), R.id.tblPrice1);
        displayDetails(order.getTax(), R.id.tax);
        displayDetails(order.getTotal(), R.id.total);

        initializations();
        Log.d(STRING, "clicked from main");
        if (savedInstanceState != null) {
            isClicked = savedInstanceState.getBoolean(KEY_CLICK);
//            boolean isClicked = savedInstanceState.getBoolean(KEY_CLICK);
            if(isClicked) {
                submitOrder(submit);

                textName.setText(savedInstanceState.getString(KEY_NAME));
                textPhone.setText(savedInstanceState.getString(KEY_PHONE));
                textEmail.setText(savedInstanceState.getString(KEY_EMAIL));
                textAddress.setText(savedInstanceState.getString(KEY_ADDRESS));
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME, String.valueOf(editName.getText()));
        outState.putString(KEY_PHONE, String.valueOf(editPhone.getText()));
        outState.putString(KEY_EMAIL, String.valueOf(editEmail.getText()));
        outState.putString(KEY_ADDRESS, String.valueOf(editAddress.getText()));
        //isClicked not working properly from within submitOrder
//        outState.putBoolean(KEY_CLICK, isClicked);
        if(submit.getVisibility() == View.VISIBLE) {
            outState.putBoolean(KEY_CLICK, false);
        }
         else {
            outState.putBoolean(KEY_CLICK, true);
        }
    }

    public void initializations() {
        tbl = (LinearLayout)findViewById(R.id.tbl);
        receipt = (LinearLayout)findViewById(R.id.receipt);

        tbl.setVisibility(View.GONE);
        receipt.setVisibility(View.GONE);

        editName = (EditText)findViewById(R.id.editName);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editAddress = (EditText)findViewById(R.id.editAddress);

        textName = (TextView)findViewById(R.id.textName);
        textPhone = (TextView)findViewById(R.id.textPhone);
        textEmail = (TextView)findViewById(R.id.textEmail);
        textAddress = (TextView)findViewById(R.id.textAddress);

        submit = (Button)findViewById(R.id.submit);
    }

    //submitOrderVisibility()
    public void submitOrder(View view) {
//        isClicked = true;
        Log.d(STRING, "clicked in submitOrder");
        tbl.setVisibility(View.VISIBLE);
        receipt.setVisibility(View.VISIBLE);

        textName.setVisibility(View.VISIBLE);
        textName.setText(editName.getText());
        editName.setVisibility(View.GONE);

        textPhone.setVisibility(View.VISIBLE);
        textPhone.setText(editPhone.getText());
        editPhone.setVisibility(View.GONE);

        textEmail.setVisibility(View.VISIBLE);
        textEmail.setText(editEmail.getText());
        editEmail.setVisibility(View.GONE);

        textAddress.setVisibility(View.VISIBLE);
        textAddress.setText(editAddress.getText());
        editAddress.setVisibility(View.GONE);

        view.setVisibility(View.GONE);
        // TODO: 2/28/2021 validations, make inputs required
    }

    public void submitOrderText(View view) {

    }

    public void displayDetails(String str, int textViewID) {
        TextView text = (TextView)findViewById(textViewID);
        text.setText(str);
    }

    public void displayDetails(double num, int textViewID) {
        TextView text = (TextView)findViewById(textViewID);
        text.setText(String.valueOf(num));
    }

    public void displayDesc(ArrayList<String> list, String size, int textViewID) {
        TextView view = (TextView)findViewById(textViewID);
        String strList = listWithCommas(list);
        String desc = "";
        if(list.isEmpty()) {
            desc = size.concat(": No Toppings");
        }
        else {
            desc = size.concat(": ").concat(strList);
        }
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