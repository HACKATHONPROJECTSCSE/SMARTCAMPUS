package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StudentElrcFeSem1A extends AppCompatActivity {

    WebView webViewFeSem1A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fe_sem1);

        webViewFeSem1A = findViewById(R.id.WebViewFeSem1A);

        webViewFeSem1A.setWebViewClient(new WebViewClient());
        webViewFeSem1A.getSettings().setJavaScriptEnabled(true);
        webViewFeSem1A.loadUrl("https://sites.google.com/a/git-india.edu.in/elrc/first-year-engineering_1/fe-semester-i-div-a");
    }
}