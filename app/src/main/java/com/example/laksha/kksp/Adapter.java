package com.example.laksha.kksp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


 Context context;
 List<CardViewHome>data;

 public Adapter(Context context, List<CardViewHome>data){
     this.context = context;
     this.data = data;
 }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_cardview,parent,false);
        ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(context).load(data.get(position).getPhoto()).into(holder.imgCardView);

       holder.title.setText(data.get(position).getJudul());
       holder.desc.setText(data.get(position).getIsi());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       private ImageView imgCardView;
       TextView title,desc;
       private Button detail;


        public ViewHolder(View itemView) {
            super(itemView);
            imgCardView = (ImageView) itemView.findViewById(R.id.imgCardView);
            title = itemView.findViewById(R.id.tv_name_card);
            desc = itemView.findViewById(R.id.tv_desc_card);
            detail = itemView.findViewById(R.id.buttondetail);

        }
    }
}
