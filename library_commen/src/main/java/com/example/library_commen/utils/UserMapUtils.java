package com.example.library_commen.utils;

import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.UserBean;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshen on 2019/5/24.
 */

public class UserMapUtils {
    public static Map<String,Object> getUserMap(UserBean userBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psAppUsers.companyId",userBean.getCompanyId());
        map.put("psAppUsers.createUserID",userBean.getCreateUserID());
        map.put("psAppUsers.delFlag",userBean.getDelFlag());
        map.put("psAppUsers.deptId",userBean.getDeptId());
        map.put("psAppUsers.regTime",userBean.getRegTime());
        map.put("psAppUsers.stationId",userBean.getStationId());
        map.put("psAppUsers.stationRemarks",userBean.getStationRemarks());
        map.put("psAppUsers.updateUserID",userBean.getUpdateUserID());
        map.put("psAppUsers.driverId",userBean.getDriverId());
        map.put("psAppUsers.iconPic",userBean.getIconPic());
        map.put("psAppUsers.userContacts",userBean.getUserContacts());
        map.put("psAppUsers.userAddress",userBean.getUserAddress());
        map.put("psAppUsers.userPassword",userBean.getUserPassword());
        map.put("psAppUsers.userStatus",userBean.getUserStatus());
        map.put("psAppUsers.id",userBean.getId());
        map.put("psAppUsers.userName",userBean.getUserName());
        map.put("psAppUsers.frontPic",userBean.getFrontPic());
        map.put("psAppUsers.backPic",userBean.getBackPic());
        map.put("psAppUsers.userDuty",userBean.getUserDuty());
        return map;
    }
    public static Map<String,Object> getOrderMap(OrderBean requestRegisterBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psTotalOrders.stationId",requestRegisterBean.getStationId());
        map.put("psTotalOrders.carType",requestRegisterBean.getCarType());
        map.put("psTotalOrders.delFlag",requestRegisterBean.getDelFlag());
        map.put("psTotalOrders.deptId",requestRegisterBean.getDeptId());
        map.put("psTotalOrders.destinationPlace",requestRegisterBean.getDestinationPlace());
        map.put("psTotalOrders.dstLatitude",requestRegisterBean.getDstLatitude());
        map.put("psTotalOrders.dstLongitude",requestRegisterBean.getDstLongitude());
        map.put("psTotalOrders.id",requestRegisterBean.getId());
        map.put("psTotalOrders.orderAmount",requestRegisterBean.getOrderAmount());
        map.put("psTotalOrders.orderName",requestRegisterBean.getOrderName());
        map.put("psTotalOrders.orderNo",requestRegisterBean.getOrderNo());
        map.put("psTotalOrders.createTime",new Gson().toJson(requestRegisterBean.getCreateTime()));
        map.put("psTotalOrders.orderPic",requestRegisterBean.getOrderPic());
        map.put("psTotalOrders.orderRemark",requestRegisterBean.getOrderRemark());
        map.put("psTotalOrders.orderStatus",requestRegisterBean.getOrderStatus());
        map.put("psTotalOrders.perPrice",requestRegisterBean.getPerPrice());
        map.put("psTotalOrders.publishTime",requestRegisterBean.getPublishTime());
        map.put("psTotalOrders.startLatitude",requestRegisterBean.getStartLatitude());
        map.put("psTotalOrders.startLongitude",requestRegisterBean.getStartLongitude());
        map.put("psTotalOrders.startPlace",requestRegisterBean.getStartPlace());
        map.put("psTotalOrders.updateUserID",requestRegisterBean.getUpdateUserID());
        map.put("psTotalOrders.totalDistance",requestRegisterBean.getTotalDistance());
        if (requestRegisterBean.getUpdateTime() !=null){
            map.put("psTotalOrders.updateTime",new Gson().toJson(requestRegisterBean.getUpdateTime()));
        }

        return map;
    }
    public static Map<String,Object> getLogiUserRegisterMap(LogisticsRequestBean requestRegisterBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psLogisticsCompanys.companyName",requestRegisterBean.getCompanyName());
        map.put("psLogisticsCompanys.companyAddress",requestRegisterBean.getCompanyAddress());
        map.put("psLogisticsCompanys.companyContacts",requestRegisterBean.getCompanyContacts());
        map.put("psLogisticsCompanys.legalPersion",requestRegisterBean.getLegalPersion());
        map.put("psLogisticsCompanys.contactsPhone",requestRegisterBean.getContactsPhone());
        map.put("psLogisticsCompanys.registerCapital",requestRegisterBean.getRegisterCapital());
        map.put("psLogisticsCompanys.stationRemarks",requestRegisterBean.getStationRemarks());
        map.put("psLogisticsCompanys.licensePath",requestRegisterBean.getLicensePath());
        map.put("psLogisticsCompanys.roadLicensePath",requestRegisterBean.getRoadLicensePath());
        map.put("psLogisticsCompanys.createTime",new Gson().toJson(requestRegisterBean.getCreateTime()));
        map.put("psLogisticsCompanys.createUserID",requestRegisterBean.getCreateUserID());
        map.put("psLogisticsCompanys.delFlag",requestRegisterBean.getDelFlag());
        map.put("psLogisticsCompanys.deptId",requestRegisterBean.getDeptId());
        map.put("psLogisticsCompanys.id",requestRegisterBean.getId());
        map.put("psLogisticsCompanys.updateTime",new Gson().toJson(requestRegisterBean.getUpdateTime()));
        map.put("psLogisticsCompanys.updateUserID",requestRegisterBean.getUpdateUserID());
        map.put("psLogisticsCompanys.verifyStatus",requestRegisterBean.getVerifyStatus());

        return map;
    }
    public static Map<String,Object> getDriverRegisterMap(DriverRequest requestRegisterBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psDrivers.driverName",requestRegisterBean.getDriverName());
        map.put("psDrivers.driverMobile",requestRegisterBean.getDriverMobile());
        map.put("psDrivers.driverIdNo",requestRegisterBean.getDriverIdNo());
        map.put("psDrivers.driverAddress",requestRegisterBean.getDriverAddress());
        map.put("psDrivers.idFront",requestRegisterBean.getIdFront());
        map.put("psDrivers.idBack",requestRegisterBean.getIdBack());
        map.put("psDrivers.driverLicense",requestRegisterBean.getDriverLicense());
        map.put("psDrivers.driveringAge",requestRegisterBean.getDriveringAge());
        map.put("psDrivers.driverStatus",requestRegisterBean.getDriverStatus());
        map.put("psDrivers.companyId",requestRegisterBean.getCompanyId());
        map.put("psDrivers.companyName",requestRegisterBean.getCompanyName());
        map.put("psDrivers.driAge",requestRegisterBean.getDriAge());
        map.put("psDrivers.createTime",new Gson().toJson(requestRegisterBean.getCreateTime()));
        map.put("psDrivers.createUserID",requestRegisterBean.getCreateUserID());
        map.put("psDrivers.delFlag",requestRegisterBean.getDelFlag());
        map.put("psDrivers.deptId",requestRegisterBean.getDeptId());
        map.put("psDrivers.id",requestRegisterBean.getId());
        map.put("psDrivers.updateTime",new Gson().toJson(requestRegisterBean.getUpdateTime()));
        map.put("psDrivers.updateUserID",requestRegisterBean.getUpdateUserID());
        return map;
    }
    public static Map<String,Object> getCarRequestMap(CarRequestBean requestRegisterBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psCars.carName",requestRegisterBean.getCarName());
        map.put("psCars.carNo",requestRegisterBean.getCarNo());
        map.put("psCars.buyTime",requestRegisterBean.getBuyTime());
        map.put("psCars.carType",requestRegisterBean.getCarType());
        map.put("psCars.carLoad",requestRegisterBean.getCarLoad());
        map.put("psCars.driveLicense",requestRegisterBean.getDriveLicense());
        map.put("psCars.carRemarks",requestRegisterBean.getCarRemarks());
        map.put("psCars.carLongitude",requestRegisterBean.getCarLongitude());
        map.put("psCars.carLatitude",requestRegisterBean.getCarLatitude());
        map.put("psCars.companyId",requestRegisterBean.getCompanyId());
        map.put("psCars.driverId",requestRegisterBean.getDriverId());
        map.put("psCars.id",requestRegisterBean.getId());
        map.put("psCars.id",requestRegisterBean.getId());
        map.put("psCars.id",requestRegisterBean.getId());
        map.put("psCars.insuranceDate",requestRegisterBean.getInsuranceDate());
        map.put("psCars.mileages",requestRegisterBean.getMileages());
        map.put("psCars.driverName",requestRegisterBean.getDriverName());
        map.put("psCars.delFlag",requestRegisterBean.getDelFlag());
        return map;
    }
}
