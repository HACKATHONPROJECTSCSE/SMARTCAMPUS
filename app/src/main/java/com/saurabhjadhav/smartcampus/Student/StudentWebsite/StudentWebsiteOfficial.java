package com.saurabhjadhav.smartcampus.Student.StudentWebsite;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StudentWebsiteOfficial extends AppCompatActivity {

    WebView webViewOfficial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_website_official);

        webViewOfficial = findViewById(R.id.WebViewOfficial);

        webViewOfficial.setWebViewClient(new WebViewClient());
        webViewOfficial.getSettings().setJavaScriptEnabled(true);
        webViewOfficial.loadUrl("http://git-india.edu.in/git/index.html");

    }
}