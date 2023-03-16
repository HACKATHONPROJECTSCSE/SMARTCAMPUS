package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StudentElrcFeSem2B extends AppCompatActivity {

    WebView webViewFeSem2B;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fe_sem2_b);

        webViewFeSem2B = findViewById(R.id.WebViewFeSem2B);

        webViewFeSem2B.setWebViewClient(new WebViewClient());
        webViewFeSem2B.getSettings().setJavaScriptEnabled(true);
        webViewFeSem2B.loadUrl("https://sites.google.com/a/git-india.edu.in/elrc/first-year-engineering_1/fe-semester-ii-div-b");
    }
}