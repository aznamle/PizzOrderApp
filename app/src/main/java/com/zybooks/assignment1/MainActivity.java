package com.zybooks.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    PizzaModel pizza;
    double total_price;

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6;
    Button next;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = new PizzaModel();

        radioGroup = findViewById(R.id.radioGroup);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);

        next = findViewById(R.id.next);

        next.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomerPage.class);

                //radio
                RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
                int checkedId = radiogroup.getCheckedRadioButtonId();

                //logic
                double total_price = 0;
                String toppings = "";

                //radio group
                if(checkedId == R.id.rb1) {
                    pizza.setSize_price(10);
                    pizza.setSize("Small - $10");
                } else if (checkedId == R.id.rb2) {
                    pizza.setSize_price(12);
                    pizza.setSize("Medium - $12");
                } else if (checkedId == R.id.rb3) {
                    pizza.setSize_price(14);
                    pizza.setSize("Large - $14");
                }

                //checkbox
                if(cb1.isChecked()) {
                    pizza.setCb1(3);
                    toppings += "Pepperoni - $3\n";
                } else {
                    pizza.setCb1(0);
                }
                if(cb2.isChecked()) {
                    pizza.setCb2(3);
                    toppings += "Chicken - $3\n";
                } else {
                    pizza.setCb2(0);
                }
                if(cb3.isChecked()) {
                    pizza.setCb3(3);
                    toppings += "Mushroom - $3\n";
                } else {
                    pizza.setCb3(0);
                }
                if(cb4.isChecked()) {
                    pizza.setCb4(2);
                    toppings += "Green Pepper - $2\n";
                } else {
                    pizza.setCb4(0);
                }
                if(cb5.isChecked()) {
                    pizza.setCb5(2);
                    toppings += "Olive - $2\n";
                } else {
                    pizza.setCb5(0);
                }
                if(cb6.isChecked()) {
                    pizza.setCb6(2);
                    toppings += "Extra Cheese - $2\n";
                } else {
                    pizza.setCb6(0);
                }

                //pass data to customer page
                intent.putExtra("price", calculate_total());
                intent.putExtra("size", pizza.getSize());
                intent.putExtra("toppings", toppings);
                startActivity(intent);
            }
        }));

    }

    public double calculate_total() {
        total_price = pizza.getSize_price()
                +pizza.getCb1()
                +pizza.getCb2()
                +pizza.getCb3()
                +pizza.getCb4()
                +pizza.getCb5()
                +pizza.getCb6();
        return total_price;
    }

}
