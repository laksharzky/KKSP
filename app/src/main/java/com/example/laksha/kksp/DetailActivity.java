package com.example.laksha.kksp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  String title, content;
  int images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView imageView = findViewById(R.id.imgdetail);
        TextView name = findViewById(R.id.tv_name_detail);
        TextView description = findViewById(R.id.textView9);



        images = getIntent().getIntExtra("images",0);
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("details");


        imageView.setImageResource(images);
        name.setText(title);
        description.setText(content);





    }
}
