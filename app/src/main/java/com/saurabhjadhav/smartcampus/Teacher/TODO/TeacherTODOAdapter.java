package com.saurabhjadhav.smartcampus.Teacher.TODO;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.saurabhjadhav.smartcampus.R;

public class TeacherTODOAdapter extends FirestoreRecyclerAdapter<TeacherTODOModel, TeacherTODOAdapter.MytaskHolder> {

    public TeacherTODOAdapter(@NonNull FirestoreRecyclerOptions<TeacherTODOModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MytaskHolder mytaskHolder, int i, @NonNull TeacherTODOModel teacherTODOModel) {
        mytaskHolder.textViewTitle.setText(teacherTODOModel.getTitle());
        mytaskHolder.textViewDescription.setText(teacherTODOModel.getDescription());
        mytaskHolder.textViewPriority.setText(String.valueOf(teacherTODOModel.getPriority()));
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
