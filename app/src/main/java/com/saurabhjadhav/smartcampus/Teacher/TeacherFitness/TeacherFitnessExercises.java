package com.saurabhjadhav.smartcampus.Teacher.TeacherFitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentFItness.StudentFitnessTimer;
import com.saurabhjadhav.smartcampus.Teacher.TeacherDashboard;

public class TeacherFitnessExercises extends AppCompatActivity {

    ImageView backToSDash;
    RelativeLayout running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_fitness_exercises);

        running = findViewById(R.id.Running);
        backToSDash = findViewById(R.id.BackToSDash);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherFitnessExercises.this, TeacherDashboard.class));
                finish();
            }
        });

        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherFitnessExercises.this, StudentFitnessTimer.class));
            }
        });
    }
}