package com.tongdada.library_main.net;

import com.tongdada.base.net.client.KRetrofitFactory;

/**
 * Created by wangshen on 2019/5/17.
 */

public class MainApiUtils {
    private static MainApi mainApi;
    public static MainApi getMainApi(){
        synchronized (MainApi.class){
            if (mainApi == null){
                synchronized (MainApi.class){
                    mainApi= KRetrofitFactory.createService(MainApi.class);
                }
            }
        }
        return mainApi;
    }
}
