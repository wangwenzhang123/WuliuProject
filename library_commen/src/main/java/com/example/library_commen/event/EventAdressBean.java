package com.example.library_commen.event;

/**
 * Created by wangshen on 2019/5/22.
 */

public class EventAdressBean {
    private String adressName;
    private double longitude;
    private double latitude;
    private int  code;

    public EventAdressBean() {
    }

    public EventAdressBean(String adressName, long longitude, long latitude, int code) {
        this.adressName = adressName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.code = code;
    }

    public String getAdressName() {
        return adressName;
    }

    public void setAdressName(String adressName) {
        this.adressName = adressName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
