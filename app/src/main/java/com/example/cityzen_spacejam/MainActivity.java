package com.example.cityzen_spacejam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button places,local,forum,bookfood,top10,hospitals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        places=findViewById(R.id.places);
        local=findViewById(R.id.localrefresh);
        hospitals=findViewById(R.id.hospital);
        bookfood=findViewById(R.id.bookfood);
        forum=findViewById(R.id.forum);
        top10=findViewById(R.id.words);

        bookfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BookRestaurant.class);
                startActivity(intent);
            }
        });
        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForumActivity.class);
                startActivity(intent);
            }
        });
        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),placestovisit.class);
                startActivity(intent);
            }
        });
        hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Hospitals.class);
                startActivity(intent);
            }
        });
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),localrefresh.class);
                startActivity(intent);
            }
        });
        top10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),top10.class);
                startActivity(intent);
            }
        });




    }
}