package com.example.adminjihcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TulekterEngizu extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase sqLiteDatabase;
    Button btnok;
    TextInputEditText namee, prof, year;
    FirebaseAuth fauth;
    DatabaseReference realtimeDB;
    Tulekter tulekter;
    String childName;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tulekter_engizu);

        namee = findViewById(R.id.nametulekengizu);
        prof = findViewById(R.id.profengizu);
        year = findViewById(R.id.yearengizu);



        insert = findViewById(R.id.btninsert);
        fauth = FirebaseAuth.getInstance();
        insert.setOnClickListener(this);

        realtimeDB = FirebaseDatabase.getInstance().getReference();
    }

    private void insertData() {
        String name = namee.getText().toString();
        String proff = prof.getText().toString();
        String yeaar = year.getText().toString();



        tulekter = new Tulekter(name,proff,yeaar);
        childName = tulekter.getName();


        realtimeDB.child("tulekter").child(String.valueOf(childName)).setValue(tulekter);
        Toast.makeText(TulekterEngizu.this, "Success", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(TulekterEngizu.this,MainActivity.class));



        insertData();

    }
}