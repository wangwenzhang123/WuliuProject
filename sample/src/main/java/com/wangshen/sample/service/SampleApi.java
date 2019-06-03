package com.tongdada.sample.service;



import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.sample.SampleBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/7/23 19:08
 * <p>
 */
public interface SampleApi {

    @FormUrlEncoded
    @POST("sample/sampleRequst")
    Observable<BaseAppEntity<SampleBean>> sampleRequest(@Field("billnumber") String params);
}
