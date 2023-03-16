package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StudentElrcFeSem1C extends AppCompatActivity {

    WebView webViewFeSem1C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fe_sem1_c);

        webViewFeSem1C = findViewById(R.id.WebViewFeSem1C);

        webViewFeSem1C.setWebViewClient(new WebViewClient());
        webViewFeSem1C.getSettings().setJavaScriptEnabled(true);
        webViewFeSem1C.loadUrl("https://sites.google.com/a/git-india.edu.in/elrc/first-year-engineering_1/fe-semester-i-div-c");


    }
}