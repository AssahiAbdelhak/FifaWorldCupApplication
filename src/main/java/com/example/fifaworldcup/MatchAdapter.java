package com.example.fifaworldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MyViewHolder> {
    private Context context;
    private List<Team_Matche_Model> list;

    public MatchAdapter(Context context, List<Team_Matche_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MatchAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.matche,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MatchAdapter.MyViewHolder holder, int position) {
        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getHome_name()).into(holder.home_team_flag);
        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getAway_name()).into(holder.away_team_flag);
        holder.match_time.setText(list.get(position).getTime());
        holder.group_name.setText(list.get(position).getGroup_name());
        holder.home_team.setText(list.get(position).getHome_name());
        holder.away_team.setText(list.get(position).getAway_name());
        if(list.get(position).getDay()!=null){
            holder.day.setText(list.get(position).getDay());
        }else{
            holder.day.setVisibility(View.GONE);
        }
        holder.home_score.setText(String.valueOf(list.get(position).getHome_score()));
        holder.away_score.setText(String.valueOf(list.get(position).getAway_score()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView home_team_flag,away_team_flag;
        TextView home_team,away_team,home_score,away_score,group_name,match_time;
        TextView day;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            home_team_flag = itemView.findViewById(R.id.home_team_flag);
            away_team_flag = itemView.findViewById(R.id.away_team_flag);
            home_team = itemView.findViewById(R.id.home_team);
            away_team = itemView.findViewById(R.id.away_team);
            home_score = itemView.findViewById(R.id.home_score);
            away_score = itemView.findViewById(R.id.away_score);
            group_name = itemView.findViewById(R.id.group_name);
            match_time = itemView.findViewById(R.id.match_time);
            day = itemView.findViewById(R.id.day);
        }
    }
}
