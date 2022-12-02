package com.example.fifaworldcup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder> {
    private String day;

    public DayAdapter(String day) {
        this.day = day;
    }

    @NonNull
    @Override
    public DayAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.day,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DayAdapter.MyViewHolder holder, int position) {
        holder.day.setText(day);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
        }
    }
}
