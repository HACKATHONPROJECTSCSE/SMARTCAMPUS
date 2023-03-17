package com.saurabhjadhav.smartcampus.Student;

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
import com.saurabhjadhav.smartcampus.Student.Attendance.AttendanceDashboard;

import com.saurabhjadhav.smartcampus.Student.DeveloperInfo.DeveloperInfo;
import com.saurabhjadhav.smartcampus.Student.Elrc.StudentElrcHome;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.GateEntryExitDashboard;
import com.saurabhjadhav.smartcampus.Student.ImportantContacts.StudentImportantContacts;
import com.saurabhjadhav.smartcampus.Student.NoticeBoard.DisplayNotice;
import com.saurabhjadhav.smartcampus.Student.Sheild.SplashActivity;
import com.saurabhjadhav.smartcampus.Student.StudentCampus.StudentCampus;
import com.saurabhjadhav.smartcampus.Student.StudentFItness.StudentFitnessHome;
import com.saurabhjadhav.smartcampus.Student.StudentGatePass.GatepassDashboard;
import com.saurabhjadhav.smartcampus.Student.StudentMessage.StudentMessageSee;
import com.saurabhjadhav.smartcampus.Student.StudentQuotes.QuotesDashboard;
import com.saurabhjadhav.smartcampus.Student.StudentWebsite.StudentWebsiteView;
import com.saurabhjadhav.smartcampus.Student.TODO.StudentTODO;
import com.squareup.picasso.Picasso;

public class StudentDashboard extends AppCompatActivity {

    // VARIABLES

    Button profile, studentTodo;
    TextView username;
    ImageView profileImage;
    LinearLayout campusView, noticeView, websiteView, messageView, fitnessView, developerView, elrcView, shield, gatepass, impContacts, complaint, quotes, GateEntryView, attendanceView, cgpaCalculator;

    // FIREBASE

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;


    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        username = findViewById(R.id.ProfileUsername);
        profile = findViewById(R.id.StudentProfileBtn);
        profileImage = findViewById(R.id.ProfileImage);
        campusView = findViewById(R.id.CampusView);
        noticeView = findViewById(R.id.NoticeView);
        websiteView = findViewById(R.id.WebsiteView);
        messageView = findViewById(R.id.MessageView);
        studentTodo = findViewById(R.id.StudentToDo);
        fitnessView = findViewById(R.id.FitnessView);
        developerView = findViewById(R.id.AboutDeveloper);
        elrcView = findViewById(R.id.ElrcView);
        shield = findViewById(R.id.Shield);
        gatepass = findViewById(R.id.Gatepass);
        impContacts = findViewById(R.id.ImpContacts);
        complaint = findViewById(R.id.ComplaintAAP);
        quotes = findViewById(R.id.MotivationalQuotes);
        GateEntryView = findViewById(R.id.GateEntryView);
        attendanceView = findViewById(R.id.AttendanceView);



        // FIREBASE

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = firebaseAuth.getCurrentUser().getUid();


        // ONCLICK LISTENERS

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentProfile.class));
            }
        });

        campusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentCampus.class));
            }
        });

        websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentWebsiteView.class));
            }
        });

        studentTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentTODO.class));
            }
        });


        attendanceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, AttendanceDashboard.class));
            }
        });

        noticeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, DisplayNotice.class));
            }
        });


        elrcView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentElrcHome.class));
            }
        });

        GateEntryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, GateEntryExitDashboard.class));
            }
        });

        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, SplashActivity.class));
            }
        });


        quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, QuotesDashboard.class));
            }
        });


        gatepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, GatepassDashboard.class));
            }
        });


        messageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentMessageSee.class));
            }
        });

        fitnessView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentFitnessHome.class));
            }
        });

        developerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, DeveloperInfo.class));
            }
        });

        impContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, StudentImportantContacts.class));
            }
        });

     /*   cgpaCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, CgpaDashboard.class));
            }
        });


      */

     /*   complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboard.this, ComplaintAAP.class));
            }
        });

      */


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