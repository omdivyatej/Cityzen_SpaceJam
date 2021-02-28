package com.example.cityzen_spacejam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ForumAnswer extends AppCompatActivity {
    DatabaseReference mref1;
    ArrayAdapter arrayAdapter;
    ListView listView;
    DatabaseReference databaseReference,databaseReference2;
    FloatingActionButton addanotherAnswer;
    TextView questionSelected;
    ArrayList<String> answerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_answer);
        addanotherAnswer=findViewById(R.id.floatingActionButton2);
        questionSelected=findViewById(R.id.textView13);
        this.getSupportActionBar().hide();
        listView=findViewById(R.id.listView);

        Intent intent=getIntent();
        String question=intent.getStringExtra("Question");
        System.out.println(question);
        questionSelected.setText(question);

        answerList=new ArrayList<>();
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,answerList);
        listView.setAdapter(arrayAdapter);

        // Fetch all questions before starting
        fetchData();





    }
    public void fetchData() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Answers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                answerList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    answerclass answerss = dataSnapshot1.getValue(answerclass.class);
                    answerList.add(answerss.getAnswer());
                }
                System.out.println(answerList);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addanotheranswer(View view){
        Intent intent=new Intent(getApplicationContext(),AddAnswer.class);
        startActivity(intent);
    }
}