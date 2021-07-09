package com.example.adminjihcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class ZhinalysEngizu extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase sqLiteDatabase;
    Button btnok;
    TextInputEditText place, data, time,participants;
    FirebaseAuth fauth;
    DatabaseReference realtimeDB;
    Zhinalys zhinalys;
    String childName;
    Button add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhinalys_engizu);
        data = findViewById(R.id.dataengizu);
        place = findViewById(R.id.placeengizu);
        time = findViewById(R.id.timeengizu);
        participants = findViewById(R.id.participantsengizu);


        add = findViewById(R.id.btnengizu);
        fauth = FirebaseAuth.getInstance();
        add.setOnClickListener(this);

        realtimeDB = FirebaseDatabase.getInstance().getReference();
    }
    private void insertData() {
        String dataadd = data.getText().toString();
        String timeengizuu = time.getText().toString();
        String placeadd = place.getText().toString();
        String participantss = participants.getText().toString();


        zhinalys = new Zhinalys(dataadd,timeengizuu,placeadd,participantss);
        childName = zhinalys.getData().replace(".","-");


        realtimeDB.child("zhinalystar").child(String.valueOf(childName)).setValue(zhinalys);
        Toast.makeText(ZhinalysEngizu.this, "Success", Toast.LENGTH_SHORT).show();


    }





    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(data.getText())) {
            data.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(time.getText())) {
            time.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(place.getText())) {
            place.setError("Tolyq emes");
            return;
        }  if (TextUtils.isEmpty(participants.getText())) {
            participants.setError("Tolyq emes");
            return;
        }
        startActivity(new Intent(ZhinalysEngizu.this,MainActivity.class));



        insertData();

    }

    }
