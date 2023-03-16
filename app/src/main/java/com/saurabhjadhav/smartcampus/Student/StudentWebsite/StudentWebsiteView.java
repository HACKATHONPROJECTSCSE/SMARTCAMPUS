package com.saurabhjadhav.smartcampus.Student.StudentWebsite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentDashboard;

public class StudentWebsiteView extends AppCompatActivity {

    // private AdView mAdView;

    ImageView backToSDash;
    LinearLayout officialWebsite, studentWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_website_view);

        backToSDash = findViewById(R.id.BackToSDash);
        officialWebsite = findViewById(R.id.OfficialWebsite);
        studentWebsite = findViewById(R.id.StudentWebsite);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentWebsiteView.this, StudentDashboard.class));
                finish();
            }
        });

        officialWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentWebsiteView.this, StudentWebsiteOfficial.class));
            }
        });

        studentWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentWebsiteView.this, StudentWebsiteStudent.class));
            }
        });

        // BANNER ADS START

        /* MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });


        // BANNER ADS END <------------------------------------------>

         */


    }
}