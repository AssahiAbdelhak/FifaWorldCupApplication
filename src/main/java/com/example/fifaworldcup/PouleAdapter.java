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



public class PouleAdapter extends RecyclerView.Adapter<PouleAdapter.MyViewHolder> {
    private Context context;
    private List<GroupeModel> list;

    public PouleAdapter(Context context, List<GroupeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PouleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.poule,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PouleAdapter.MyViewHolder holder, int position) {
        holder.group_name.setText(list.get(position).getGroup_name());


        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getList().get(0).getTeam_name()).into(holder.flag1);

        System.out.println(list.get(position).getList().get(0).getPoints());
        holder.pts1.setText(list.get(position).getList().get(0).getPoints().toString());
        holder.draw1.setText(list.get(position).getList().get(0).getDraw().toString());
        holder.lose1.setText(list.get(position).getList().get(0).getLose().toString());
        holder.win1.setText(list.get(position).getList().get(0).getWin().toString());
        holder.team1.setText(list.get(position).getList().get(0).getTeam_name());


        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getList().get(1).getTeam_name()).into(holder.flag2);


        holder.pts2.setText(list.get(position).getList().get(1).getPoints().toString());
        holder.draw2.setText(list.get(position).getList().get(1).getDraw().toString());
        holder.lose2.setText(list.get(position).getList().get(1).getLose().toString());
        holder.win2.setText(list.get(position).getList().get(1).getWin().toString());
        holder.team2.setText(list.get(position).getList().get(1).getTeam_name());


        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getList().get(2).getTeam_name()).into(holder.flag3);


        holder.pts3.setText(list.get(position).getList().get(2).getPoints().toString());
        holder.draw3.setText(list.get(position).getList().get(2).getDraw().toString());
        holder.lose3.setText(list.get(position).getList().get(2).getLose().toString());
        holder.win3.setText(list.get(position).getList().get(2).getWin().toString());
        holder.team3.setText(list.get(position).getList().get(2).getTeam_name());


        Picasso.get().load("https://www.countryflagsapi.com/png/"+list.get(position).getList().get(3).getTeam_name()).into(holder.flag4);
        holder.pts4.setText(list.get(position).getList().get(3).getPoints().toString());
        holder.draw4.setText(list.get(position).getList().get(3).getDraw().toString());
        holder.lose4.setText(list.get(position).getList().get(3).getLose().toString());
        holder.win4.setText(list.get(position).getList().get(3).getWin().toString());
        holder.team4.setText(list.get(position).getList().get(3).getTeam_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView group_name;
        CircleImageView flag1,flag2,flag3,flag4;
        TextView team1,team2,team3,team4;
        TextView win1,win2,win3,win4;
        TextView lose1,lose2,lose3,lose4;
        TextView draw1,draw2,draw3,draw4;
        TextView pts1,pts2,pts3,pts4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            group_name = itemView.findViewById(R.id.group_name);
            flag1 = itemView.findViewById(R.id.flag1);
            flag2 = itemView.findViewById(R.id.flag2);
            flag3 = itemView.findViewById(R.id.flag3);
            flag4 = itemView.findViewById(R.id.flag4);
            team1 = itemView.findViewById(R.id.team_name1);
            team2 = itemView.findViewById(R.id.team_name2);
            team3 = itemView.findViewById(R.id.team_name3);
            team4 = itemView.findViewById(R.id.team_name4);
            win1 = itemView.findViewById(R.id.win1);
            win2 = itemView.findViewById(R.id.win2);
            win3 = itemView.findViewById(R.id.win3);
            win4 = itemView.findViewById(R.id.win4);
            lose1 = itemView.findViewById(R.id.lose1);
            lose2 = itemView.findViewById(R.id.lose2);
            lose3 = itemView.findViewById(R.id.lose3);
            lose4 = itemView.findViewById(R.id.lose4);
            draw1 = itemView.findViewById(R.id.draw1);
            draw2 = itemView.findViewById(R.id.draw2);
            draw3 = itemView.findViewById(R.id.draw3);
            draw4 = itemView.findViewById(R.id.draw4);
            pts1 = itemView.findViewById(R.id.pts1);
            pts2 = itemView.findViewById(R.id.pts2);
            pts3 = itemView.findViewById(R.id.pts3);
            pts4 = itemView.findViewById(R.id.pts4);
        }
    }
}
