package com.saurabhjadhav.smartcampus.Teacher.TeacherCampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Teacher.TeacherDashboard;

public class TeacherCampus extends AppCompatActivity {

    LinearLayout collegeCampusImages, collegeHostelImages;
    ImageView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_campus);

        collegeCampusImages = findViewById(R.id.CollegeCampusImages);
        collegeHostelImages = findViewById(R.id.CollegeHostelImages);
        backToSDash = findViewById(R.id.BackToSDash);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherCampus.this, TeacherDashboard.class));
                finish();
            }
        });

        collegeCampusImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherCampus.this, TeacherCampusImages.class));
            }
        });

        collegeHostelImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherCampus.this, TeacherCampusHostelImages.class));
            }
        });


    }
}