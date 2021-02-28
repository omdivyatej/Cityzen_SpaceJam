package com.example.cityzen_spacejam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class top10 extends AppCompatActivity {
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);
        this.getSupportActionBar().hide();
        listView=findViewById(R.id.questionList);

        arrayList=new ArrayList<>();
        arrayList.add("Barthira - Will you come?");
        arrayList.add("Barella - Won't Come");
        arrayList.add("Yelli Hogebeku - Where do you wanna go? ");arrayList.add("Bega Hogi - Go fast");arrayList.add(" Jasti - A little more");arrayList.add("Swalpa - A little less");arrayList.add("Namaskara - Namaste");arrayList.add("Banni - Come");
        arrayList.add("Hogi - Go");

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}