package com.saurabhjadhav.smartcampus.Student.NoticeBoard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class NoticeInfo extends AppCompatActivity {

    TextView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_info);

        backToSDash = findViewById(R.id.GoBack);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoticeInfo.this, DisplayNotice.class));
                finish();
            }
        });
    }
}