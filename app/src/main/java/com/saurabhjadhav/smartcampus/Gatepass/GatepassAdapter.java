package com.saurabhjadhav.smartcampus.Gatepass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.saurabhjadhav.smartcampus.R;

public class GatepassAdapter extends FirestoreRecyclerAdapter<GatepassModel, GatepassAdapter.GatepassHolder> {

    private Context context;

    public GatepassAdapter(@NonNull FirestoreRecyclerOptions<GatepassModel> options) {
        super(options);
    }

    public Context getContext() {
        return context;
    }

    @Override
    protected void onBindViewHolder(@NonNull GatepassHolder gatepassHolder, int i, @NonNull GatepassModel gatepassModel) {
        gatepassHolder.fullName.setText(gatepassModel.getFullnname());
        gatepassHolder.hostelName.setText(gatepassModel.getHostelName());
        gatepassHolder.branch.setText(gatepassModel.getBranch());
        gatepassHolder.year.setText(gatepassModel.getYear());
        gatepassHolder.floorNo.setText(gatepassModel.getFloorNo());
        gatepassHolder.roomNo.setText(gatepassModel.getRoomNo());
        gatepassHolder.contactNo.setText(gatepassModel.getContactNo());
        gatepassHolder.parentContactNo.setText(gatepassModel.getParentContactNo());
        gatepassHolder.reason.setText(gatepassModel.getReason());
        gatepassHolder.placeOfVisit.setText(gatepassModel.getPlaceOfVisit());
        gatepassHolder.leaveTime.setText(gatepassModel.getLeaveTime());
        gatepassHolder.leaveDate.setText(gatepassModel.getLeaveDate());
        gatepassHolder.returnDate.setText(gatepassModel.getReturnDate());
        gatepassHolder.returnTime.setText(gatepassModel.getReturnTime());


    }

    @NonNull
    @Override
    public GatepassHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gatepassloader, parent, false);
        return new GatepassHolder(v);

    }

    class GatepassHolder extends RecyclerView.ViewHolder {

        TextView fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;
        Button rejectBtn, acceptBtn;

        public GatepassHolder(@NonNull View itemView) {
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

            acceptBtn = itemView.findViewById(R.id.acceptBtn);
            rejectBtn = itemView.findViewById(R.id.rejectBtn);


        }

    }
}