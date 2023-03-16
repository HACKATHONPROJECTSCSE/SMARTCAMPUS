package com.saurabhjadhav.smartcampus.Student.StudentQuotes;

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

public class QuotesDashboard extends AppCompatActivity {


    private final FirebaseFirestore dbquotes = FirebaseFirestore.getInstance();
    private final CollectionReference quotesRef = dbquotes.collection("Quotes");
    private QuotesAdapter adapter;
    ImageView backToSDash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_dashboard);

        backToSDash = findViewById(R.id.BackToSDash);

        setUpRecyclerView();

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuotesDashboard.this, StudentDashboard.class));
                finish();
            }
        });
    }

    private void setUpRecyclerView() {

        FirestoreRecyclerOptions<QuotesModel> options = new FirestoreRecyclerOptions.Builder<QuotesModel>()
                .setQuery(quotesRef, QuotesModel.class)
                .build();

        adapter = new QuotesAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.SeeQuotesRecycler);
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