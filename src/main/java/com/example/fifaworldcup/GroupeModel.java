package com.example.fifaworldcup;

import java.util.List;

public class GroupeModel {
    private List<TeamModel> list;
    private String group_name;

    public GroupeModel(List<TeamModel> list, String group_name) {
        this.list = list;
        this.group_name = group_name;
    }

    public GroupeModel() {
    }

    public List<TeamModel> getList() {
        return list;
    }

    public void setList(List<TeamModel> list) {
        this.list = list;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
