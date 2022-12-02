package com.example.fifaworldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ScorerAdapter extends RecyclerView.Adapter<ScorerAdapter.MyViewHolder> {
    private List<ScorerModel> list;
    private Context context;
    public ScorerAdapter(Context context,List<ScorerModel> list) {
        this.list = list;
        this.context  = context;
    }

    @NonNull
    @Override
    public ScorerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.scorer,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScorerAdapter.MyViewHolder holder, int position) {
        holder.player_name.setText(list.get(position).getName());
        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getCountry()).into(holder.flag);
        holder.position.setText(String.valueOf(list.get(position).getPosition()));
        holder.goals.setText(String.valueOf(list.get(position).getGoals()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView position,goals,player_name;
        ImageView flag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            position = itemView.findViewById(R.id.position);
            goals= itemView.findViewById(R.id.goals);
            player_name = itemView.findViewById(R.id.player_name);
            flag = itemView.findViewById(R.id.flag);
        }
    }
}
