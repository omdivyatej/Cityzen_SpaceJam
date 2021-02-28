package com.example.cityzen_spacejam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    String category="Other";
    String questionAsked="",categorySelected="";
    Button askButton;
    EditText questiontext;
    Spinner dropdown;
    DatabaseReference mref,mref2,mref3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        askButton=findViewById(R.id.payNow);
        questiontext=findViewById(R.id.editTextTextMultiLine3);
        this.getSupportActionBar().hide();

        // DropDown
        dropdown=findViewById(R.id.spinner);
        String[] category=new String[]{"Category","Transport","Food","Language","Other"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,category);
        dropdown.setAdapter(arrayAdapter);

        //Button
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get question
                questionAsked=questiontext.getText().toString();
                //Get category
                categorySelected=dropdown.getSelectedItem().toString();
                //store Data
                storeData(questionAsked,categorySelected);

                //Show Message
                Toast.makeText(getApplicationContext(), "Question successfully submitted", Toast.LENGTH_SHORT).show();

                //Redirect to forum
                Intent intent=new Intent(getApplicationContext(),ForumActivity.class);
                startActivity(intent);
            }
        });

    }


    public void storeData(String question,String category){
        Random random=new Random();
        String id=String.valueOf(random.nextInt(100));
        mref= FirebaseDatabase.getInstance().getReference().child("Query").child(category).child(id);
        mref2= FirebaseDatabase.getInstance().getReference().child("All").child(id);
        QuestionClass questionSet=new QuestionClass(question);
        mref.setValue(questionSet);
        mref2.setValue(questionSet);


    }

}