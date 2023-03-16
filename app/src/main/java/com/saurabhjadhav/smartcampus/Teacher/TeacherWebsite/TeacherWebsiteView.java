package com.saurabhjadhav.smartcampus.Teacher.TeacherWebsite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Teacher.TeacherDashboard;

public class TeacherWebsiteView extends AppCompatActivity {

    ImageView backToSDash;
    LinearLayout officialWebsite, studentWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_website_view);

        backToSDash = findViewById(R.id.BackToSDash);
        officialWebsite = findViewById(R.id.OfficialWebsite);
        studentWebsite = findViewById(R.id.StudentWebsite);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherWebsiteView.this, TeacherDashboard.class));
                finish();
            }
        });

        officialWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherWebsiteView.this, TeacherWebsiteOfficial.class));
            }
        });

        studentWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherWebsiteView.this, TeacherWebsiteStudent.class));
            }
        });
    }
}