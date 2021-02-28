package com.example.cityzen_spacejam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ForumActivity extends AppCompatActivity {
    FloatingActionButton addQuestion;
    ArrayAdapter arrayAdapter,arrayAdapter2;
    ListView listView;
    ArrayList<String> questionList;
    Spinner dropdown;
    DatabaseReference databaseReference,databaseReference2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        this.getSupportActionBar().hide();

        listView=findViewById(R.id.questionList);
        addQuestion=findViewById(R.id.floatingActionButton2);

        // DropDown
        dropdown=findViewById(R.id.spinner2);
        String[] category=new String[]{"All","Food","Transport","Language","Other"};
        arrayAdapter2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,category);
        dropdown.setAdapter(arrayAdapter2);

        // Formatting Question List
        questionList=new ArrayList<>();
        questionList.add("Loading...");
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,questionList);
        listView.setAdapter(arrayAdapter);

        // Fetch all questions before starting
        fetchData();

        //Fetch results according to  your category
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (dropdown.getSelectedItem().toString().equals("All")){
                    fetchData();
                }
                else {
                    fetchData(dropdown.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ForumAnswer.class);
                System.out.println(listView.getItemAtPosition(position).toString());
                intent.putExtra("Question",listView.getItemAtPosition(position).toString());

                startActivity(intent);
            }
        });
        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                startActivity(intent);
            }
        });

    }
    public void askQuestion(View view){

    }
    public void fetchData(String category){
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Query").child(category);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    forumsub questions=dataSnapshot1.getValue(forumsub.class);
                    questionList.add(questions.getQuestion());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void fetchData(){
        databaseReference= FirebaseDatabase.getInstance().getReference().child("All");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    forumsub questions=dataSnapshot1.getValue(forumsub.class);
                    questionList.add(questions.getQuestion());
                }
                System.out.println(questionList);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

}}