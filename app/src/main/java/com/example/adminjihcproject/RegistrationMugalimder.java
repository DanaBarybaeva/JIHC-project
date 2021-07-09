package com.example.adminjihcproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.adminjihcproject.R;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationMugalimder extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase sqLiteDatabase;
    Button registrmugalim;
    TextInputEditText idmugalimtexxt, namemugalimtexxt, groupmugalimtexxt,emailmugalimtexxt,sabaqmugalimtexxt,passwordMugalim;
    FirebaseAuth fauth;
    DatabaseReference realtimeDB;
    User user;
    MugalimInfo MugalimInfo;
    String emailFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_mugalimder);
        initWidgets();

        registrmugalim.setOnClickListener(this);

        realtimeDB = FirebaseDatabase.getInstance().getReference();
    }

    private void initWidgets() {
        namemugalimtexxt = findViewById(R.id.nameMugalim);
        idmugalimtexxt= findViewById(R.id.idMugalim);
        groupmugalimtexxt = findViewById(R.id.groupMualim);
        passwordMugalim = findViewById(R.id.passwordMugalim);
        emailmugalimtexxt = findViewById(R.id.emailMugalim);
        sabaqmugalimtexxt = findViewById(R.id.sabaqMugalim);

        registrmugalim = findViewById(R.id.registrmugalim);

        fauth = FirebaseAuth.getInstance();
    }

    private void insertData() {
        String emailMugalim = emailmugalimtexxt.getText().toString();
        String idMugalim = idmugalimtexxt.getText().toString();
        String nameMugalim = namemugalimtexxt.getText().toString();

        String sabaqMugalim = sabaqmugalimtexxt.getText().toString();
        String kurator = groupmugalimtexxt.getText().toString();

        String passwordmugalim = passwordMugalim.getText().toString();




        MugalimInfo = new MugalimInfo(emailMugalim,idMugalim,nameMugalim,sabaqMugalim,kurator,passwordmugalim);
        emailFormat = MugalimInfo.getMugalimEmail().replace(".","-");
        realtimeDB.child("mugalim").child(emailFormat).setValue(MugalimInfo);
        Toast.makeText(RegistrationMugalimder.this, "Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(namemugalimtexxt.getText())) {
            namemugalimtexxt.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(idmugalimtexxt.getText())) {
            idmugalimtexxt.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(groupmugalimtexxt.getText())) {
            groupmugalimtexxt.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(passwordMugalim.getText())) {
            passwordMugalim.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(emailmugalimtexxt.getText())) {
            emailmugalimtexxt.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(sabaqmugalimtexxt.getText())) {
            sabaqmugalimtexxt.setError("Tolyq emes");
            return;
        }



        insertData();

        String emailMugalim = emailmugalimtexxt.getText().toString();
        String passwordmugalim =passwordMugalim.getText().toString();

        CreateAccount(emailMugalim,passwordmugalim);


    }

    private void CreateAccount(String emailMugalim, String passwordmugalim) {
        fauth.createUserWithEmailAndPassword(emailMugalim, passwordmugalim)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegistrationMugalimder.this, "Welcome", Toast.LENGTH_SHORT).show();


                            startActivity(new Intent(RegistrationMugalimder.this, MainActivity.class));
                        }
                        else {
                            Toast.makeText(RegistrationMugalimder.this, "Error" + task.toString(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}