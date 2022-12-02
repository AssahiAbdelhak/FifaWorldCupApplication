package com.example.fifaworldcup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Matches#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Matches extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Matches() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Matches.
     */
    // TODO: Rename and change types and number of parameters
    public static Matches newInstance(String param1, String param2) {
        Matches fragment = new Matches();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    RecyclerView rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_matches, container, false);
        rv = view.findViewById(R.id.rv_matches);
        rv.setLayoutManager(new LinearLayoutManager(null));
        DataFromApi dataFromApi = new DataFromApi(container.getContext());
        dataFromApi.getAllMatches(new MainActivity.GetMatches() {
            @Override
            public void getMatches(List<Team_Matche_Model> list) {
                MatchAdapter matchAdapter = new MatchAdapter(container.getContext(),list);
                rv.setAdapter(matchAdapter);
            }
        });
        return view;
    }
}