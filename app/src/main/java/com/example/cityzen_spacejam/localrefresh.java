package com.example.cityzen_spacejam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class localrefresh extends AppCompatActivity {
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localrefresh);
        this.getSupportActionBar().hide();
        listView=findViewById(R.id.questionList);

        arrayList=new ArrayList<>();
        arrayList.add("General Refreshments- \n SN Refreshments, LalBagh");
        arrayList.add("Shopping -\n Commercial Street \n MG Road Jaynagar \n Gandhi Bazzar");
        arrayList.add("Good Meal- \n Cable Car \n Truffles \n Polar Bear");
        arrayList.add("Major Attraction:\n ISCKON Temple \n Take a walk,Grab a coffee");


        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}