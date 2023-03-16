package com.saurabhjadhav.smartcampus.Student.ImportantContacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class SecurityContacts extends AppCompatActivity {

    Button bhuranSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_contacts);

        bhuranSv = findViewById(R.id.bhuran);

        bhuranSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent1 = new Intent(Intent.ACTION_DIAL);
                callIntent1.setData(Uri.parse("tel:" + "7038840067"));
                startActivity(callIntent1);
            }
        });
    }
}