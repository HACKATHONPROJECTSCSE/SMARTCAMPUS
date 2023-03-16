package com.saurabhjadhav.smartcampus.Student.GateEntryExit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.GateEntryExit.models.User;

import java.util.List;

public class CheckOutAdapter extends RecyclerView.Adapter<CheckOutAdapter.CheckOutAdapterViewHolder>{

    List<User> checkedInList;
    private final OnClickListener listener;
    private final Context context;
    public interface OnClickListener{
        void onClick(User user);
    }

    public CheckOutAdapter(Context context, List<User> userList, OnClickListener listener) {
        this.context = context;
        this.checkedInList = userList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CheckOutAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_item, parent, false);
        return new CheckOutAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckOutAdapterViewHolder holder, int position) {
        User user = checkedInList.get(position);
        holder.visitorPhone.setText(user.getVisitorPhone());
        holder.hostName.setText(user.getHostName());
        holder.visitorName.setText(user.getVisitorName());
        holder.checkInTime.setText(user.getCheckInTime().toString());
    }

    @Override
    public int getItemCount() {
        if(checkedInList == null){
        return 0;}
        return checkedInList.size();
    }

    class CheckOutAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView visitorName;
        TextView hostName;
        TextView visitorPhone;
        TextView checkInTime;
        Button checkOut;

        public CheckOutAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            visitorName = itemView.findViewById(R.id.visitor_name);
            hostName = itemView.findViewById(R.id.host_name);
            visitorPhone = itemView.findViewById(R.id.phone);
            checkInTime = itemView.findViewById(R.id.checkinTime);
            checkOut = itemView.findViewById(R.id.check_out_button);

            checkOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(checkedInList.get(getAdapterPosition()));
                }
            });
        }
    }
}
