package com.sapulidi.sapulidi.model;

/**
 * Created by ar-android on 06/12/2015.
 */
public class ModelLaporan {

    private int id, img_user;
    private String title, type, content, user_post, date_time;

    public ModelLaporan(int id, int img_user, String title, String type, String content, String user_post, String date_time) {
        this.id = id;
        this.img_user = img_user;
        this.title = title;
        this.type = type;
        this.content = content;
        this.user_post = user_post;
        this.date_time = date_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser_post(String user_post) {
        this.user_post = user_post;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getUser_post() {
        return user_post;
    }

    public String getDate_time() {
        return date_time;
    }

    public int getImg_user() {
        return img_user;
    }

    public void setImg_user(int img_user) {
        this.img_user = img_user;
    }
}