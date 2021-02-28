package com.example.cityzen_spacejam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class AddAnswer extends AppCompatActivity {

    String k;
    String category="Other";
    String questionanswers="",categorySelected="";
    Button payNow;
    EditText questionanswertext;
    Spinner dropdown;
    DatabaseReference mref,mref2,mref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);
        this.getSupportActionBar().hide();
        payNow=findViewById(R.id.payNow);
        questionanswertext=findViewById(R.id.editTextTextMultiLine3);

        Intent intent=getIntent();
        k=intent.getStringExtra("Question");
        System.out.println(k);

        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get question
                questionanswers=questionanswertext.getText().toString();

                //store Data
                storeData(questionanswers);

                //Show Message
                Toast.makeText(getApplicationContext(), "Answer successfully submitted", Toast.LENGTH_SHORT).show();

                //Redirect to forum
                Intent intent=new Intent(getApplicationContext(),ForumAnswer.class);
                startActivity(intent);
            }
        });
    }

    public void storeData(String answer){
        Random random=new Random();
        String id=String.valueOf(random.nextInt(100));
        mref=FirebaseDatabase.getInstance().getReference().child("Answers").child(id);
        answerclass answers=new answerclass(answer);
        mref.setValue(answers);



    }

}