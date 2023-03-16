package com.saurabhjadhav.smartcampus.Student.ImportantContacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class ComputerStaffContacts extends AppCompatActivity {

    Button oakSir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_contacts);

        oakSir = findViewById(R.id.oakSir);

        oakSir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent1 = new Intent(Intent.ACTION_DIAL);
                callIntent1.setData(Uri.parse("tel:" + "123456789"));
                startActivity(callIntent1);
            }
        });

    }
}