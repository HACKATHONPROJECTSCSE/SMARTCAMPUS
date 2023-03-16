package com.saurabhjadhav.smartcampus.Student.Elrc.Civil;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;


public class CivilWeb extends AppCompatActivity {

    WebView civilWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_web);

        civilWeb = findViewById(R.id.CivilWeb);

        Intent intent = getIntent();
        String elrc = intent.getStringExtra("CivilElrcLinks");
        civilWeb.loadUrl(elrc);
        civilWeb.setWebViewClient(new WebViewClient());
        civilWeb.getSettings().setJavaScriptEnabled(true);
    }
}