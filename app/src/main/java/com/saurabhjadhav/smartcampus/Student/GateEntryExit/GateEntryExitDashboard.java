package com.saurabhjadhav.smartcampus.Student.GateEntryExit;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.models.User;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.utils.CommonProgressDialog;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.utils.SendMail;

import java.util.UUID;

public class GateEntryExitDashboard extends AppCompatActivity {

    private TextView hostName, hostEmail, hostPhone, visitorName, visitorEmail, visitorPhone;
    private Toolbar toolbar;
    private Button checkInButton;
    private FirebaseAuth mAuth;
    private Dialog progressDialog;
    private String userId;
    private SmsManager smsManager;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private User entree;
    SendMail sendMail;

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    Intent intent = new Intent(GateEntryExitDashboard.this, CheckOutActivity.class);
                    startActivity(intent);
                    finish();
                    return true;

            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate_entry_exit_dashboard);
        Intent i = getIntent();
        userId = UUID.randomUUID().toString();
        progressDialog = CommonProgressDialog.LoadingSpinner(GateEntryExitDashboard.this);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        hostName = findViewById(R.id.host_name);
        hostEmail = findViewById(R.id.host_email);
        hostPhone = findViewById(R.id.host_phone);
        visitorName = findViewById(R.id.visitor_name);
        visitorPhone = findViewById(R.id.visitor_phone);
        visitorEmail = findViewById(R.id.visitor_email);
        checkInButton = findViewById(R.id.check_in_button);
        //disableAutofill();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        checkInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndSet()) {
                    entree = new User(userId, visitorName.getText().toString(), visitorEmail.getText().toString(), visitorPhone.getText().toString(), hostName.getText().toString(), hostEmail.getText().toString(), hostPhone.getText().toString());
                    myRef.child(userId).setValue(entree);

                    sendMail = new SendMail(GateEntryExitDashboard.this, entree.getHostEmail(), "Your Meeting Details", createMsg(entree));

                    sendSms();
                    reset();
                }
            }
        });
    }

    /*@TargetApi(Build.VERSION_CODES.O)
    private void disableAutofill() {
        getWindow().getDecorView().setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
    }*/

    private void sendSms() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        } else {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(entree.getHostPhone(), null, createMsg(entree), null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
            sendMail.execute();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        progressDialog.show();
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(entree.getHostPhone(), null, createMsg(entree), null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    sendMail.execute();
                } else {
                    progressDialog.dismiss();
                    sendMail.execute();
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }


    private String createMsg(User entree) {
        String s = "Guest Checked in"
                + "\nGuest Name: " + entree.getVisitorName()
                + "\nGuest Phone: " + entree.getVisitorPhone()
                + "\nGuest Email: " + entree.getVisitorEmail();
        return s;
    }

    private void reset() {
        userId = UUID.randomUUID().toString();
        hostName.setText("");
        hostEmail.setText("");
        hostPhone.setText("");
        visitorEmail.setText("");
        visitorName.setText("");
        visitorPhone.setText("");
    }

    private boolean checkAndSet() {
        if (hostName.getText() == null
                || hostEmail.getText() == null
                || hostPhone.getText() == null
                || visitorEmail.getText() == null
                || visitorName.getText() == null
                || visitorPhone.getText() == null) {
            return false;
        } else if (hostName.getText().toString().equals("")
                || hostEmail.getText().toString().equals("")
                || hostPhone.getText().toString().equals("")
                || visitorEmail.getText().toString().equals("")
                || visitorName.getText().toString().equals("")
                || visitorPhone.getText().toString().equals("")) {
            Toast.makeText(GateEntryExitDashboard.this, "Missing Fields", Toast.LENGTH_LONG).show();
            return false;
        } else if (!hostEmail.getText().toString().contains("@") || !visitorEmail.getText().toString().contains("@")) {
            Toast.makeText(GateEntryExitDashboard.this, "Enter Valid Email address", Toast.LENGTH_LONG).show();
            return false;
        } else if (hostPhone.getText().toString().length() != 10 || visitorPhone.getText().toString().length() != 10) {
            Toast.makeText(GateEntryExitDashboard.this, "Enter Valid Phone number", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }

}
