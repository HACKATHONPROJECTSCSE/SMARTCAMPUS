package com.saurabhjadhav.smartcampus.Student.StudentQuotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.saurabhjadhav.smartcampus.R;

public class QuotesAdapter extends FirestoreRecyclerAdapter<QuotesModel, QuotesAdapter.QuotesHolder>  {

    public QuotesAdapter(@NonNull FirestoreRecyclerOptions<QuotesModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull QuotesHolder quotesHolder, int i, @NonNull QuotesModel quotesModel) {
        quotesHolder.quotesView.setText(quotesModel.getQuotesUrl());
    }

    @NonNull
    @Override
    public QuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotesitemloader, parent, false);
        return new QuotesHolder(v);
    }

    class QuotesHolder extends RecyclerView.ViewHolder {


        TextView quotesView;

        public QuotesHolder(View itemView) {
            super(itemView);
            quotesView = itemView.findViewById(R.id.quotesView);

        }
    }
}
