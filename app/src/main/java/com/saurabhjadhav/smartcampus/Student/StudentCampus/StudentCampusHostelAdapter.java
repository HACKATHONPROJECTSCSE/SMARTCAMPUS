package com.saurabhjadhav.smartcampus.Student.StudentCampus;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saurabhjadhav.smartcampus.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentCampusHostelAdapter extends RecyclerView.Adapter<StudentCampusHostelAdapter.MyViewHolder> {

    private final ArrayList<StudentCampusModel> mList;
    private final Context context;

    public StudentCampusHostelAdapter(ArrayList<StudentCampusModel> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_student_campus_hostel_images_itemsloader, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get()
                .load(mList.get(position).getHostelimageUrl())
                .into(holder.hostelImages);

        StudentCampusModel studentCampusModel = mList.get(position);
        holder.hostelDescription.setText(studentCampusModel.getHosteldescriptionUrl());

        holder.hostelDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = mList.get(holder.getAdapterPosition()).getHostelimageUrl();
                String fileName = "hostel.jpg";

                DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(imageUrl))
                        .setTitle(fileName)
                        .setDescription("Downloading image")
                        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setAllowedOverMetered(true)
                        .setAllowedOverRoaming(true)
                        .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

                downloadManager.enqueue(request);

                Toast.makeText(context, "Image downloading...", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView hostelDescription;
        ImageView hostelImages, hostelDownload;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hostelImages = itemView.findViewById(R.id.HostelImageLoader);
            hostelDescription = itemView.findViewById(R.id.HostelDescriptionLoader);
            hostelDownload= itemView.findViewById(R.id.HostelImageDownloader);

        }
    }
}
