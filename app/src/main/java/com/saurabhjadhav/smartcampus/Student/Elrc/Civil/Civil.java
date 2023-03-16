package com.saurabhjadhav.smartcampus.Student.Elrc.Civil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;


public class Civil extends AppCompatActivity {

    LinearLayout civilsem3, civilsem4, civilsem5, civilsem6, civilsem7, civilsem8;
    ImageView backToDash;

    String[] Civil_url = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);

        civilsem3 = findViewById(R.id.CivilSem3);
        civilsem4 = findViewById(R.id.CivilSem4);
        civilsem5 = findViewById(R.id.CivilSem5);
        civilsem6 = findViewById(R.id.CivilSem6);
        civilsem7 = findViewById(R.id.CivilSem7);
        civilsem8 = findViewById(R.id.CivilSem8);


        Civil_url[0] = "https://sites.google.com/a/git-india.edu.in/elrc/civil-engineering_1/sem-3-civil-engineering";
        Civil_url[1] = "https://sites.google.com/a/git-india.edu.in/elrc/civil-engineering_1/sem-4-civil-engineering";
        Civil_url[2] = "https://sites.google.com/a/git-india.edu.in/elrc/civil-engineering_1/sem-5-civil-engineering";
        Civil_url[3] = "https://sites.google.com/a/git-india.edu.in/elrc/civil-engineering_1/sem-6-civil-engineering";
        Civil_url[4] = "https://sites.google.com/a/git-india.edu.in/elrc/civil-engineering_1/sem-7-civil-engineering";
        Civil_url[5] = "https://sites.google.com/a/git-india.edu.in/elrc/civil-engineering_1/sem-8-civil-engineering";


        civilsem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CivilWeb.class);
                intent.putExtra("CivilElrcLinks", Civil_url[0]);
                startActivity(intent);
            }
        });

        civilsem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CivilWeb.class);
                intent.putExtra("CivilElrcLinks", Civil_url[1]);
                startActivity(intent);
            }
        });

        civilsem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CivilWeb.class);
                intent.putExtra("CivilElrcLinks", Civil_url[2]);
                startActivity(intent);
            }
        });

        civilsem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CivilWeb.class);
                intent.putExtra("CivilElrcLinks", Civil_url[3]);
                startActivity(intent);
            }
        });

        civilsem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CivilWeb.class);
                intent.putExtra("CivilElrcLinks", Civil_url[4]);
                startActivity(intent);
            }
        });

        civilsem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CivilWeb.class);
                intent.putExtra("CivilElrcLinks", Civil_url[5]);
                startActivity(intent);
            }
        });


    }
}