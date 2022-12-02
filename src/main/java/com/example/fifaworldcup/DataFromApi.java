package com.example.fifaworldcup;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFromApi {

    private Context context;

    public DataFromApi(Context context) {
        this.context = context;
    }

     void getStandings(MainActivity.GetData func){

        String url = "https://api.football-data.org/v4/competitions/2000/standings";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray standings = response.getJSONArray("standings");
                    List<GroupeModel> groups = new ArrayList<>();

                    for(int i = 0 ; i < standings.length();i++){
                        GroupeModel groupeModel = new GroupeModel();
                        groupeModel.setGroup_name(standings.getJSONObject(i).getString("group"));
                        List<TeamModel> list = new ArrayList<>();
                        JSONArray table = standings.getJSONObject(i).getJSONArray("table");
                        for(int j = 0; j < table.length();j++){
                            TeamModel team = new TeamModel();
                            team.setTeam_name(table.getJSONObject(j).getJSONObject("team").getString("name"));
                            team.setTeam_flag(table.getJSONObject(j).getJSONObject("team").getString("crest"));
                            team.setWin(table.getJSONObject(j).getInt("won"));
                            team.setLose(table.getJSONObject(j).getInt("lost"));
                            team.setDraw(table.getJSONObject(j).getInt("draw"));
                            team.setPoints(table.getJSONObject(j).getInt("points"));
                            list.add(team);
                        }
                        groupeModel.setList(list);
                        groups.add(groupeModel);
                    }
                    func.getGroupList(groups);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("X-Auth-Token","7620dbe3c88b48d99b0a2127cae27ef0");
                return map;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    void getAllMatches(MainActivity.GetMatches func){
        String url = "https://api.football-data.org/v4/competitions/2000/matches";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,new Response.Listener<JSONObject>(){

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {
                try {
                    List<String> days = new ArrayList<>();
                    JSONArray matches = response.getJSONArray("matches");
                    List<Team_Matche_Model> list = new ArrayList<>();
                    for(int i = 0 ; i < matches.length() ; i++){
                        Team_Matche_Model team_matche_model = new Team_Matche_Model();
                        String dbTime = matches.getJSONObject(i).getString("utcDate");

                        String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
                         //parsed date time without timezone information
                       LocalDateTime localDateTime = LocalDateTime.parse(dbTime, DateTimeFormatter.ofPattern(DATE_FORMAT));
                        //System.out.println(localDateTime);
//                        // local date time at your system's default time zone
                        ZonedDateTime systemZoneDateTime = localDateTime.atZone(ZoneId.systemDefault());
                        //System.out.println(systemZoneDateTime);
                        if(!days.contains(dbTime.substring(0,10))){
                            System.out.println(dbTime);
                            System.out.println(systemZoneDateTime);
                            days.add(dbTime.substring(0,10));
                            System.out.println(systemZoneDateTime.getDayOfWeek());
                            team_matche_model.setDay(String.valueOf(systemZoneDateTime.getDayOfWeek())+" "+String.valueOf(systemZoneDateTime.getDayOfMonth())+" "+String.valueOf(systemZoneDateTime.getMonth()));
                        }else{
                            team_matche_model.setDay("");
                        }
                        team_matche_model.setTime(String.valueOf(systemZoneDateTime.getHour())+"H"+String.valueOf(systemZoneDateTime.getMinute()));
                        team_matche_model.setGroup_name(matches.getJSONObject(i).getString("group"));
                        team_matche_model.setHome_name(matches.getJSONObject(i).getJSONObject("homeTeam").getString("name"));
                        team_matche_model.setAway_name(matches.getJSONObject(i).getJSONObject("awayTeam").getString("name"));
                        try{
                            team_matche_model.setHome_score(matches.getJSONObject(i).getJSONObject("score").getJSONObject("fullTime").getInt("home"));
                            team_matche_model.setAway_score(matches.getJSONObject(i).getJSONObject("score").getJSONObject("fullTime").getInt("away"));
                        }catch(Exception e){
                            try{
                                team_matche_model.setHome_score(matches.getJSONObject(i).getJSONObject("score").getJSONObject("halfTime").getInt("home"));
                                team_matche_model.setAway_score(matches.getJSONObject(i).getJSONObject("score").getJSONObject("halfTime").getInt("away"));
                            }catch (Exception er){
                                System.out.println("rien");
                            }

                        }
                        list.add(team_matche_model);
                    }
                    func.getMatches(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("X-Auth-Token","7620dbe3c88b48d99b0a2127cae27ef0");
                return map;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    void getBestScorers(MainActivity.GetScorers fun){
        String url = "https://api.football-data.org/v4/competitions/2000/scorers";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray scorers = response.getJSONArray("scorers");
                            System.out.println("good1");
                            List<ScorerModel> list = new ArrayList<>();
                            for(int i = 0 ; i < scorers.length() ; i++){
                                System.out.println("good2");
                                ScorerModel scorer = new ScorerModel();
                                scorer.setPosition(i+1);
                                scorer.setGoals(scorers.getJSONObject(i).getInt("goals"));
                                scorer.setCountry(scorers.getJSONObject(i).getJSONObject("team").getString("name"));
                                System.out.println(scorer.getCountry());
                                scorer.setName(scorers.getJSONObject(i).getJSONObject("player").getString("name"));
                                list.add(scorer);
                                System.out.println(scorer.toString());
                            }
                            System.out.println("good3");
                            fun.getScorers(list);
                        } catch (JSONException e) {
                            System.out.println("Erooooooor");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("X-Auth-Token","7620dbe3c88b48d99b0a2127cae27ef0");
                return map;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

}
