package com.uiresource.cookit.recycler;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uiresource.cookit.R;
import com.uiresource.cookit.utils.CircleGlide;

import java.util.List;

/**
 * Created by Dytstudio.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {

    private List<ItemRecipe> items;
    private Context context;
    private boolean active;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView recipe, time;
        public RatingBar ratingBar;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);

            recipe = (TextView) view.findViewById(R.id.tv_recipe_name);
            time = (TextView) view.findViewById(R.id.tv_time);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            imageView = (ImageView) view.findViewById(R.id.iv_recipe);
        }


    }


    public RecipeAdapter(List<ItemRecipe> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemRecipe itemRecipe = items.get(position);
        holder.recipe.setText(itemRecipe.getRecipe());
        holder.time.setText(itemRecipe.getTime());
        holder.ratingBar.setRating(itemRecipe.getRating());
        Glide.with(context)
                .load(Uri.parse(itemRecipe.getImg()))
                .transform(new CircleGlide(context))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}