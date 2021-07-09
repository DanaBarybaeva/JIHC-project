package com.example.adminjihcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMugalimder,btnNews,btnregistrationOkushy,BtnregistrationMugalim,zhinalystar,kezek,tulekter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMugalimder = findViewById(R.id.buttonmugalimder);
        btnMugalimder.setOnClickListener(this);

        tulekter  =findViewById(R.id.tulekteradd);
        tulekter.setOnClickListener(this);

        btnregistrationOkushy= findViewById(R.id.buttonregistration);
        btnregistrationOkushy.setOnClickListener(this);

        kezek  =findViewById(R.id.Kezekshilik);
        kezek.setOnClickListener(this);


        BtnregistrationMugalim= findViewById(R.id.buttonregistrMugalim);
        BtnregistrationMugalim.setOnClickListener(this);


        btnNews= findViewById(R.id.buttonnews);
        btnNews.setOnClickListener(this);

        zhinalystar = findViewById(R.id.Zhinalystar);
        zhinalystar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {


            if (v.getId() == R.id.buttonmugalimder) {
                Intent tikelu = new Intent(MainActivity.this, MugalimderEngizu.class);
                startActivity(tikelu);
            }
            else if (v.getId() == R.id.buttonnews) {
                Intent tikelu = new Intent(MainActivity.this, NewsPage.class);
                startActivity(tikelu);

            }
            else if (v.getId() == R.id.buttonregistration) {
                Intent tikelu = new Intent(MainActivity.this, RegistrationOkushy.class);
                startActivity(tikelu);
            }
            else if (v.getId() == R.id.buttonregistrMugalim) {
                Intent tikelu = new Intent(MainActivity.this, RegistrationMugalimder.class);
                startActivity(tikelu);
            }
            else if (v.getId() == R.id.Zhinalystar) {
                Intent tikelu = new Intent(MainActivity.this, ZhinalysEngizu.class);
                startActivity(tikelu);
            }
            else if (v.getId() == R.id.Kezekshilik) {
                Intent tikelu = new Intent(MainActivity.this, KezekshilikPage.class);
                startActivity(tikelu);
            }
            else if (v.getId() == R.id.tulekteradd) {
                Intent tikelu = new Intent(MainActivity.this, TulekterEngizu.class);
                startActivity(tikelu);
            }
        }
    }

