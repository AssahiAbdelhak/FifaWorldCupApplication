package com.example.fifaworldcup;

public class ScorerModel {
    private int goals,position;
    private String name,country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ScorerModel(int goals, int position, String name, String country) {
        this.goals = goals;
        this.position = position;
        this.name = name;
        this.country = country;
    }

    public ScorerModel() {
    }


    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
