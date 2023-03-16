package com.saurabhjadhav.smartcampus.Student.Elrc.Mechanical;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class MechanicalWeb extends AppCompatActivity {

    WebView mechWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical_web);

        mechWeb = findViewById(R.id.MechWeb);

        Intent intent = getIntent();
        String elrc = intent.getStringExtra("MechElrcLinks");
        mechWeb.loadUrl(elrc);
        mechWeb.setWebViewClient(new WebViewClient());
        mechWeb.getSettings().setJavaScriptEnabled(true);
    }
}