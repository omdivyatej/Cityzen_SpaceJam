package com.example.cityzen_spacejam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BookRestaurant extends AppCompatActivity {
    Spinner spinner3,spinner4,spinner5;
    Button payNow;
    TextView uniqueId,totalAmount;
    ArrayAdapter arrayAdapter3,arrayAdapter4,arrayAdapter5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_restaurant);
        this.getSupportActionBar().hide();
        spinner3=findViewById(R.id.spinner3);
        spinner4=findViewById(R.id.spinner4);
        spinner5=findViewById(R.id.spinner5);
        uniqueId=findViewById(R.id.textView7);
        totalAmount=findViewById(R.id.textView6);

        String[] outlet=new String[]{"7 to One","Burger Bun","Aloha","Tea Leaf"};
        String[] food_item=new String[]{"Burger","Pizza","Dosa","Pastry","Soda","Chicken Curry"};
        Integer[] quantity=new Integer[]{1,2,3,4,5,6};

        payNow=findViewById(R.id.payNow);

        arrayAdapter3=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,outlet);
        spinner3.setAdapter(arrayAdapter3);

        arrayAdapter4=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,food_item);
        spinner4.setAdapter(arrayAdapter4);

        arrayAdapter5=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,quantity);
        spinner5.setAdapter(arrayAdapter5);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int quantity=Integer.valueOf(spinner5.getSelectedItem().toString());
                int totalAmountpaid=quantity*20;
                totalAmount.setText("Your Total:" +totalAmountpaid );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Booking Confirmed. Remember your ID and show it to the vendor to access your order", Toast.LENGTH_LONG).show();
                Random random=new Random();
                int id=random.nextInt(1000);
                uniqueId.setText("Your ID:" +id);
            }
        });

    }
}