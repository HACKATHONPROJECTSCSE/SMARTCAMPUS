package com.saurabhjadhav.smartcampus.Teacher.TeacherWebsite;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class TeacherWebsiteStudent extends AppCompatActivity {

    WebView webViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_website_student);

        webViewStudent = findViewById(R.id.WebViewStudent);

        webViewStudent.setWebViewClient(new WebViewClient());
        webViewStudent.getSettings().setJavaScriptEnabled(true);
        webViewStudent.loadUrl("https://git-website-9a8bf.web.app/");

    }
}