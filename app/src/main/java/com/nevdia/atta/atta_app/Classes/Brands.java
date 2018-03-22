package com.nevdia.atta.atta_app.Classes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brands {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("img_src")
    @Expose
    private Object imgSrc;
    @SerializedName("img_src_mini")
    @Expose
    private Object imgSrcMini;
    @SerializedName("created")
    @Expose
    private String created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
