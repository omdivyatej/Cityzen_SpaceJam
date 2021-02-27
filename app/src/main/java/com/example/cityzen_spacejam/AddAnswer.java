package com.example.forum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAnswer extends AppCompatActivity {
    DatabaseReference mref1;
    String k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);


        Intent intent=new Intent();
        k=intent.getStringExtra("Question");
        System.out.println(k);
    }
    public void addAnswer(){
        //mref1= FirebaseDatabase.getInstance().getReference().child("Query")
    }

}