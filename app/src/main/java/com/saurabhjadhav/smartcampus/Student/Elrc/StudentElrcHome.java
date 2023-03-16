package com.saurabhjadhav.smartcampus.Student.Elrc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.Elrc.Chemical.Chemical;
import com.saurabhjadhav.smartcampus.Student.Elrc.Civil.Civil;
import com.saurabhjadhav.smartcampus.Student.Elrc.Computer.Computer;
import com.saurabhjadhav.smartcampus.Student.Elrc.Entc.Entc;
import com.saurabhjadhav.smartcampus.Student.Elrc.FE.StudentElrcFEHome;
import com.saurabhjadhav.smartcampus.Student.Elrc.Mechanical.Mechanical;
import com.saurabhjadhav.smartcampus.Student.StudentDashboard;

public class StudentElrcHome extends AppCompatActivity {

    LinearLayout elrcFirstYear, chemical, computer, mechanical, entc, civil;
    ImageView backToSDash;

    // private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_elrc_home);

        elrcFirstYear = findViewById(R.id.ElrcFirstYear);
        chemical = findViewById(R.id.ElrcChemicalEngineering);
        mechanical = findViewById(R.id.ElrcMechanicalEngineering);
        computer = findViewById(R.id.ElrcComputerEngineering);
        entc = findViewById(R.id.ElrcEntcEngineering);
        civil = findViewById(R.id.ElrcCivilEngineering);

        backToSDash = findViewById(R.id.BackToSDash);


        elrcFirstYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, StudentElrcFEHome.class));
            }
        });

        chemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, Chemical.class));
            }
        });

        mechanical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, Mechanical.class));
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, Computer.class));
            }
        });

        entc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, Entc.class));
            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, Civil.class));
            }
        });


        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentElrcHome.this, StudentDashboard.class));
                finish();
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
