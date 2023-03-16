package com.saurabhjadhav.smartcampus.Student.Elrc.Entc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.Elrc.StudentElrcHome;


public class Entc extends AppCompatActivity {

    LinearLayout entcsem3, entcsem4, entcsem5, entcsem6, entcsem7, entcsem8;
    ImageView backToSDash;

    String[] Entc_url = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entc);

        entcsem3 = findViewById(R.id.EntcSem3);
        entcsem4 = findViewById(R.id.EntcSem4);
        entcsem5 = findViewById(R.id.EntcSem5);
        entcsem6 = findViewById(R.id.EntcSem6);
        entcsem7 = findViewById(R.id.EntcSem7);
        entcsem8 = findViewById(R.id.EntcSem8);
        backToSDash = findViewById(R.id.BackToSDash);

        Entc_url[0] = "https://sites.google.com/a/git-india.edu.in/elrc/etc-engineering/sem-3-etc-engineering";
        Entc_url[1] = "https://sites.google.com/a/git-india.edu.in/elrc/etc-engineering/sem-4-etc-engineering";
        Entc_url[2] = "https://sites.google.com/a/git-india.edu.in/elrc/etc-engineering/sem-5-etc-engineering";
        Entc_url[3] = "https://sites.google.com/a/git-india.edu.in/elrc/etc-engineering/sem-6-etc-engineering";
        Entc_url[4] = "https://sites.google.com/a/git-india.edu.in/elrc/etc-engineering/sem-7-etc-engineering";
        Entc_url[5] = "https://sites.google.com/a/git-india.edu.in/elrc/etc-engineering/sem-8-etc-engineering";

        entcsem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntcWeb.class);
                intent.putExtra("EntcElrcLinks", Entc_url[0]);
                startActivity(intent);
            }
        });

        entcsem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntcWeb.class);
                intent.putExtra("EntcElrcLinks", Entc_url[1]);
                startActivity(intent);
            }
        });

        entcsem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntcWeb.class);
                intent.putExtra("EntcElrcLinks", Entc_url[2]);
                startActivity(intent);
            }
        });

        entcsem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntcWeb.class);
                intent.putExtra("EntcElrcLinks", Entc_url[3]);
                startActivity(intent);
            }
        });

        entcsem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntcWeb.class);
                intent.putExtra("EntcElrcLinks", Entc_url[4]);
                startActivity(intent);
            }
        });

        entcsem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntcWeb.class);
                intent.putExtra("EntcElrcLinks", Entc_url[5]);
                startActivity(intent);
            }
        });

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Entc.this, StudentElrcHome.class));
                finish();
            }
        });
    }
}