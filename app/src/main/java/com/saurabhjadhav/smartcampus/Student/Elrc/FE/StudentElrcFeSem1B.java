package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;


public class StudentElrcFeSem1B extends AppCompatActivity {

    WebView webViewFeSem1B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fe_sem1_b);

        webViewFeSem1B = findViewById(R.id.WebViewFeSem1B);

        webViewFeSem1B.setWebViewClient(new WebViewClient());
        webViewFeSem1B.getSettings().setJavaScriptEnabled(true);
        webViewFeSem1B.loadUrl("https://sites.google.com/a/git-india.edu.in/elrc/first-year-engineering_1/fe-semester-i-div-b");
    }
}