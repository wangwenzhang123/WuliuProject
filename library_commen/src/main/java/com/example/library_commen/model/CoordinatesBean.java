package com.example.library_commen.model;

import java.io.Serializable;

/**
 * Created by wangshen on 2019/5/25.
 */

public class CoordinatesBean implements Serializable{
    private String startLatitude;
    private String startLongitude;
    private String dstLatitude;
    private String dstLongitude;
    private String startPlace;
    private String destinationPlace;
    private String totalDistance;

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getDstLatitude() {
        return dstLatitude;
    }

    public void setDstLatitude(String dstLatitude) {
        this.dstLatitude = dstLatitude;
    }

    public String getDstLongitude() {
        return dstLongitude;
    }

    public void setDstLongitude(String dstLongitude) {
        this.dstLongitude = dstLongitude;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }
}
