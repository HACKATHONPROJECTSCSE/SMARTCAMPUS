package com.saurabhjadhav.smartcampus.Teacher.TeacherCampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentCampus.StudentCampusHostelAdapter;
import com.saurabhjadhav.smartcampus.Student.StudentCampus.StudentCampusModel;

import java.util.ArrayList;

public class TeacherCampusHostelImages extends AppCompatActivity {

    ArrayList<StudentCampusModel> list;
    StudentCampusHostelAdapter adapter;
    ImageView backToSDash;

    // FIREBASE

    DatabaseReference root = FirebaseDatabase.getInstance().getReference("HostelImages");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_campus_hostel_images);

        backToSDash = findViewById(R.id.BackToSDash);

        // RECYCLER VIEW

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new StudentCampusHostelAdapter(list, this);
        recyclerView.setAdapter(adapter);


        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherCampusHostelImages.this, TeacherCampus.class));
                finish();
            }
        });

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    StudentCampusModel studentCampusModel = dataSnapshot.getValue(StudentCampusModel.class);
                    list.add(studentCampusModel);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}