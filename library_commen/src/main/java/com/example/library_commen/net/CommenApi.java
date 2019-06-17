package com.example.library_commen.net;

import com.example.library_commen.model.DetailCarBean;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.TransportCarBean;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
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
    Observable<PagenationBase<DetailCarBean>> orderCarsList(@Field("psDetailOrders.orderId") String id,@Field("psDetailOrders.driverId") String driverId);
    @FormUrlEncoded
    @POST("/interface/cancelOrder.action")
    Observable<BaseAppEntity<OrderBean>> cancelOrder(@Field("psTotalOrders.id") String id);
    @FormUrlEncoded
    @POST("/interface/batchUpdateDetailOrders.action")
    Observable<BaseAppEntity<OrderBean>> batchUpdateDetailOrders(@Field("detailOrderIds") String id,@Field("orderStatus") String orderStatus);
    /**
     * 上传图片
     * @param requestBody
     * @return
     */
    @POST("/interface/uploadAttach.action")
    Observable<BaseAppEntity<UploadBean>> upload(@Body RequestBody requestBody);

    /**
     * 物流端接单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/acceptOrderOfLogi.action")
    Observable<BaseAppEntity<OrderBean>> acceptOrderOfLogi(@Field("psDetailOrders.orderAmount") String orderAmount,
                                                           @Field("psDetailOrders.orderId") String orderId,
                                                           @Field("psDetailOrders.totalDistance") String totalDistance,
                                                           @Field("psDetailOrders.orderRemark") String orderRemark,
                                                           @Field("psDetailOrders.stationId") String stationId,
                                                           @Field("psDetailOrders.stationName") String stationName,
                                                           @Field("psDetailOrders.companyId") String companyId,
                                                           @Field("carIds") String carIds,
                                                           @Field("psDetailOrders.orderPrice") String orderPrice

                                                           );
    /**
     * 物流端接单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/acceptOrderOfDriver.action")
    Observable<BaseAppEntity<OrderBean>> acceptOrderOfDriver(@Field("psDetailOrders.orderAmount") String orderAmount,
                                                           @Field("psDetailOrders.orderId") String orderId,
                                                           @Field("psDetailOrders.totalDistance") String totalDistance,
                                                           @Field("psDetailOrders.orderRemark") String orderRemark,
                                                           @Field("psDetailOrders.stationId") String stationId,
                                                           @Field("psDetailOrders.stationName") String stationName,
                                                           @Field("psDetailOrders.companyId") String companyId,
                                                             @Field("psDetailOrders.driverId") String driverId,
                                                             @Field("psDetailOrders.driverName") String driverName,
                                                             @Field("psDetailOrders.carNo") String carNo,
                                                           @Field("psDetailOrders.carId") String carIds,
                                                           @Field("psDetailOrders.orderPrice") String orderPrice

    );
    /**
     * 上传装货凭据
     * @param id
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/loadOrder.action")
    Observable<BaseAppEntity<OrderBean>> loadOrder(@Field("psDetailOrders.id") String id,@Field("psDetailOrders.loadLicense") String loadLicense);

    /**
     * 上传卸货凭据
     * @param id
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/unloadOrder.action")
    Observable<BaseAppEntity<OrderBean>> unloadOrder(@Field("psDetailOrders.id") String id,@Field("psDetailOrders.unloadLicense") String unloadLicense);
    /**
     * 取消订单
     * @param id
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/cancelDetailOrder.action")
    Observable<BaseAppEntity<OrderBean>> cancelDetailOrder(@Field("psDetailOrders.id") String id);
    /**
     * 取消订单
     * @param id
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("interface/updateDriverLocation.action")
    Observable<BaseAppEntity<OrderBean>> updateDriverLocation(@Field("psDrivers.id") String id,@Field("psDrivers.driverLatitude") String carLatitude,@Field("psDrivers.driverLongitude") String carLongitude);

}
