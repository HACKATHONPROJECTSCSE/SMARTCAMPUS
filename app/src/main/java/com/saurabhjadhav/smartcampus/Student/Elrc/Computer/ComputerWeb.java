package com.saurabhjadhav.smartcampus.Student.Elrc.Computer;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;


public class ComputerWeb extends AppCompatActivity {

    WebView compWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_web);

        compWeb = findViewById(R.id.CompWeb);

        Intent intent = getIntent();
        String elrc = intent.getStringExtra("CompElrcLinks");
        compWeb.loadUrl(elrc);
        compWeb.setWebViewClient(new WebViewClient());
        compWeb.getSettings().setJavaScriptEnabled(true);

    }
}