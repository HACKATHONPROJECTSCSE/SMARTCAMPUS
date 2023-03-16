package com.saurabhjadhav.smartcampus.Teacher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Teacher.TODO.TeacherTODO;
import com.saurabhjadhav.smartcampus.Teacher.TeacherCampus.TeacherCampus;
import com.saurabhjadhav.smartcampus.Teacher.TeacherGatepass.GatepassRecevier;
import com.saurabhjadhav.smartcampus.Teacher.TeacherMessage.TeacherMessageView;
import com.saurabhjadhav.smartcampus.Teacher.TeacherWebsite.TeacherWebsiteView;
import com.squareup.picasso.Picasso;

public class TeacherDashboard extends AppCompatActivity {

    // VARIABLES

    Button profile, teacherTodo;
    TextView username;
    ImageView profileImage;
    LinearLayout campusView, noticeView, websiteView, messageView, fitnessView, gatePassDash;

    // FIREBASE

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        username = findViewById(R.id.ProfileUsername);
        profile = findViewById(R.id.TeacherProfileBtn);
        teacherTodo = findViewById(R.id.TeacherToDo);
        profileImage = findViewById(R.id.ProfileImage);
        campusView = findViewById(R.id.CampusView);
        noticeView = findViewById(R.id.NoticeView);
        websiteView = findViewById(R.id.WebsiteView);
        messageView = findViewById(R.id.SendMessageView);
        fitnessView = findViewById(R.id.FitnessView);
        gatePassDash = findViewById(R.id.GatepassDash);

        // FIREBASE

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = firebaseAuth.getCurrentUser().getUid();


        // ONCLICK LISTENERS

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this, TeacherProfile.class));
            }
        });

        teacherTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this, TeacherTODO.class));
            }
        });

        campusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this, TeacherCampus.class));
            }
        });

        websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this, TeacherWebsiteView.class));
            }
        });

        messageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this, TeacherMessageView.class));
            }
        });

        gatePassDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherDashboard.this, GatepassRecevier.class));
            }
        });


        // FIREBASE USERNAME RETRIEVE
        DocumentReference documentReference = firebaseFirestore.collection("Users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                username.setText(value.getString("UserName"));
            }
        });


        // FIREBASE IMAGE RETRIEVE
        StorageReference profileRef = storageReference.child("Users/" + firebaseAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage);
            }
        });


    }
}