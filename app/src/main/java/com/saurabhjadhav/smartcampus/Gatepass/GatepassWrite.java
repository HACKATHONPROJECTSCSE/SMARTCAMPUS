package com.saurabhjadhav.smartcampus.Gatepass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.saurabhjadhav.smartcampus.R;

public class GatepassWrite extends AppCompatActivity {

    TextInputLayout fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;
    Button sendBtn;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatepass_write);


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
                saveGatepass();
            }
        });

    }

    private void saveGatepass() {

        String finalData = "FULL NAME : " + fullName.getEditText().getText().toString()
                + " \n " + "HOSTEL NAME : " + hostelName.getEditText().getText().toString()
                + " \n " + "BRANCH : " + branch.getEditText().getText().toString()
                + " \n " + "YEAR : " + year.getEditText().getText().toString()
                + " \n " + "FLOOR NO : " + floorNo.getEditText().getText().toString()
                + " \n " + "ROOM NO : " + roomNo.getEditText().getText().toString()
                + " \n " + "CONTACT NO : " + contactNo.getEditText().getText().toString()
                + " \n " + "PARENTS CONTACT NO : " + parentContactNo.getEditText().getText().toString()
                + " \n " + "REASON FOR LEAVING : " + reason.getEditText().getText().toString()
                + " \n " + "PLACE OF VISIT : " + placeOfVisit.getEditText().getText().toString()
                + " \n " + "LEAVE PREMISES ON : " + placeOfVisit.getEditText().getText().toString()
                + " \n " + "LEAVE TIME : " + placeOfVisit.getEditText().getText().toString()
                + " \n " + "RETURN PREMISES ON : " + placeOfVisit.getEditText().getText().toString()
                + " \n " + "RETURN TIME : " + placeOfVisit.getEditText().getText().toString();


        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"SaurabhJadhav.cse@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "GATEPASS FROM " + fullName.getEditText().getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, finalData);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

        String Fullname = fullName.getEditText().getText().toString().trim();
        String HostelName = hostelName.getEditText().getText().toString().trim();
        String Branch = branch.getEditText().getText().toString().trim();
        String Year = year.getEditText().getText().toString().trim();
        String FloorNo = floorNo.getEditText().getText().toString().trim();
        String RoomNo = roomNo.getEditText().getText().toString().trim();
        String ContactNo = contactNo.getEditText().getText().toString().trim();
        String ParentContactNo = parentContactNo.getEditText().getText().toString().trim();
        String Reason = reason.getEditText().getText().toString().trim();
        String PlaceOfVisit = placeOfVisit.getEditText().getText().toString().trim();
        String LeaveDate = leaveDate.getEditText().getText().toString().trim();
        String LeaveTime = leaveTime.getEditText().getText().toString().trim();
        String ReturnDate = returnDate.getEditText().getText().toString().trim();
        String ReturnTime = returnTime.getEditText().getText().toString().trim();

        CollectionReference gatepassRef = FirebaseFirestore.getInstance().collection("GatepassNew");
        gatepassRef.add(new GatepassModel(Fullname, HostelName, Branch, Year, FloorNo, RoomNo, ContactNo, ParentContactNo, Reason, PlaceOfVisit, LeaveDate, LeaveTime, ReturnDate, ReturnTime));
        Toast.makeText(this, "Gatepass Added", Toast.LENGTH_SHORT).show();
    }
}