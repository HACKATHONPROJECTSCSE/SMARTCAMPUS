package com.saurabhjadhav.smartcampus.Gatepass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentDashboard;

public class GatepassRevicer extends AppCompatActivity {
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference gatepassRef = db.collection("GatepassNew");
    private GatepassAdapter adapter;
    ImageView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatepass_revicer);
        backToSDash = findViewById(R.id.BackToSDash);
        setUpRecyclerView();
        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GatepassRevicer.this, StudentDashboard.class));
                finish();
            }
        });
    }

    private void setUpRecyclerView() {
        FirestoreRecyclerOptions<GatepassModel> options = new FirestoreRecyclerOptions.Builder<GatepassModel>().setQuery(gatepassRef, GatepassModel.class).build();
        adapter = new GatepassAdapter(options);
        RecyclerView recyclerView = findViewById(R.id.SeeGatepassRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}