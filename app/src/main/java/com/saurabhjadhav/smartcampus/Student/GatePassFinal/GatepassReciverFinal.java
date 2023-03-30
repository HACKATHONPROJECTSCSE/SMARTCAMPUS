package com.saurabhjadhav.smartcampus.Student.GatePassFinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.adapter.CheckOutAdapter;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.models.User;

import java.util.ArrayList;

public class GatepassReciverFinal extends AppCompatActivity implements GatepassReciverAdapter.OnClickListener{

    private GatepassReciverAdapter adapter;
    private RecyclerView recyclerView;
    private DatabaseReference myRef;

    private ArrayList<UserGatepass> gatepassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatepass_reciver_final);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("GatepassNew");

        gatepassList = new ArrayList<>();

        recyclerView = findViewById(R.id.gatepassLoaderFinal);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GatepassReciverFinal.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new GatepassReciverAdapter(GatepassReciverFinal.this, GatepassReciverFinal.this, gatepassList);
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
}