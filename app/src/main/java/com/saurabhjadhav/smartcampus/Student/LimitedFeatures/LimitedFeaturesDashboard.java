package com.saurabhjadhav.smartcampus.Student.LimitedFeatures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.Authentication.Register;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentCampus.StudentCampus;
import com.saurabhjadhav.smartcampus.Student.StudentWebsite.StudentWebsiteView;

public class LimitedFeaturesDashboard extends AppCompatActivity {

    LinearLayout campusView, websiteView;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limited_features_dashboard);

        campusView = findViewById(R.id.CampusView);
        websiteView = findViewById(R.id.WebsiteView);
        register = findViewById(R.id.registerBtn);

        campusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LimitedFeaturesDashboard.this, StudentCampus.class));
            }
        });

        websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LimitedFeaturesDashboard.this, StudentWebsiteView.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LimitedFeaturesDashboard.this, Register.class));
            }
        });
    }
}