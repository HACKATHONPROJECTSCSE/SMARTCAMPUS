package com.saurabhjadhav.smartcampus.Student.Sheild;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.saurabhjadhav.smartcampus.R;

import java.util.HashSet;
import java.util.Set;

public class SheildDashboard extends AppCompatActivity implements View.OnClickListener {

    FusedLocationProviderClient fusedLocationClient;
    String myLocation = "", numberCall;
    SmsManager manager = SmsManager.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheilddashboard);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        findViewById(R.id.panicBtn).setOnClickListener(this);
        findViewById(R.id.fourth).setOnClickListener(this);
        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.fifth).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.fourth) {
            startActivity(new Intent(SheildDashboard.this, LawsActivity.class));
            SheildDashboard.this.finish();
        } else if (id == R.id.first) {
            startActivity(new Intent(SheildDashboard.this, ContactActivity.class));
            SheildDashboard.this.finish();
        } else if (id == R.id.fifth) {
            startActivity(new Intent(SheildDashboard.this, SelfDefenseActivity.class));
        } else if (id == R.id.second) {
            startActivity(new Intent(SheildDashboard.this, SmsActivity.class));
            SheildDashboard.this.finish();
        } else if (id == R.id.panicBtn) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
                if (location != null) {
                    location.getAltitude();
                    location.getLongitude();
                    myLocation = "http://maps.google.com/maps?q=loc:" + location.getLatitude() + "," + location.getLongitude();
                } else {
                    myLocation = "Unable to Find Location :(";
                }
                sendMsg();
            });
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            numberCall = sharedPreferences.getString("firstNumber", "None");
            if (!numberCall.equalsIgnoreCase("None")) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + numberCall));
                startActivity(intent);
            }

        }


    }

    void sendMsg() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Set<String> oldNumbers = sharedPreferences.getStringSet("enumbers", new HashSet<>());
        if (!oldNumbers.isEmpty()) {
            for (String ENUM : oldNumbers)
                manager.sendTextMessage(ENUM, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
        }
    }
}