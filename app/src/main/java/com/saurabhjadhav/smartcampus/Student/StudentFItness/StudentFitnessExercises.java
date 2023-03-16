package com.saurabhjadhav.smartcampus.Student.StudentFItness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentDashboard;

public class StudentFitnessExercises extends AppCompatActivity {

    ImageView backToSDash;
    RelativeLayout running, skipping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_fitness_exercises);

        running = findViewById(R.id.Running);
        skipping = findViewById(R.id.Skipping);
        backToSDash = findViewById(R.id.BackToSDash);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentFitnessExercises.this, StudentDashboard.class));
                finish();
            }
        });

        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentFitnessExercises.this, StudentFitnessTimer.class));
            }
        });

        skipping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentFitnessExercises.this, StudentFitnessTimer.class));
            }
        });
    }
}