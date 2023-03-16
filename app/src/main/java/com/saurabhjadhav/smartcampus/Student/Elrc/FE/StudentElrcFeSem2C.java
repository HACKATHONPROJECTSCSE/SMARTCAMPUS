package com.saurabhjadhav.smartcampus.Student.Elrc.FE;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class StudentElrcFeSem2C extends AppCompatActivity {

    WebView webViewFeSem2C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_fe_sem2_c);

        webViewFeSem2C = findViewById(R.id.WebViewFeSem2C);

        webViewFeSem2C.setWebViewClient(new WebViewClient());
        webViewFeSem2C.getSettings().setJavaScriptEnabled(true);
        webViewFeSem2C.loadUrl("https://sites.google.com/a/git-india.edu.in/elrc/first-year-engineering_1/fe-semester-ii-div-c");
    }
}
