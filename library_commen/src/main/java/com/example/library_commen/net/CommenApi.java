package com.example.library_commen.net;

import com.example.library_commen.model.DetailCarBean;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.TransportCarBean;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 10:37
 * @change
 */
public interface CommenApi {
    @FormUrlEncoded
    @POST("/interface/getDetailOrderById.action")
    Observable<BaseAppEntity<DriverOrderDetailBean>> getDetailOrderById(@Field("psDetailOrders.id") String id);
    @FormUrlEncoded
    @POST("/interface/updateDetailOrders.action")
    Observable<BaseAppEntity<DriverOrderDetailBean>> updateDetailOrders(@Field("psDetailOrders.id") String id,@Field("psDetailOrders.orderStatus") String orderStatus);
    @FormUrlEncoded
    @POST("/interface/getOrderById.action")
    Observable<BaseAppEntity<OrderBean>> getOrderById(@Field("psTotalOrders.id") String id);
    @FormUrlEncoded
    @POST("/interface/orderCarsList.action")
    Observable<PagenationBase<DetailCarBean>> orderCarsList(@Field("psDetailOrders.orderId") String id);
    @FormUrlEncoded
    @POST("/interface/cancelOrder.action")
    Observable<BaseAppEntity<OrderBean>> cancelOrder(@Field("psTotalOrders.id") String id);
    @FormUrlEncoded
    @POST("/interface/batchUpdateDetailOrders.action")
    Observable<BaseAppEntity<OrderBean>> batchUpdateDetailOrders(@Field("detailOrderIds") String id,@Field("orderStatus") String orderStatus);
}
