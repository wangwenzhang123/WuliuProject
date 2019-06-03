package com.tongdada.sample.data;

;

import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.sample.SampleBean;
import com.tongdada.sample.service.SampleApi;

import java.util.HashMap;

import io.reactivex.Observable;


/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/7/23 19:07
 * <p>
 */
public class SampleDataSource {

    public Observable<BaseAppEntity<SampleBean>> sampleRequest(String code) {
        return KRetrofitFactory.createService(SampleApi.class)
                .sampleRequest(code);
    }

}
