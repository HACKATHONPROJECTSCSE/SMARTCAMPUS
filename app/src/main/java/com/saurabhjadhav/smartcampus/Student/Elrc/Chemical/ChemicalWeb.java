package com.saurabhjadhav.smartcampus.Student.Elrc.Chemical;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class ChemicalWeb extends AppCompatActivity {

    WebView chemWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_web);

        chemWeb = findViewById(R.id.ChemWeb);

        Intent intent = getIntent();
        String elrc = intent.getStringExtra("ElrcLinks");
        chemWeb.loadUrl(elrc);
        chemWeb.setWebViewClient(new WebViewClient());
        chemWeb.getSettings().setJavaScriptEnabled(true);
    }
}