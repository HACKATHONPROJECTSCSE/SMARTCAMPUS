package com.saurabhjadhav.smartcampus.Student.DeveloperInfo;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class DeveloperInfo extends AppCompatActivity {

    TextView detailsText1, detailsText2, detailsText3, detailsText4;
    LinearLayout layout2;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_info);
/*
        detailsText1 = findViewById(R.id.detailsHide);
        detailsText2 = findViewById(R.id.detailsHide2);
        detailsText4 = findViewById(R.id.detailsHide);
        layout = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);

        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    public void Expand(View view) {
        int v = (detailsText1.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText1.setVisibility(v);
    }

    public void Expand2(View view) {
        int v = (detailsText2.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText2.setVisibility(v);
    }

    public void Expand3(View view) {
        int v = (detailsText3.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText3.setVisibility(v);
    }

    public void Expand4(View view) {
        int v = (detailsText4.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText4.setVisibility(v);

 */
    }
}