package com.example.laksha.kksp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    Context mContext;
    List<Posts> mData;

    public PostsAdapter(Context mContext, List<Posts> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.posts_cardview,parent,false);
        ViewHolder vholder = new ViewHolder(v);
        return vholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.get().load(mData.get(position).getImages()).into(holder.imgview2);

        holder.txtTitlePosts.setText(mData.get(position).getTitles());
        holder.posts_Desc.setText(mData.get(position).getDetails());

        //intent bundle
        holder.btnCardPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailActivity = new Intent(mContext, DetailActivity.class);
                detailActivity.putExtra("images", mData.get(position).getImages());
                detailActivity.putExtra("title", mData.get(position).getTitles());
                detailActivity.putExtra("details", mData.get(position).getDetails());
                mContext.startActivity(detailActivity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgview2;
        TextView txtTitlePosts,posts_Desc;
        private Button btnCardPosts;

        public ViewHolder(View itemView) {
            super(itemView);
            imgview2 = (ImageView) itemView.findViewById(R.id.imgview2);
            txtTitlePosts = itemView.findViewById(R.id.txtTitlePosts);
            posts_Desc = itemView.findViewById(R.id.posts_Desc);
            btnCardPosts = itemView.findViewById(R.id.btnCardPosts);
        }
    }
}
