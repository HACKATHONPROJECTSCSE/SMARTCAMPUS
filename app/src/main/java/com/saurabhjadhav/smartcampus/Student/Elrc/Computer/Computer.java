package com.saurabhjadhav.smartcampus.Student.Elrc.Computer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.Elrc.StudentElrcHome;

public class Computer extends AppCompatActivity {

    LinearLayout compsem3, compsem4, compsem5, compsem6, compsem7, compsem8;
    ImageView backToSDash;

    String[] Comp_url = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        compsem3 = findViewById(R.id.ComputerSem3);
        compsem4 = findViewById(R.id.ComputerSem4);
        compsem5 = findViewById(R.id.ComputerSem5);
        compsem6 = findViewById(R.id.ComputerSem6);
        compsem7 = findViewById(R.id.ComputerSem7);
        compsem8 = findViewById(R.id.ComputerSem8);
        backToSDash = findViewById(R.id.BackToSDash);

        Comp_url[0] = "https://sites.google.com/a/git-india.edu.in/elrc/computer-engineering_1/sem-3-computer-engineering";
        Comp_url[1] = "https://sites.google.com/a/git-india.edu.in/elrc/computer-engineering_1/sem-4-computer-engineering";
        Comp_url[2] = "https://sites.google.com/a/git-india.edu.in/elrc/computer-engineering_1/sem-5-computer-engineering";
        Comp_url[3] = "https://sites.google.com/a/git-india.edu.in/elrc/computer-engineering_1/sem-6-computer-engineering";
        Comp_url[4] = "https://sites.google.com/a/git-india.edu.in/elrc/computer-engineering_1/sem-7-computer-engineering";
        Comp_url[5] = "https://sites.google.com/a/git-india.edu.in/elrc/computer-engineering_1/sem-8-computer-engineering";

        compsem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerWeb.class);
                intent.putExtra("CompElrcLinks", Comp_url[0]);
                startActivity(intent);
            }
        });

        compsem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerWeb.class);
                intent.putExtra("CompElrcLinks", Comp_url[1]);
                startActivity(intent);
            }
        });

        compsem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerWeb.class);
                intent.putExtra("CompElrcLinks", Comp_url[2]);
                startActivity(intent);
            }
        });

        compsem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerWeb.class);
                intent.putExtra("CompElrcLinks", Comp_url[3]);
                startActivity(intent);
            }
        });

        compsem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerWeb.class);
                intent.putExtra("CompElrcLinks", Comp_url[4]);
                startActivity(intent);
            }
        });

        compsem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ComputerWeb.class);
                intent.putExtra("CompElrcLinks", Comp_url[5]);
                startActivity(intent);
            }
        });

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Computer.this, StudentElrcHome.class));
                finish();
            }
        });
    }
}