package com.example.forum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ForumAnswer extends AppCompatActivity {
    DatabaseReference mref1;
    ArrayAdapter arrayAdapter;
    ListView listView;
    FloatingActionButton addanotherAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_answer);
        addanotherAnswer=findViewById(R.id.floatingActionButton2);



    }
    public void fetchAnswers(){
        //mref1= FirebaseDatabase.getInstance().getReference();
    }
    public void addanotheranswer(View view){
        Intent intent=new Intent(getApplicationContext(),AddAnswer.class);
        startActivity(intent);
    }
}