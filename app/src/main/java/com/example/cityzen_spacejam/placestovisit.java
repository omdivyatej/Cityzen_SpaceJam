package com.example.cityzen_spacejam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class placestovisit extends AppCompatActivity {
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placestovisit);
        this.getSupportActionBar().hide();
        listView=findViewById(R.id.questionList);

        arrayList=new ArrayList<>();
        arrayList.add("MG Road - 5 hrs.");
        arrayList.add("Kormangla - 5 hrs.");
        arrayList.add("Planeterium - 3 hrs.");
        arrayList.add("Vidhan Soubha - 3 hrs.");
        arrayList.add("Bannerghetta National Park - 7 hrs.");
        arrayList.add("LalBagh - 4 hrs.");

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}