package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;


public class StudentElrcFeSem2A extends AppCompatActivity {

    WebView webViewFeSem2A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fe_sem2);

        webViewFeSem2A = findViewById(R.id.WebViewFeSem2A);

        webViewFeSem2A.setWebViewClient(new WebViewClient());
        webViewFeSem2A.getSettings().setJavaScriptEnabled(true);
        webViewFeSem2A.loadUrl("https://sites.google.com/a/git-india.edu.in/elrc/first-year-engineering_1/fe-semester-ii-div-a");
    }
}