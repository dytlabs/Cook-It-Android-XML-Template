package com.uiresource.cookit.recycler;

/**
 * Created by Dytstudio.
 */

public class ItemComment {
    String username, date, userphoto, comments, img1, img2;

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg2() {
        return img2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }
}
