package com.uiresource.cookit.recycler;

/**
 * Created by Dytstudio.
 */

public class ItemRecipe {
    String time, recipe, img;
    float rating;

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}
