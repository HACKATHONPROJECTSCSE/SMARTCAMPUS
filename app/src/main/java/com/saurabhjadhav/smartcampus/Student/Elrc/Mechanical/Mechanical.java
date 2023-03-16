package com.saurabhjadhav.smartcampus.Student.Elrc.Mechanical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.Elrc.StudentElrcHome;

public class Mechanical extends AppCompatActivity {

    LinearLayout mechsem3, mechsem4, mechsem5, mechsem6, mechsem7, mechsem8;
    ImageView backToSDash;

    String[] Mech_url = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical);

        mechsem3 = findViewById(R.id.MechanicalSem3);
        mechsem4 = findViewById(R.id.MechanicalSem4);
        mechsem5 = findViewById(R.id.MechanicalSem5);
        mechsem6 = findViewById(R.id.MechanicalSem6);
        mechsem7 = findViewById(R.id.MechanicalSem7);
        mechsem8 = findViewById(R.id.MechanicalSem8);
        backToSDash = findViewById(R.id.BackToSDash);

        Mech_url[0] = "https://sites.google.com/a/git-india.edu.in/elrc/mechanical-engineering/sem-3-mechanical-engineering";
        Mech_url[1] = "https://sites.google.com/a/git-india.edu.in/elrc/mechanical-engineering/sem-4-mechanical-engineering";
        Mech_url[2] = "https://sites.google.com/a/git-india.edu.in/elrc/mechanical-engineering/sem-5-mechanical-engineering";
        Mech_url[3] = "https://sites.google.com/a/git-india.edu.in/elrc/mechanical-engineering/sem-6-mechanical-engineering";
        Mech_url[4] = "https://sites.google.com/a/git-india.edu.in/elrc/mechanical-engineering/sem-7-mechanical-engineering";
        Mech_url[5] = "https://sites.google.com/a/git-india.edu.in/elrc/mechanical-engineering/sem-8-mechanical-engineering";

        mechsem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MechanicalWeb.class);
                intent.putExtra("MechElrcLinks", Mech_url[0]);
                startActivity(intent);
            }
        });

        mechsem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MechanicalWeb.class);
                intent.putExtra("MechElrcLinks", Mech_url[1]);
                startActivity(intent);
            }
        });

        mechsem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MechanicalWeb.class);
                intent.putExtra("MechElrcLinks", Mech_url[2]);
                startActivity(intent);
            }
        });

        mechsem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MechanicalWeb.class);
                intent.putExtra("MechElrcLinks", Mech_url[3]);
                startActivity(intent);
            }
        });

        mechsem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MechanicalWeb.class);
                intent.putExtra("MechElrcLinks", Mech_url[4]);
                startActivity(intent);
            }
        });

        mechsem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MechanicalWeb.class);
                intent.putExtra("MechElrcLinks", Mech_url[5]);
                startActivity(intent);
            }
        });

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mechanical.this, StudentElrcHome.class));
                finish();
            }
        });
    }
}