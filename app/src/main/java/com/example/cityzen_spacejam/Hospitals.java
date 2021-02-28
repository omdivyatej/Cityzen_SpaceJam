package com.example.cityzen_spacejam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Hospitals extends AppCompatActivity {
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        this.getSupportActionBar().hide();

        listView=findViewById(R.id.questionList);

        arrayList=new ArrayList<>();
        arrayList.add("Manipal Hospital \n \n -No. 71, 11th Main Rd, Opp Railway Station, Malleshwaram, Bengaluru, Karnataka 560003");
        arrayList.add("Apollo Hospitals \n \n - #21/2, 14th Cross Road, near Madhavan Park Circle, Jayanagar East, Jayanagar, Bengaluru, Karnataka 560011");
        arrayList.add("Fortis \n \n - : Building No. 119, Survey No, 23, 80 Feet Main Rd, 2nd Stage, Naagarabhaavi, Bengaluru, Karnataka 560072");

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}