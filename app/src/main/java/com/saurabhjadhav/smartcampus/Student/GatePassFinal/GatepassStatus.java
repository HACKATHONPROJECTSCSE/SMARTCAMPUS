package com.saurabhjadhav.smartcampus.Student.GatePassFinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saurabhjadhav.smartcampus.R;

import java.util.ArrayList;

public class GatepassStatus extends AppCompatActivity implements GatepassStatusAdapter.OnClickListener {

    private GatepassStatusAdapter adapter;
    private RecyclerView recyclerView;
    private DatabaseReference myRef;

    private ArrayList<UserGatepass> gatepassList;

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(GatepassStatus.this, GatePassDashboardFinal.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatepass_status);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        myRef = database.child("Gatepass").child(userId);
        gatepassList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerStatus);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GatepassStatus.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new GatepassStatusAdapter(database,gatepassList, GatepassStatus.this, GatepassStatus.this);
        recyclerView.setAdapter(adapter);
        getUsers();


    }

    public void getUsers() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    UserGatepass user = ds.getValue(UserGatepass.class);
                    gatepassList.add(user);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }

    @Override
    public void onClick(UserGatepass users) {
        myRef.child(users.getuId()).setValue(users);
    }

    @Override
    public void onItemClick(String key) {

    }
}