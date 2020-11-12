package com.example.laksha.kksp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
public class HomeFragment extends Fragment implements View.OnClickListener{
    View view;
    TextView title_toolbar;

     private RecyclerView recyclerView;
     private List<CardViewHome> items;
     private TextView txtViewUserEmail;
    private Button txtlogout;
    private RecyclerView recyclerView2;
     private List<Posts> data;

     Button button;
     private FirebaseAuth firebaseAuth;
    DatabaseReference reference;
    FirebaseDatabase database;
    PostsAdapter adapter;




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            getActivity().finish();
            startActivity(new Intent(view.getContext(), MainActivity.class));

        }
        txtViewUserEmail = (TextView) view.findViewById(R.id.txtViewUserEmail);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        txtViewUserEmail.setText("Welcome "+user.getEmail());




        txtlogout = (Button) view.findViewById(R.id.txtlogout) ;
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        data = new ArrayList<Posts>();

        // Inflate the layout for this fragment
        Toolbar toolbarTop = (Toolbar) view.findViewById(R.id.toolbar_top);
        TextView toolbar_title = (TextView) toolbarTop.findViewById(R.id.toolbar_title);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        txtlogout.setOnClickListener(this);



        reference = FirebaseDatabase.getInstance().getReference().child("Posts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Posts posts = dataSnapshot1.getValue(Posts.class);
                    data.add(posts);


                }
                adapter = new PostsAdapter(getContext(),data);
                recyclerView2.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
              Toast.makeText(getActivity(),"Something is wrong",Toast.LENGTH_SHORT).show();

            }
        });


return view;
    }






    //isi recycler view sementara



    @Override
    public void onClick(View v) {
        if (v == txtlogout){
            getActivity().finish();
            firebaseAuth.signOut();
            startActivity(new Intent(view.getContext(), MainActivity.class));
        }
        if (v == button){
            startActivity(new Intent(getContext(),about.class));
        }
    }
}
