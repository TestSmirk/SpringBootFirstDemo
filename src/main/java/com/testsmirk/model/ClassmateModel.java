package com.testsmirk.model;


import com.testsmirk.model.room.CommentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by testsmirk on 2017/4/24.
 */

public class ClassmateModel   {
    private int gender;

    public String getToppicTitle() {
        return toppicTitle;
    }

    public void setToppicTitle(String toppicTitle) {
        this.toppicTitle = toppicTitle;
    }

    private String toppicTitle;

    private List<CommentModel> commentModels;

    public List<CommentModel> getCommentModels() {
        return commentModels;
    }

    public void setCommentModels(List<CommentModel> commentModels) {
        this.commentModels = commentModels;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getComCount() {
        return comCount;
    }

    public void setComCount(int comCount) {
        this.comCount = comCount;
    }

    public int getPirCount() {
        return pirCount;
    }

    public void setPirCount(int pirCount) {
        this.pirCount = pirCount;
    }

    private String name;
    private String time;
    private String headImage;
    private String content;
    private int comCount;
    private int pirCount;
    private ArrayList<String> imageUrl;


    public ArrayList<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ArrayList<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
