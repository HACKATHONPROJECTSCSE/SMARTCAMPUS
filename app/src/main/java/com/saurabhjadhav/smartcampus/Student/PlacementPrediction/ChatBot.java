package com.saurabhjadhav.smartcampus.Student.PlacementPrediction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.saurabhjadhav.smartcampus.R;

public class ChatBot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);




        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("https://friday-mu.vercel.app/");

    }
}