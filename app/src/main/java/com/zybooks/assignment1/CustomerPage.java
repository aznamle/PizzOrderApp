package com.zybooks.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchUIUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomerPage extends AppCompatActivity {

    TextView receipt, textname, textphone, textemail, textaddress, size, toppings, total;
    EditText name, phone, email, address;
    PizzaModel pizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);

        Button submit = (Button) findViewById(R.id.order);

        pizza = new PizzaModel();

        receipt = (TextView) findViewById(R.id.receipt);

        //customer information textviews
        textname = (TextView) findViewById(R.id.textname);
        textphone = (TextView) findViewById(R.id.textphone);
        textemail = (TextView) findViewById(R.id.textemail);
        textaddress = (TextView) findViewById(R.id.textaddress);

        //order information textviews
        size = (TextView) findViewById(R.id.size);
        toppings = (TextView) findViewById(R.id.toppings);
        total = (TextView) findViewById(R.id.totalprice);

        //inputs
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set into PizzaModel
                pizza.setName(name.getText().toString());
                pizza.setPhone(phone.getText().toString());
                pizza.setEmail(email.getText().toString());
                pizza.setAddress(address.getText().toString());

                //Pull data from MainActivity
                Intent intent = getIntent();
                Double price = intent.getDoubleExtra("price", 0);
                String rSize = intent.getStringExtra("size");
                String rToppings = intent.getStringExtra("toppings");

                receipt.setVisibility(View.VISIBLE);

                //set information to textviews for display
                textname.setText(pizza.name);
                textphone.setText(pizza.phone);
                textemail.setText(pizza.email);
                textaddress.setText(pizza.address);
                size.setText(rSize);
                toppings.setText(rToppings);

                total.setText("Total: "+ "$" + String.format("%.2f",price));
            }
        });
    }


    //save state after rotation
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String sReceipt = receipt.getText().toString();
        outState.putString("sReceipt", sReceipt);

        //customer information
        String sName = textname.getText().toString();
        outState.putString("sName", sName);
        String sPhone = textphone.getText().toString();
        outState.putString("sPhone", sPhone);
        String sEmail = textemail.getText().toString();
        outState.putString("sEmail", sEmail);
        String sAddress = textaddress.getText().toString();
        outState.putString("sAddress", sAddress);

        //order information
        String sSize = size.getText().toString();
        outState.putString("sSize", sSize);
        String sToppings = toppings.getText().toString();
        outState.putString("sToppings", sToppings);
        String sTotal = total.getText().toString();
        outState.putString("sTotal", sTotal);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        receipt.setText(savedInstanceState.getString("sReceipt"));

        //customer information
        textname.setText(savedInstanceState.getString("sName"));
        textphone.setText(savedInstanceState.getString("sPhone"));
        textemail.setText(savedInstanceState.getString("sEmail"));
        textaddress.setText(savedInstanceState.getString("sAddress"));

        //order information
        size.setText(savedInstanceState.getString("sSize"));
        toppings.setText(savedInstanceState.getString("sToppings"));
        total.setText(savedInstanceState.getString("sTotal"));

    }
}