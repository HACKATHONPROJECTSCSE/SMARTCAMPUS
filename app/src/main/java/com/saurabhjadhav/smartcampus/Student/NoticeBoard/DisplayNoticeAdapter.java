package com.saurabhjadhav.smartcampus.Student.NoticeBoard;

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


public class DisplayNoticeAdapter extends RecyclerView.Adapter<DisplayNoticeAdapter.MyViewHolder> {

    private final ArrayList<DisplayNoticeModel> mList;
    private final Context context;

    public DisplayNoticeAdapter(ArrayList<DisplayNoticeModel> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notice_itemloader, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(mList.get(position).getNoticeimageUrl()).into(holder.noticeImages);

        DisplayNoticeModel displayNoticeModel = mList.get(position);
        holder.noticeDescription.setText(displayNoticeModel.getCampusdescriptionUrl());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView noticeDescription;
        ImageView noticeImages;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            noticeImages = itemView.findViewById(R.id.NoticeImageLoader);
            noticeDescription = itemView.findViewById(R.id.NoticeDescription);

        }
    }
}
