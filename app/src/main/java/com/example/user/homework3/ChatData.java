package com.example.user.homework3;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by User on 11/17/2016.
 */

public class ChatData {
    private int profile;
    private String username;
    private String post_date;
    private int btnFavorite;
    private int btnMore;
    private String status;
    private int image;
    private int total_like;
    private int total_comment;
    private int total_share;
    private int btn_total_like;
    private int btn_total_comment;
    private int btn_total_share;



    /*public ChatData(int profile, String username, String post_date, int btnFavorite, int btnMore, String status, int image, int total_like, int total_comment, int total_share, int btn_total_like, int btn_total_comment, int btn_total_share) {
        this.profile = profile;
        this.username = username;
        this.post_date = post_date;
        this.btnFavorite = btnFavorite;
        this.btnMore = btnMore;
        this.status = status;
        this.image = image;
        this.total_like = total_like;
        this.total_comment = total_comment;
        this.total_share = total_share;
        this.btn_total_like = btn_total_like;
        this.btn_total_comment = btn_total_comment;
        this.btn_total_share = btn_total_share;
    }*/

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public int getBtnFavorite() {
        return btnFavorite;
    }

    public void setBtnFavorite(int btnFavorite) {
        this.btnFavorite = btnFavorite;
    }

    public int getBtnMore() {
        return btnMore;
    }

    public void setBtnMore(int btnMore) {
        this.btnMore = btnMore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTotal_like() {
        return total_like;
    }

    public void setTotal_like(int total_like) {
        this.total_like = total_like;
    }

    public int getTotal_comment() {
        return total_comment;
    }

    public void setTotal_comment(int total_comment) {
        this.total_comment = total_comment;
    }

    public int getTotal_share() {
        return total_share;
    }

    public void setTotal_share(int total_share) {
        this.total_share = total_share;
    }

    public int getBtn_total_like() {
        return btn_total_like;
    }

    public void setBtn_total_like(int btn_total_like) {
        this.btn_total_like = btn_total_like;
    }

    public int getBtn_total_comment() {
        return btn_total_comment;
    }

    public void setBtn_total_comment(int btn_total_comment) {
        this.btn_total_comment = btn_total_comment;
    }

    public int getBtn_total_share() {
        return btn_total_share;
    }

    public void setBtn_total_share(int btn_total_share) {
        this.btn_total_share = btn_total_share;
    }
}
