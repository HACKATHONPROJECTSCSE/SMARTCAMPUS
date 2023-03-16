package com.saurabhjadhav.smartcampus.Student.TODO;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.saurabhjadhav.smartcampus.R;

public class StudentTODOAdapter extends FirestoreRecyclerAdapter<StudentTODOModel, StudentTODOAdapter.MytaskHolder> {
    public StudentTODOAdapter(@NonNull FirestoreRecyclerOptions<StudentTODOModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MytaskHolder mytaskHolder, int i, @NonNull StudentTODOModel studentTODOModel) {
        mytaskHolder.textViewTitle.setText(studentTODOModel.getTitle());
        mytaskHolder.textViewDescription.setText(studentTODOModel.getDescription());
        mytaskHolder.textViewPriority.setText(String.valueOf(studentTODOModel.getPriority()));
    }

    @NonNull
    @Override
    public MytaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_todo_list_item,
                parent, false);
        return new MytaskHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    public class MytaskHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;
        public MytaskHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_todo_title);
            textViewDescription = itemView.findViewById(R.id.text_view_todo_description);
            textViewPriority = itemView.findViewById(R.id.text_view_todo_priority);
        }
    }
}
