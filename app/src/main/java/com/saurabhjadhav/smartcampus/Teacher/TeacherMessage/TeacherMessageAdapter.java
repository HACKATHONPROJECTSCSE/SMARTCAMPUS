package com.saurabhjadhav.smartcampus.Teacher.TeacherMessage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.saurabhjadhav.smartcampus.R;

public class TeacherMessageAdapter extends FirestoreRecyclerAdapter<TeacherMessageModel, TeacherMessageAdapter.MessageHolder> {
    private AdapterView.OnItemClickListener listener;

    public TeacherMessageAdapter(@NonNull FirestoreRecyclerOptions<TeacherMessageModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MessageHolder messageHolder, int i, @NonNull TeacherMessageModel teacherMessageModel) {
        messageHolder.textViewTitle.setText(teacherMessageModel.getTitle());
        messageHolder.textViewDescription.setText(teacherMessageModel.getDescription());
        messageHolder.textViewPriority.setText(String.valueOf(teacherMessageModel.getPriority()));
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_teacher_message_item,
                parent, false);
        return new MessageHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class MessageHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;

        public MessageHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }


}