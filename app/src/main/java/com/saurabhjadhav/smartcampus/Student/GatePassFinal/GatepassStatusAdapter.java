package com.saurabhjadhav.smartcampus.Student.GatePassFinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.saurabhjadhav.smartcampus.R;

import java.util.List;

public class GatepassStatusAdapter extends RecyclerView.Adapter<GatepassStatusAdapter.GatepassStatusAdapterViewHolder> {

    private DatabaseReference mDatabase;
    List<UserGatepass> gatepassList;
    private final GatepassStatusAdapter.OnClickListener listener;
    private final Context context;

    public interface OnClickListener {
        void onClick(UserGatepass users);
        void onItemClick(String key);
    }

    public GatepassStatusAdapter(DatabaseReference databaseReference, List<UserGatepass> gatepassList, GatepassStatusAdapter.OnClickListener listener, Context context) {
        this.gatepassList = gatepassList;
        this.mDatabase = databaseReference;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public GatepassStatusAdapter.GatepassStatusAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gatepassstatusloader, parent, false);
        return new GatepassStatusAdapter.GatepassStatusAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GatepassStatusAdapter.GatepassStatusAdapterViewHolder holder, int position) {

        UserGatepass userGatepass = gatepassList.get(position);
        holder.fullName.setText(userGatepass.getFullName());
        holder.hostelName.setText(userGatepass.getHostelName());
        holder.branch.setText(userGatepass.getBranch());
        holder.year.setText(userGatepass.getYear());
        holder.floorNo.setText(userGatepass.getFloorNo());
        holder.roomNo.setText(userGatepass.getRoomNo());
        holder.contactNo.setText(userGatepass.getContactNo());
        holder.parentContactNo.setText(userGatepass.getParentContactNo());
        holder.reason.setText(userGatepass.getReason());
        holder.placeOfVisit.setText(userGatepass.getPlaceOfVisit());
        holder.leaveDate.setText(userGatepass.getLeaveDate());
        holder.leaveTime.setText(userGatepass.getLeaveDate());
        holder.returnDate.setText(userGatepass.getReturnDate());
        holder.returnTime.setText(userGatepass.getReturnTime());

        holder.checkInGatepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child(gatepassList.get(po)).removeValue();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (gatepassList == null) {
            return 0;
        }
        return gatepassList.size();
    }


    class GatepassStatusAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;
        Button checkInGatepass;


        public GatepassStatusAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.name);
            hostelName = itemView.findViewById(R.id.hostelName);
            branch = itemView.findViewById(R.id.branchName);
            year = itemView.findViewById(R.id.year);
            floorNo = itemView.findViewById(R.id.floorNo);
            roomNo = itemView.findViewById(R.id.roomNo);
            contactNo = itemView.findViewById(R.id.contactNo);
            parentContactNo = itemView.findViewById(R.id.parentsContactNo);
            reason = itemView.findViewById(R.id.reason);
            placeOfVisit = itemView.findViewById(R.id.place);
            leaveDate = itemView.findViewById(R.id.leaveDate);
            leaveTime = itemView.findViewById(R.id.leaveTime);
            returnDate = itemView.findViewById(R.id.returnDate);
            returnTime = itemView.findViewById(R.id.returnTime);

            checkInGatepass = itemView.findViewById(R.id.checkInGatepass);

        }
    }
}
