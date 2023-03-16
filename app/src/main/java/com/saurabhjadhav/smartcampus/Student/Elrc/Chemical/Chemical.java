package com.saurabhjadhav.smartcampus.Student.Elrc.Chemical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.Elrc.StudentElrcHome;

public class Chemical extends AppCompatActivity {

    LinearLayout chemsem3, chemsem4, chemsem5, chemsem6, chemsem7, chemsem8;
    ImageView backToSDash;

    String[] Chem_url = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical);

        chemsem3 = findViewById(R.id.ChemicalSem3);
        chemsem4 = findViewById(R.id.ChemicalSem4);
        chemsem5 = findViewById(R.id.ChemicalSem5);
        chemsem6 = findViewById(R.id.ChemicalSem6);
        chemsem7 = findViewById(R.id.ChemicalSem7);
        chemsem8 = findViewById(R.id.ChemicalSem8);
        backToSDash = findViewById(R.id.BackToSDash);

        Chem_url[0] = "https://sites.google.com/a/git-india.edu.in/elrc/chemical-engineering/sem-3-chemical-engineering";
        Chem_url[1] = "https://sites.google.com/a/git-india.edu.in/elrc/chemical-engineering/sem-4-chemical-engineering";
        Chem_url[2] = "https://sites.google.com/a/git-india.edu.in/elrc/chemical-engineering/sem-5-chemical-engineering";
        Chem_url[3] = "https://sites.google.com/a/git-india.edu.in/elrc/chemical-engineering/sem-6-chemical-engineering";
        Chem_url[4] = "https://sites.google.com/a/git-india.edu.in/elrc/chemical-engineering/sem-7-chemical-engineering";
        Chem_url[5] = "https://sites.google.com/a/git-india.edu.in/elrc/chemical-engineering/sem-8-chemical-engineering";

        chemsem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChemicalWeb.class);
                intent.putExtra("ElrcLinks", Chem_url[0]);
                startActivity(intent);
            }
        });

        chemsem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChemicalWeb.class);
                intent.putExtra("ElrcLinks", Chem_url[1]);
                startActivity(intent);
            }
        });

        chemsem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChemicalWeb.class);
                intent.putExtra("ElrcLinks", Chem_url[2]);
                startActivity(intent);
            }
        });

        chemsem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChemicalWeb.class);
                intent.putExtra("ElrcLinks", Chem_url[3]);
                startActivity(intent);
            }
        });

        chemsem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChemicalWeb.class);
                intent.putExtra("ElrcLinks", Chem_url[4]);
                startActivity(intent);
            }
        });

        chemsem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChemicalWeb.class);
                intent.putExtra("ElrcLinks", Chem_url[5]);
                startActivity(intent);
            }
        });

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chemical.this, StudentElrcHome.class));
                finish();
            }
        });

    }
}