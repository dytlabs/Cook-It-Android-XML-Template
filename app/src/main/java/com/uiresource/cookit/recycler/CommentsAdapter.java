package com.uiresource.cookit.recycler;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uiresource.cookit.R;
import com.uiresource.cookit.utils.CircleGlide;

import java.util.List;

/**
 * Created by Dytstudio.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {

    private List<ItemComment> items;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView username, date, comment;
        public ImageView img1, img2, userphoto;

        public MyViewHolder(View view) {
            super(view);

            username = (TextView) view.findViewById(R.id.tv_username);
            date = (TextView) view.findViewById(R.id.tv_date);
            comment = (TextView) view.findViewById(R.id.tv_text_comment);
            userphoto = (ImageView) view.findViewById(R.id.iv_user);
            img1 = (ImageView) view.findViewById(R.id.imageview1);
            img2 = (ImageView) view.findViewById(R.id.imageview2);
        }

    }


    public CommentsAdapter(List<ItemComment> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemComment itemComment = items.get(position);
        holder.username.setText(itemComment.getUsername());
        holder.date.setText(itemComment.getDate());
        holder.comment.setText(itemComment.getComments());

        Glide.with(context)
                .load(Uri.parse(itemComment.getUserphoto()))
                .transform(new CircleGlide(context))
                .into(holder.userphoto);
        Glide.with(context)
                .load(Uri.parse(itemComment.getImg1()))
                .centerCrop()
                .into(holder.img1);
        Glide.with(context)
                .load(Uri.parse(itemComment.getImg2()))
                .centerCrop()
                .into(holder.img2);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
