package com.nevdia.atta.atta_app.Classes;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MainPartItem implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("categories_mhk_id")
    @Expose
    private String categoriesMhkId;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("item_desc")
    @Expose
    private String itemDesc;
    @SerializedName("item_price")
    @Expose
    private String itemPrice;
    @SerializedName("img_src")
    @Expose
    private String imgSrc;
    @SerializedName("img_src_mini")
    @Expose
    private String imgSrcMini;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
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

    public String getCategoriesMhkId() {
        return categoriesMhkId;
    }

    public void setCategoriesMhkId(String categoriesMhkId) {
        this.categoriesMhkId = categoriesMhkId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}

