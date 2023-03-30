package com.saurabhjadhav.smartcampus.Student.GatePassFinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saurabhjadhav.smartcampus.R;

import java.util.UUID;

public class GatePassDashboardFinal extends AppCompatActivity {

    TextInputLayout fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;
    Button sendBtn;
    private String userId,userID;
    private UserGatepass entreeGatepass, entree2;

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    Intent intent = new Intent(GatePassDashboardFinal.this, GatepassStatus.class);
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
        setContentView(R.layout.activity_gate_pass_dashboard_final);

        fullName = findViewById(R.id.registerName);
        hostelName = findViewById(R.id.registerHostelName);
        branch = findViewById(R.id.registerBranch);
        year = findViewById(R.id.registerYear);
        floorNo = findViewById(R.id.registerFloorNo);
        roomNo = findViewById(R.id.registerRoomNo);
        contactNo = findViewById(R.id.registerContact);
        parentContactNo = findViewById(R.id.registerParentsContact);
        reason = findViewById(R.id.registerReason);
        placeOfVisit = findViewById(R.id.registerPlaceOfVisit);
        leaveDate = findViewById(R.id.registerLeavePremisesOnDate);
        leaveTime = findViewById(R.id.registerLeavePremisesOnTime);
        returnDate = findViewById(R.id.registerReturnPremisesOnDate);
        returnTime = findViewById(R.id.registerReturnPremisesOnTime);

        sendBtn = findViewById(R.id.sendBtn);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        userID = UUID.randomUUID().toString();

        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = database.child("Gatepass").child(userId);
        DatabaseReference myRef2 = database.child("GatepassNew");

        BottomNavigationView navigationGatepass = findViewById(R.id.navigation);
        navigationGatepass.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entreeGatepass = new UserGatepass(userId, fullName.getEditText().getText().toString().trim(),
                        hostelName.getEditText().getText().toString().trim(),
                        branch.getEditText().getText().toString().trim(),
                        year.getEditText().getText().toString().trim(),
                        floorNo.getEditText().getText().toString().trim(),
                        roomNo.getEditText().getText().toString().trim(),
                        contactNo.getEditText().getText().toString().trim(),
                        parentContactNo.getEditText().getText().toString().trim(),
                        reason.getEditText().getText().toString().trim(),
                        placeOfVisit.getEditText().getText().toString().trim(),
                        leaveDate.getEditText().getText().toString().trim(),
                        leaveTime.getEditText().getText().toString().trim(),
                        returnDate.getEditText().getText().toString().trim(),
                        returnTime.getEditText().getText().toString().trim());

                myRef.child(userId).setValue(entreeGatepass);

                entree2 = new UserGatepass(userID, fullName.getEditText().getText().toString().trim(),
                        hostelName.getEditText().getText().toString().trim(),
                        branch.getEditText().getText().toString().trim(),
                        year.getEditText().getText().toString().trim(),
                        floorNo.getEditText().getText().toString().trim(),
                        roomNo.getEditText().getText().toString().trim(),
                        contactNo.getEditText().getText().toString().trim(),
                        parentContactNo.getEditText().getText().toString().trim(),
                        reason.getEditText().getText().toString().trim(),
                        placeOfVisit.getEditText().getText().toString().trim(),
                        leaveDate.getEditText().getText().toString().trim(),
                        leaveTime.getEditText().getText().toString().trim(),
                        returnDate.getEditText().getText().toString().trim(),
                        returnTime.getEditText().getText().toString().trim());

                myRef2.child(userID).setValue(entree2);

            }
        });

    }
}