package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.Elrc.StudentElrcHome;

public class StudentElrcFEHome extends AppCompatActivity {

    LinearLayout elrcFeSem1, elrcFeSem1A, elrcFeSem1B, elrcFeSem2A, elrcFeSem2B, elrcFeSem2C;
    ImageView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fehome);

        elrcFeSem1 = findViewById(R.id.ElrcFeSem1);
        elrcFeSem1A = findViewById(R.id.ElrcFeSem1A);
        elrcFeSem1B = findViewById(R.id.ElrcFeSem1B);


        elrcFeSem2A = findViewById(R.id.ElrcFeSem2A);
        elrcFeSem2B = findViewById(R.id.ElrcFeSem2B);
        elrcFeSem2C = findViewById(R.id.ElrcFeSem2C);

        backToSDash = findViewById(R.id.BackToSDash);


        elrcFeSem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcFeSem1A.class));
            }
        });

        elrcFeSem1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcFeSem1B.class));
            }
        });

        elrcFeSem1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcFeSem1C.class));
            }
        });

        elrcFeSem2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcFeSem2A.class));
            }
        });

        elrcFeSem2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcFeSem2B.class));
            }
        });

        elrcFeSem2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcFeSem2C.class));
            }
        });

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcFEHome.this, StudentElrcHome.class));
                finish();
            }
        });

    }
}