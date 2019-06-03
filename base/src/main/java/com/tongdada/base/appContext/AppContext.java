package com.tongdada.base.appContext;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tongdada.base.BuildConfig;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.crash.CrashHandler;
import com.tongdada.base.net.client.KRetrofitConfig;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.net.interceptor.ExCookieInterceptor;
import com.tongdada.base.util.SharedPreferencesUtil;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:29
 * @change
 */
public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
        KRetrofitConfig config = new KRetrofitConfig.Builder()
                .baseUrl(BaseUrl.BASEURL)
                .retryOnConnectionFailure(false)
                .setConnectTimeout(40)
                .setReadTimeout(40)
                .setWriteTimeout(40)
                .addInterceptor(new ExCookieInterceptor())

                .build();
        KRetrofitFactory.init(config);
        CrashHandler.getInstance().init(this);
        SharedPreferencesUtil.init(this, Context.MODE_PRIVATE);
        AppContextWrapper.getInstance().init(this);
    }
}
