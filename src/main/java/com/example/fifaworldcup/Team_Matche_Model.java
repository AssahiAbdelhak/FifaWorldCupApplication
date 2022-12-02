package com.example.fifaworldcup;

public class Team_Matche_Model {
    private String group_name;
    private String time;
    private String home_name;
    private int home_score;
    private String away_name;
    private int away_score;
    private String day;

    public Team_Matche_Model(String group_name, String day,String time, String home_name,  int home_score, String away_name, int away_score) {
        this.group_name = group_name;
        this.time = time;
        this.home_name = home_name;
        this.home_score = home_score;
        this.away_name = away_name;
        this.day = day;
        this.away_score = away_score;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Team_Matche_Model() {
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }


    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    public String getAway_name() {
        return away_name;
    }

    public void setAway_name(String away_name) {
        this.away_name = away_name;
    }


    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }
}
