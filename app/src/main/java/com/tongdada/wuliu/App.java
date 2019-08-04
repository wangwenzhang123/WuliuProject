package com.tongdada.wuliu;

import android.content.Intent;

import com.example.service.LocationService;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tongdada.base.appContext.AppContext;

/**
 * Created by Administrator on 2019/6/13.
 */

public class App extends AppContext {
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, LocationService.class));
        Bugly.init(getApplicationContext(), "d31305cafe", false);
        Beta.checkUpgrade(false,false);
        Beta.autoInit = true;
        Beta.autoCheckUpgrade = true;
        Beta.upgradeCheckPeriod = 60 * 1000;
    }
}
