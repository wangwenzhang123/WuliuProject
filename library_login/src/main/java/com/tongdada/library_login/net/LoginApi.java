package com.tongdada.library_login.net;

import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.example.library_commen.model.UploadBean;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wangshen on 2019/5/13.
 */

public interface LoginApi {
    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/userLogin.action")
    Observable<BaseAppEntity<UserBean>> login(@Field("phoneNo") String phone, @Field("password") String password);

    /**
     * 上传图片
     * @param requestBody
     * @return
     */
    @POST("/interface/uploadAttach.action")
    Observable<BaseAppEntity<UploadBean>> upload(@Body RequestBody requestBody);

    /**
     * 司机注册
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/driverRegister.action")
    Observable<BaseAppEntity<UserBean>> driverRegister(@FieldMap Map<String,Object> params);

    /**
     * 物流公司注册
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/logiUserRegister.action")
    Observable<BaseAppEntity<UserBean>> logiUserRegister(@FieldMap Map<String,Object> params);
    /**
     * 物流公司更新
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/updateLogi.action")
    Observable<BaseAppEntity<LogisticsRequestBean>> updateLogi(@FieldMap Map<String,Object> params);
    /**
     * 忘记密码
     * @param phone
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/forgetPassword.action")
    Observable<BaseAppEntity<UserBean>> forgetPassword(@Field("psAppUsers.userContacts") String phone);

    /**
     * 维护物流公司信息
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/logiUserRegister.action")
    Observable<BaseAppEntity<UserBean>> upDatelogiUserRegister(@FieldMap Map<String,Object> params);
}
