package com.saurabhjadhav.smartcampus.Student.StudentGatePass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.saurabhjadhav.smartcampus.R;

import java.util.HashMap;
import java.util.Map;

public class StudentGatepass extends AppCompatActivity {

    TextInputLayout fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;
    Button sendBtn;
    boolean valid = true;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_gatepass);

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

        // FIREBASE

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FullName = fullName.getEditText().toString();

                FirebaseAuth fAuth;
                fAuth = FirebaseAuth.getInstance();
                //  String user = fAuth.getCurrentUser().getUid();

                FirebaseUser user = fAuth.getCurrentUser();

                String finalData = "FULL NAME : " + fullName.getEditText().getText().toString() + " \n " + "HOSTEL NAME : " + hostelName.getEditText().getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"SaurabhJadhav.cse@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "GATEPASS FROM " + fullName.getEditText().getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, finalData);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


                DocumentReference df = fStore.collection("GatePass").document(user.getUid());
                Map<String, Object> userInfo = new HashMap<>();

                userInfo.put("FullName", fullName.getEditText().getText().toString().trim());
                userInfo.put("HostelName", hostelName.getEditText().getText().toString().trim());
                userInfo.put("Branch", branch.getEditText().getText().toString().trim());
                userInfo.put("Year", year.getEditText().getText().toString().trim());
                userInfo.put("FloorNo", floorNo.getEditText().getText().toString().trim());
                userInfo.put("RoomNo", roomNo.getEditText().getText().toString().trim());
                userInfo.put("ContactNo", contactNo.getEditText().getText().toString().trim());
                userInfo.put("ParentsContactNo", parentContactNo.getEditText().getText().toString().trim());
                userInfo.put("Reason", reason.getEditText().getText().toString().trim());
                userInfo.put("PlaceOfVisit", placeOfVisit.getEditText().getText().toString().trim());
                userInfo.put("LeaveDate", leaveDate.getEditText().getText().toString().trim());
                userInfo.put("LeaveTime", leaveTime.getEditText().getText().toString().trim());
                userInfo.put("ReturnDate", returnDate.getEditText().getText().toString().trim());
                userInfo.put("ReturnTime", returnTime.getEditText().getText().toString().trim());

                df.set(userInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(StudentGatepass.this, "Sent", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StudentGatepass.this, "Failed To Send", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}