package com.tongdada.wuliu;

import android.content.Intent;

import com.example.service.LocationService;
import com.tongdada.base.appContext.AppContext;

/**
 * Created by Administrator on 2019/6/13.
 */

public class App extends AppContext {
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, LocationService.class));
    }
}
