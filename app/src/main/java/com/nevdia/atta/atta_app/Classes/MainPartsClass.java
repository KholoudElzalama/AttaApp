package com.nevdia.atta.atta_app.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hadirsamir on 27/03/18.
 */

public class MainPartsClass {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("main_data")
    @Expose
    private String mainData;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("img_src")
    @Expose
    private Object imgSrc;
    @SerializedName("img_src_mini")
    @Expose
    private Object imgSrcMini;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainData() {
        return mainData;
    }

    public void setMainData(String mainData) {
        this.mainData = mainData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(Object imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Object getImgSrcMini() {
        return imgSrcMini;
    }

    public void setImgSrcMini(Object imgSrcMini) {
        this.imgSrcMini = imgSrcMini;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

}
