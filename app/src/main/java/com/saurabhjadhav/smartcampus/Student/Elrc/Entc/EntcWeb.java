package com.saurabhjadhav.smartcampus.Student.Elrc.Entc;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class EntcWeb extends AppCompatActivity {

    WebView entcWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entc_web);

        entcWeb = findViewById(R.id.EntcWeb);

        Intent intent = getIntent();
        String elrc = intent.getStringExtra("EntcElrcLinks");
        entcWeb.loadUrl(elrc);
        entcWeb.setWebViewClient(new WebViewClient());
        entcWeb.getSettings().setJavaScriptEnabled(true);
    }
}