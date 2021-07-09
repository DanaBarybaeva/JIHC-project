package com.example.adminjihcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KezekshilikPage extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase sqLiteDatabase;

    TextInputEditText person, dataa, timee;
    FirebaseAuth fauth;
    DatabaseReference realtimeDB;
    Kezekshi kezekshi;
    String childName;
    Button buttonadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kezekshilik_page);
        dataa = findViewById(R.id.datakengizu);
        person = findViewById(R.id.personengizu);
        timee = findViewById(R.id.timekengizu);


        buttonadd = findViewById(R.id.buttonadd);
        fauth = FirebaseAuth.getInstance();
        buttonadd.setOnClickListener(this);

        realtimeDB = FirebaseDatabase.getInstance().getReference();
    }
    private void insertData() {
        String datakadd = dataa.getText().toString();
        String timekengizuu = timee.getText().toString();
        String personadd = person.getText().toString();


        kezekshi = new Kezekshi(datakadd,timekengizuu,personadd);
        childName = kezekshi.getDayk().replace(".","-");


        realtimeDB.child("kezekshilik").child(String.valueOf(childName)).setValue(kezekshi);
        Toast.makeText(KezekshilikPage.this, "Success", Toast.LENGTH_SHORT).show();


    }





    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(dataa.getText())) {
            dataa.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(timee.getText())) {
            timee.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(person.getText())) {
            person.setError("Tolyq emes");
            return;
        }
        startActivity(new Intent(KezekshilikPage.this,MainActivity.class));



        insertData();

    }

}
