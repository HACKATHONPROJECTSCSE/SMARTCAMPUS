package com.saurabhjadhav.smartcampus.Teacher.TODO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Teacher.TeacherDashboard;

public class TeacherTODO extends AppCompatActivity {

    ImageView backToSDash;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    String user = fAuth.getCurrentUser().getUid();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference myTaskRef = db.collection("TEACHER TASKS").document(user).collection("TASKS");
    private TeacherTODOAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_todo);

        backToSDash = findViewById(R.id.BackToSDash);

        setUpRecyclerView();

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherTODO.this, TeacherDashboard.class));
                finish();
            }
        });

        FloatingActionButton buttonAddNote = findViewById(R.id.AddTask);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeacherTODOTaskAdd.class);
                startActivity(intent);
            }
        });

    }

    private void setUpRecyclerView() {
        Query query = myTaskRef.orderBy("priority", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<TeacherTODOModel> options = new FirestoreRecyclerOptions.Builder<TeacherTODOModel>()
                .setQuery(query, TeacherTODOModel.class)
                .build();

        adapter = new TeacherTODOAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.SeeMessageRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
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