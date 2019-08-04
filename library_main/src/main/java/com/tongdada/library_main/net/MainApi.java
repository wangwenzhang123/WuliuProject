package com.tongdada.library_main.net;

import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.DriverBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.order.respose.OrderListBean;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;
import com.tongdada.library_main.recruit.respose.ResumeBean;
import com.tongdada.library_main.user.respose.CarListBean;
import com.tongdada.library_main.user.respose.MessageBean;
import com.tongdada.library_main.user.respose.UserListBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wangshen on 2019/5/17.
 */

public interface MainApi {
    /**
     * 获取轮播页数据
     * @return
     */
    @POST("/tonghe/newsList.action")
    Observable<BannerBean> shuffling();
    /**
     * 发布订单
     */
    @FormUrlEncoded
    @POST("/tonghe/publishOrder.action")
    Observable<BaseAppEntity<Object>> publishOrder(@FieldMap Map<String,Object> map
            /*@Field("psTotalOrders.stationId") String stationId,
                                                   @Field("psTotalOrders.orderAmount") String orderAmount,
                                                   @Field("psTotalOrders.startPlace") String startPlace,
                                                   @Field("psTotalOrders.destinationPlace") String destinationPlace,
                                                   @Field("psTotalOrders.startLongitude") String startLongitude,
                                                   @Field("psTotalOrders.startLatitude") String startLatitude,
                                                   @Field("psTotalOrders.dstLongitude") String dstLongitude,
                                                   @Field("psTotalOrders.dstLatitude") String dstLatitude,
                                                   @Field("psTotalOrders.totalDistance") String totalDistance,
                                                   @Field("psTotalOrders.perPrice") String perPrice,
                                                @Field("psTotalOrders.orderStatus") String orderStatus,
                                                @Field("psTotalOrders.orderName") String orderName,
                                                   @Field("psTotalOrders.carType") String carType,
                                                @Field("psTotalOrders.orderRemark") String orderRemark
            ,
                                                   @Field("psTotalOrders.publishTime") String publishTime
            ,
                                                   @Field("psTotalOrders.orderPic") String orderPic*/


    );
    /**
     * 获取订单列表
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/orderList.action")
    Observable<PagenationBase<OrderListBean>> orderList(@Field("psTotalOrders.stationId") String stationId,
                                                        @Field("psTotalOrders.companyId") String companyId,
                                                        @Field("page") String pageNumber,
                                                        @Field("psTotalOrders.orderName") String orderName,
                                                        @Field("psTotalOrders.orderStatus") String orderStatus,
                                                        @Field("psTotalOrders.carType") String carType);
    /**
     * 获取订单列表
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/orderListOfRange.action")
    Observable<PagenationBase<OrderListBean>> orderListOfRange(@Field("psTotalOrders.stationId") String stationId,
                                                        @Field("psTotalOrders.companyId") String companyId,
                                                        @Field("page") String pageNumber,
                                                        @Field("psTotalOrders.orderName") String orderName,
                                                        @Field("psTotalOrders.orderStatus") String orderStatus,
                                                        @Field("psTotalOrders.carType") String carType,
                                                        @Field("latitude") String latitude,
                                                               @Field("longitude") String longitude
    );
    /**
     * 获取物流总订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/findLogiOrders.action")
    Observable<PagenationBase<OrderListBean>> findLogiOrders(@Field("psDetailOrders.driverId") String driverId,
                                                        @Field("psDetailOrders.companyId") String companyId, @Field("page") String pageNumber);
    /**
     * 修改订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editOrder.action")
    Observable<BaseAppEntity<Object>> editOrder(@FieldMap Map<String,Object> stationId);
    /**
     * 取消订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/cancelOrder.action")
    Observable<BaseAppEntity<Object>> cancelOrder(@Field("orderId") String stationId);
    /**
     * 修改密码
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editPassword.action")
    Observable<BaseAppEntity<UserBean>> editPassword(@Field("psAppUsers.id") String id,
                                                @Field("oldPassword") String oldPassword,
                                                @Field("newPassword") String newPassword);
    /**
     * 人员列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/userList.action")
    Observable<UserListBean> userList(@Field("psAppUsers.companyId") String id);
    /**
     * 删除人员
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/deleteUser.action")
    Observable<UserListBean> deleteUser(@Field("psAppUsers.id") String id);

    /**
     * 修改人员信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editUser.action")
    Observable<BaseAppEntity<UserBean>> editUser(@FieldMap Map<String,Object> requestBody/*@Field("psAppUsers.stationId") String id,@Field("psAppUsers.userName") String userName
            ,@Field("psAppUsers.userAddress") String userAddress
            ,@Field("psAppUsers.userContacts") String userContacts
            ,@Field("psAppUsers.iconPic") String iconPic*/);
    /**
     * 添加人员
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/addLogiUser.action")
    Observable<BaseAppEntity<UserBean>> addStationUser(@FieldMap Map<String,Object> requestBody);
    /**
     * 获取消息列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/messageList.action")
    Observable<MessageBean> messageList(@Field("psMessages.appUserId") String id, @Field("psMessages.messageContent") String messageContent);
    /**
     * 阅读消息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/readMessage.action")
    Observable<BaseAppEntity<Object>> readMessage(@Field("psMessages.id") String id);
    /**
     * 删除消息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/deleteMessage.action")
    Observable<BaseAppEntity<Object>> deleteMessage(@Field("psMessages.id") String id);
    /**
     * 系统设置
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/sysSet.action")
    Observable<BaseAppEntity<Object>> sysSet(@Field("psMixingStations.id") String id,@Field("psMixingStations.tongPrice") String tongPrice,@Field("psMixingStations.bengPrice") String bengPrice);
    /**
     * 获取物流公司信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/getLogiById.action")
    Observable<BaseAppEntity<LogisticsRequestBean>> getLogiById(@Field("psLogisticsCompanys.id") String id);

    /**
     * 上传图片
     * @param requestBody
     * @return
     */
    @POST("/tonghe/uploadAttach.action")
    Observable<BaseAppEntity<UploadBean>> upload(@Body RequestBody requestBody);
    /**
     * 获取子订单列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/findDetailList.action")
    Observable<PagenationBase<CarOrderBean>> detailOrderList(@Field("psDetailOrders.companyId") String id, @Field("psDetailOrders.orderStatus") String orderStatus
            , @Field("psDetailOrders.orderRemark") String orderRemark,
                                                             @Field("page") String pageNumber, @Field("psDetailOrders.orderId") String orderId, @Field("psDetailOrders.driverId") String driverId
    );
    /**
     * 获取司机列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/driverList.action")
    Observable<PagenationBase<DriverBean>> driverList(@Field("psDrivers.companyId") String id);
    /**
     * 删除司机
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/deleteDriver.action")
    Observable<BaseAppEntity<DriverRequest>> deleteDriver(@Field("psDrivers.id") String id);
    /**
     * 添加司机
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/addDriver.action")
    Observable<BaseAppEntity<DriverRequest>> addDriver(@FieldMap Map<String,Object> params);
    /**
     * 更新司机信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/updateDriver.action")
    Observable<BaseAppEntity<DriverRequest>> updateDriver(@FieldMap Map<String,Object> params);
    /**
     * 获取车辆列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listCars.action")
    Observable<PagenationBase<CarListBean>> listCars(@Field("psCars.companyId") String companyId, @Field("psCars.driverId") String driverId);
    /**
     * 删除车辆
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/deleteCar.action")
    Observable<BaseAppEntity<CarRequestBean>> deleteCar(@Field("psCars.id") String id);
    /**
     * 添加车辆
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/addCar.action")
    Observable<BaseAppEntity<CarRequestBean>> addCar(@FieldMap Map<String,Object> params);
    /**
     * 更新车辆信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/updateCar.action")
    Observable<BaseAppEntity<CarRequestBean>> updateCar(@FieldMap Map<String,Object> params);
    /**
     * 获取司机信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/getDriverById.action")
    Observable<BaseAppEntity<DriverRequest>> getDriverById(@Field("psDrivers.id") String id);
    /**
     * 获取司机信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/getCarById.action")
    Observable<BaseAppEntity<CarRequestBean>> getCarById(@Field("psCars.id") String id);
    /**
     * 发布招聘
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/publishPosition.action")
    Observable<PagenationBase<CarOrderBean>> publishPosition(/*@Field("psPositions.positionName") String positionName,
                                                             @Field("psPositions.positionSalary") String positionSalary,
                                                             @Field("psPositions.companyId") String companyId,
                                                             @Field("psPositions.positionRemarks") String positionRemarks,
                                                             @Field("psPositions.stationId") String stationId,
                                                             @Field("psPositions.companyName") String companyName,
                                                             @Field("psPositions.companyAddress") String companyAddress,
                                                             @Field("psPositions.contacts") String contacts,
                                                             @Field("psPositions.phoneNo") String phoneNo,
                                                             @Field("psPositions.endTime") String endTime,
                                                             @Field("psPositions.publishTime") String publishTime*/
            @FieldMap Map<String,Object> params
    );
    /**
     * 修改招聘
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editPosition.action")
    Observable<PagenationBase<CarOrderBean>> editPosition(/*@Field("psPositions.positionName") String positionName,
                                                             @Field("psPositions.positionSalary") String positionSalary,
                                                             @Field("psPositions.companyId") String companyId,
                                                             @Field("psPositions.positionRemarks") String positionRemarks,
                                                             @Field("psPositions.stationId") String stationId,
                                                             @Field("psPositions.companyName") String companyName,
                                                             @Field("psPositions.companyAddress") String companyAddress,
                                                             @Field("psPositions.contacts") String contacts,
                                                             @Field("psPositions.phoneNo") String phoneNo,
                                                             @Field("psPositions.endTime") String endTime,
                                                             @Field("psPositions.publishTime") String publishTime*/
            @FieldMap Map<String,Object> params
    );
    /**
     * 获取招聘列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listPosition.action")
    Observable<PagenationBase<RecruitmentBean>> listPosition(@Field("psPositions.positionName") String positionName,
                                                             @Field("psPositions.companyId") String companyId,
                                                             @Field("psPositions.stationId") String stationId,
                                                             @Field("page") int page
    );

    /**
     * 获取招聘列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listPostionsOfUser.action")
    Observable<PagenationBase<RecruitmentBean>> listPostionsOfUser(@Field("psPositionApply.userId") String userId,
                                                                   @Field("page") int page);
    /**
     * 取消招聘
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/cancelPosition.action")
    Observable<PagenationBase<RecruitmentBean>> cancelPosition(@Field("psPositions.id") String positionName
    );
    /**
     * 获取简历中心列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listApply.action")
    Observable<PagenationBase<ResumeBean>> listApply(@Field("psPositions.positionName") String positionName,
                                                     @Field("psPositions.companyId") String companyId,
                                                     @Field("psPositions.stationId") String stationId
    );
    /**
     * 申请职位
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/applyPosition.action")
    Observable<PagenationBase<ResumeBean>> applyPosition(@Field("psPositionApply.positionId") String positionId,
                                                     @Field("psPositionApply.userId") String companyId

    );
    /**
     * 获取简历列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listUsersOfPostion.action")
    Observable<PagenationBase<ResumeBean>> listUsersOfPostion(@Field("psPositionApply.positionId") String positionId,
                                                             @Field("psPositionApply.stationId") String stationId,
                                                             @Field("psPositionApply.companyId") String companyId,
                                                              @Field("page") int page

    );
}
