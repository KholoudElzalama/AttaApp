package com.nevdia.atta.atta_app.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hadirsamir on 27/03/18.
 */

public class MainPartsClass implements Serializable {
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
    private String imgSrc;
    @SerializedName("img_src_mini")
    @Expose
    private String imgSrcMini;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgSrcMini() {
        return imgSrcMini;
    }

    public void setImgSrcMini(String imgSrcMini) {
        this.imgSrcMini = imgSrcMini;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

}
