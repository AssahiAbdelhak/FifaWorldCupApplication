package com.example.fifaworldcup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.fifaworldcup.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.squareup.picasso.Picasso;

import java.net.InterfaceAddress;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ImageView banner;
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        banner = findViewById(R.id.banner);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        replaceFragment(new Matches());

        Picasso.get().load("https://crests.football-data.org/qatar.png").into(banner);
        DataFromApi dataFromApi = new DataFromApi(this);
        dataFromApi.getBestScorers(new GetScorers() {
            @Override
            public void getScorers(List<ScorerModel> list) {

            }
        });

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println(item);
                switch(item.getItemId()){
                    case R.id.standings_menu:
                        System.out.println("to Standings");
                        replaceFragment(new Standings());
                        break;
                    case R.id.matches_menu:
                        System.out.println("to Matches");
                        replaceFragment(new Matches());
                        break;
                    case R.id.players_score_menu:
                        System.out.println("to Score");
                        replaceFragment(new Score());
                        break;
                }

                return true;
            }
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    interface GetData{
        void getGroupList(List<GroupeModel> list);

    }
    interface GetMatches{
        void getMatches(List<Team_Matche_Model> list);
    }
    interface GetScorers{
        void getScorers(List<ScorerModel> list);
    }

}