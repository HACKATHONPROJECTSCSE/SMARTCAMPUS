package com.saurabhjadhav.smartcampus.Student.NoticeBoard;

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
import com.saurabhjadhav.smartcampus.Student.StudentDashboard;

import java.util.ArrayList;

public class DisplayNotice extends AppCompatActivity {

    ArrayList<DisplayNoticeModel> list;
    DisplayNoticeAdapter adapter;
    ImageView backToSDash, info;

    // FIREBASE
    DatabaseReference root = FirebaseDatabase.getInstance().getReference("NoticeImages");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notice);

        backToSDash = findViewById(R.id.BackToSDash);
        info = findViewById(R.id.info);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayNotice.this, StudentDashboard.class));
                finish();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayNotice.this, NoticeInfo.class));
            }
        });

        // RECYCLER VIEW

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new DisplayNoticeAdapter(list, this);
        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DisplayNoticeModel displayNoticeModel = dataSnapshot.getValue(DisplayNoticeModel.class);
                    list.add(displayNoticeModel);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}