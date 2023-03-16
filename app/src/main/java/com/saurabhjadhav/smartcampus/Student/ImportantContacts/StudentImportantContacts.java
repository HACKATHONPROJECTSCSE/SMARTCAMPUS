package com.saurabhjadhav.smartcampus.Student.ImportantContacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StudentImportantContacts extends AppCompatActivity {

    LinearLayout staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_important_contacts);

        staff = findViewById(R.id.Staff);

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentImportantContacts.this, StaffDashBoard.class));
            }
        });


    }
}