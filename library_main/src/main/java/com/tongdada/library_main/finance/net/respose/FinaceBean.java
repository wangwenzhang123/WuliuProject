package com.tongdada.library_main.finance.net.respose;

import java.io.Serializable;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinaceBean implements Serializable{
    private boolean isCheck;
    private String driverName;
    private String iconPic;
    private String carNo;
    private String acceptTime;
    private String totalDistance;
    private String startPlace;
    private String destinationPlace;
    private String carType;
    private String orderAmount;
    private String orderName;
    private String publishTime;
    private String orderStatus;
    private String rowId;
    private String orderPrice;
    private String driverMobile;
    private String companyName;

    public FinaceBean(String driverName, String iconPic, String carNo, String acceptTime, String totalDistance, String startPlace, String destinationPlace, String carType, String orderAmount, String orderName, String publishTime, String orderStatus, String rowId, String orderPrice, String driverMobile, String companyName) {
        this.driverName = driverName;
        this.iconPic = iconPic;
        this.carNo = carNo;
        this.acceptTime = acceptTime;
        this.totalDistance = totalDistance;
        this.startPlace = startPlace;
        this.destinationPlace = destinationPlace;
        this.carType = carType;
        this.orderAmount = orderAmount;
        this.orderName = orderName;
        this.publishTime = publishTime;
        this.orderStatus = orderStatus;
        this.rowId = rowId;
        this.orderPrice = orderPrice;
        this.driverMobile = driverMobile;
        this.companyName = companyName;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getIconPic() {
        return iconPic;
    }

    public void setIconPic(String iconPic) {
        this.iconPic = iconPic;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
