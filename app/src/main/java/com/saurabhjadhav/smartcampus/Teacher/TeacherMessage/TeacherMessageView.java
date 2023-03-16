package com.saurabhjadhav.smartcampus.Teacher.TeacherMessage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Teacher.TeacherDashboard;

public class TeacherMessageView extends AppCompatActivity {

    LinearLayout sendMessage, seeMessage;
    ImageView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_message_view);

        sendMessage = findViewById(R.id.SendMessage);
        seeMessage = findViewById(R.id.SeeMessage);
        backToSDash = findViewById(R.id.BackToSDash);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherMessageView.this, TeacherDashboard.class));
                finish();
            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherMessageView.this, TeacherMessageSender.class));
            }
        });

        seeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherMessageView.this, TeacherMessageSee.class));
            }
        });


    }
}