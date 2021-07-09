package com.example.adminjihcproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationOkushy extends AppCompatActivity  implements View.OnClickListener {


    SQLiteDatabase sqLiteDatabase;
    Button registr;
    TextInputEditText name, idStudent, kuratorStudent,iinStudent, password,emailStudent,groupStudent;
    FirebaseAuth fauth;
    DatabaseReference realtimeDB;
    User user;
    StudentsUser studentsUser;
    String emailFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_okushy);
        initWidgets();
        registr.setOnClickListener(this);

        realtimeDB = FirebaseDatabase.getInstance().getReference();

    }

    public void initWidgets() {

        name = findViewById(R.id.nameStudent);
        idStudent= findViewById(R.id.idStudent);
        kuratorStudent = findViewById(R.id.kurator);
        password = findViewById(R.id.passwordStudent);
        iinStudent = findViewById(R.id.iinStudent);
        emailStudent = findViewById(R.id.emailStudent);
        groupStudent = findViewById(R.id.groupStudent);
        registr = findViewById(R.id.registr);
        password = findViewById(R.id.passwordStudent);
        fauth = FirebaseAuth.getInstance();

    }

    //
    private void insertData() {

        String namee = name.getText().toString();
        Long idstudent = Long.parseLong(idStudent.getText().toString());
        String kuratorstudent = kuratorStudent.getText().toString();


        Long iinstudent = Long.parseLong(iinStudent.getText().toString());
        String groupstudent = groupStudent.getText().toString();
        String emaill = emailStudent.getText().toString();
        String passwordd = password.getText().toString();


        studentsUser = new StudentsUser(namee,idstudent,kuratorstudent,iinstudent,groupstudent,emaill,passwordd);
        emailFormat = studentsUser.getEmail().replace(".","-");
        realtimeDB.child("student").child(emailFormat).setValue(studentsUser);
        Toast.makeText(RegistrationOkushy.this, "Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(name.getText())) {
            name.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(idStudent.getText())) {
            idStudent.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(kuratorStudent.getText())) {
            kuratorStudent.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(iinStudent.getText())) {
            iinStudent.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(groupStudent.getText())) {
            groupStudent.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(emailStudent.getText())) {
            emailStudent.setError("Tolyq emes");
            return;
        }
        if (TextUtils.isEmpty(password.getText())) {
            password.setError("Tolyq emes");
            return;
        }


        insertData();

        String emailk = emailStudent.getText().toString();
        String passwordk = password.getText().toString();

        CreateAccount(emailk,passwordk);




    }

    private void CreateAccount(String emailkg, String passwordkg) {
        fauth.createUserWithEmailAndPassword(emailkg, passwordkg)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegistrationOkushy.this, "Welcome", Toast.LENGTH_SHORT).show();


                            startActivity(new Intent(RegistrationOkushy.this, MainActivity.class));
                        }
                        else {
                            Toast.makeText(RegistrationOkushy.this, "Error" + task.toString(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });






    }
//    private void insertData() {
//
//        String namee = name.getText().toString();
//        Long idstudent = Long.parseLong(idStudent.getText().toString());
//        String kuratorstudent = kuratorStudent.getText().toString();
//        String passwordd = password.getText().toString();
//
//        Long iinstudent = Long.parseLong(iinStudent.getText().toString());
//        String groupstudent = groupStudent.getText().toString();
//        String emaill = emailStudent.getText().toString();
//
//
//        studentsUser = new StudentsUser(namee, idstudent,kuratorstudent,iinstudent,groupstudent,emaill,passwordd);
//        emailFormat = studentsUser.getEmail().replace(".","-");
//        realtimeDB.child("student").child(emailFormat).setValue(studentsUser);
//        Toast.makeText(registration.this, "Success", Toast.LENGTH_SHORT).show();
//
//    }
}