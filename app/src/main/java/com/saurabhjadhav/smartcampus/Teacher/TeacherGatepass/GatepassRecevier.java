package com.saurabhjadhav.smartcampus.Teacher.TeacherGatepass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentGatePass.Reject;
import com.saurabhjadhav.smartcampus.Student.StudentGatePass.SendAcceptedMessage;

public class GatepassRecevier extends AppCompatActivity {

    TextView fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    String userId;
    FirebaseUser firebaseUser;

    Button acceptBtn, rejectBtn;

    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    String user = fAuth.getCurrentUser().getUid();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference myTaskRef = db.collection("GatePass");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatepass_recevier);

        fullName = findViewById(R.id.name);
        hostelName = findViewById(R.id.hostelName);
        branch = findViewById(R.id.branchName);
        year = findViewById(R.id.year);
        floorNo = findViewById(R.id.floorNo);
        roomNo = findViewById(R.id.roomNo);
        contactNo = findViewById(R.id.contactNo);
        parentContactNo = findViewById(R.id.parentsContactNo);
        reason = findViewById(R.id.reason);
        placeOfVisit = findViewById(R.id.place);
        leaveDate = findViewById(R.id.leaveDate);
        leaveTime = findViewById(R.id.leaveTime);
        returnDate = findViewById(R.id.returnDate);
        returnTime = findViewById(R.id.returnTime);

        acceptBtn = findViewById(R.id.acceptBtn);
        rejectBtn = findViewById(R.id.rejectBtn);

        // FIREBASE
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = firebaseAuth.getCurrentUser().getUid();
        firebaseUser = firebaseAuth.getCurrentUser();


        // RETRIEVE USER DATA

        DocumentReference documentReference = firebaseFirestore.collection("GatePass").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(@NonNull DocumentSnapshot documentSnapshot) {
                fullName.setText(documentSnapshot.getString("FullName"));
                hostelName.setText(documentSnapshot.getString("HostelName"));
                branch.setText(documentSnapshot.getString("Branch"));
                year.setText(documentSnapshot.getString("Year"));
                floorNo.setText(documentSnapshot.getString("FloorNo"));
                roomNo.setText(documentSnapshot.getString("RoomNo"));
                contactNo.setText(documentSnapshot.getString("ContactNo"));
                parentContactNo.setText(documentSnapshot.getString("ParentsContactNo"));
                reason.setText(documentSnapshot.getString("Reason"));
                placeOfVisit.setText(documentSnapshot.getString("PlaceOfVisit"));
                leaveDate.setText(documentSnapshot.getString("LeaveDate"));
                leaveTime.setText(documentSnapshot.getString("LeaveTime"));
                returnDate.setText(documentSnapshot.getString("ReturnDate"));
                returnTime.setText(documentSnapshot.getString("ReturnTime"));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(GatepassRecevier.this, "Failed To Load", Toast.LENGTH_LONG).show();
            }
        });

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GatepassRecevier.this, SendAcceptedMessage.class));
                finish();
            }
        });

        rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GatepassRecevier.this, Reject.class));
                finish();
            }
        });
    }
}