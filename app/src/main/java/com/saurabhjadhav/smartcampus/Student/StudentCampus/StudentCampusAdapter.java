package com.saurabhjadhav.smartcampus.Student.StudentCampus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saurabhjadhav.smartcampus.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class StudentCampusAdapter extends RecyclerView.Adapter<StudentCampusAdapter.MyViewHolder> {

    private final ArrayList<StudentCampusModel> mList;
    private final Context context;

    public StudentCampusAdapter(ArrayList<StudentCampusModel> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_student_campus_images_itemsloader, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load(mList.get(position).getCampusimageUrl()).into(holder.campusImages);

        StudentCampusModel studentCampusModel = mList.get(position);
        holder.campusDescription.setText(studentCampusModel.getCampusdescriptionUrl());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView campusDescription;
        ImageView campusImages;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            campusImages = itemView.findViewById(R.id.CampusImageLoader);
            campusDescription = itemView.findViewById(R.id.CampusDescriptionLoader);

        }
    }
}