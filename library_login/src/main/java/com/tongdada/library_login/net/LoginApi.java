package com.tongdada.library_login.net;

import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.example.library_commen.model.RequestRegisterBean;
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
    @FormUrlEncoded
    @POST("/interface/userLogin.action")
    Observable<BaseAppEntity<UserBean>> login(@Field("phoneNo") String phone, @Field("password") String password);

    @POST("/interface/uploadAttach.action")
    Observable<BaseAppEntity<UploadBean>> upload(@Body RequestBody requestBody);
    @FormUrlEncoded
    @POST("/interface/mixUserRegister.action")
    Observable<BaseAppEntity<UserBean>> regist(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST("/interface/forgetPassword.action")
    Observable<BaseAppEntity<UserBean>> forgetPassword(@Field("psAppUsers.userContacts") String phone);
}
