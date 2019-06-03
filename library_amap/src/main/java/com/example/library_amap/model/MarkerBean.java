package com.example.library_amap.model;

import android.graphics.Bitmap;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/27 11:11
 * @change
 */
public class MarkerBean {
    private double jing;
    private double wei;
    private String id;
    private Bitmap bitmap;

    public MarkerBean(double jing, double wei, String id, Bitmap bitmap) {
        this.jing = jing;
        this.wei = wei;
        this.id = id;
        this.bitmap = bitmap;
    }

    public double getJing() {
        return jing;
    }

    public void setJing(double jing) {
        this.jing = jing;
    }

    public double getWei() {
        return wei;
    }

    public void setWei(double wei) {
        this.wei = wei;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
