package com.example.library_commen.utils;

import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.RequestRegisterBean;
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
    public static Map<String,Object> getMixingStationsMap(RequestRegisterBean requestRegisterBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psMixingStations.logoPic",requestRegisterBean.getLogoPic());
        map.put("psMixingStations.stationName",requestRegisterBean.getStationName());
        map.put("psMixingStations.stationAddress",requestRegisterBean.getStationAddress());
        map.put("psMixingStations.stationContacts",requestRegisterBean.getStationContacts());
        map.put("psMixingStations.legalPersion",requestRegisterBean.getLegalPersion());
        map.put("psMixingStations.contactsPhone",requestRegisterBean.getContactsPhone());
        map.put("psMixingStations.registerCapita",requestRegisterBean.getRegisterCapita());
        map.put("psMixingStations.stationRemarks",requestRegisterBean.getStationRemarks());
        map.put("psMixingStations.licensePic",requestRegisterBean.getLicensePic());
        map.put("psMixingStations.frontPic",requestRegisterBean.getFrontPic());
        map.put("psMixingStations.backPic",requestRegisterBean.getBackPic());
        map.put("psMixingStations.bengPrice",requestRegisterBean.getBengPrice());
        map.put("psMixingStations.createTime",new Gson().toJson(requestRegisterBean.getCreateTime()));
        map.put("psMixingStations.createUserID",requestRegisterBean.getCreateUserID());
        map.put("psMixingStations.delFlag",requestRegisterBean.getDelFlag());
        map.put("psMixingStations.deptId",requestRegisterBean.getDeptId());
        map.put("psMixingStations.id",requestRegisterBean.getId());
        map.put("psMixingStations.registerCapital",requestRegisterBean.getRegisterCapital());
        map.put("psMixingStations.tongPrice",requestRegisterBean.getTongPrice());
        map.put("psMixingStations.updateTime",new Gson().toJson(requestRegisterBean.getUpdateTime()));
        map.put("psMixingStations.updateUserID",requestRegisterBean.getUpdateUserID());
        map.put("psMixingStations.verifyStatus",requestRegisterBean.getVerifyStatus());
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
}
