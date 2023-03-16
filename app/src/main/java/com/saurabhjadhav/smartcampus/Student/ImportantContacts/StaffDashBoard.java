package com.saurabhjadhav.smartcampus.Student.ImportantContacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StaffDashBoard extends AppCompatActivity {

    LinearLayout computerStaffContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_dash_board);

        computerStaffContacts = findViewById(R.id.ComputerStaff);

        computerStaffContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffDashBoard.this, ComputerStaffContacts.class));
                finish();

            }
        });
    }
}