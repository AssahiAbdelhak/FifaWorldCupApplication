package com.example.fifaworldcup;

public class TeamModel {
    private String team_name;
    private String team_flag;
    private Integer win;
    private Integer lose;
    private Integer draw;
    private Integer points;

    public TeamModel(String team_name, String team_flag, Integer win, Integer lose, Integer draw, Integer points) {
        this.team_name = team_name;
        this.team_flag = team_flag;
        this.win = win;
        this.lose = lose;
        this.draw = draw;
        this.points = points;
    }

    public TeamModel() {
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_flag() {
        return team_flag;
    }

    public void setTeam_flag(String team_flag) {
        this.team_flag = team_flag;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
