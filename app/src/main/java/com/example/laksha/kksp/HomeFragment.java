package com.example.laksha.kksp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View view;
    TextView title_toolbar;

     private RecyclerView recyclerView;
     private List<CardViewHome> items;

    private RecyclerView recyclerView2;
     private List<Posts> data;





    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);
        PostsAdapter adapter2 = new PostsAdapter(getContext(),data);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setAdapter(adapter2);
        // Inflate the layout for this fragment
        Toolbar toolbarTop = (Toolbar) view.findViewById(R.id.toolbar_top);
        TextView toolbar_title = (TextView) toolbarTop.findViewById(R.id.toolbar_title);


return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        data = new ArrayList<>();
        data.add(new Posts(R.drawable.logo, "kaaak","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"));
        data.add(new Posts(R.drawable.about, "kaaasasasak","kaka"));
        data.add(new Posts(R.drawable.about, "kaaasasasak","kaka"));
        data.add(new Posts(R.drawable.about, "kaaasasasak","kaka"));

    }



}
