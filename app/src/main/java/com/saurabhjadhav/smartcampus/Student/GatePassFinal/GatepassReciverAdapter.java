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

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentGatePass.Reject;

import java.util.List;

public class GatepassReciverAdapter extends RecyclerView.Adapter<GatepassReciverAdapter.GatepassReciverAdapterViewHolder> {

    List<UserGatepass> gatepassList;
    private final OnClickListener listener;
    private final Context context;

    public interface OnClickListener {
        void onClick(UserGatepass users);
    }

    public GatepassReciverAdapter(Context context, OnClickListener listener, List<UserGatepass> gatepassList) {
        this.gatepassList = gatepassList;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public GatepassReciverAdapter.GatepassReciverAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gatepassloader, parent, false);
        return new GatepassReciverAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GatepassReciverAdapter.GatepassReciverAdapterViewHolder holder, int position) {
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


        holder.acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), SendAcceptedMessage.class);
                intent.putExtra("contactNo", gatepassList.get(position).getContactNo());
                view.getContext().startActivity(intent);
            }
        });

        holder.rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Reject.class);
                intent.putExtra("contactNo", gatepassList.get(position).getContactNo());
                view.getContext().startActivity(intent);
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

    class GatepassReciverAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView fullName, hostelName, branch, year, floorNo, roomNo, contactNo, parentContactNo, reason, placeOfVisit, leaveDate, leaveTime, returnDate, returnTime;
        Button rejectBtn, acceptBtn;


        public GatepassReciverAdapterViewHolder(@NonNull View itemView) {
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
