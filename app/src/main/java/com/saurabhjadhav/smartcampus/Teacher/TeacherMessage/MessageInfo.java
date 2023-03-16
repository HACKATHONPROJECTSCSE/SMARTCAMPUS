package com.saurabhjadhav.smartcampus.Teacher.TeacherMessage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class MessageInfo extends AppCompatActivity {

    TextView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_info);

        backToSDash = findViewById(R.id.GoBack);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MessageInfo.this, TeacherMessageSender.class));
                finish();
            }
        });
    }
}