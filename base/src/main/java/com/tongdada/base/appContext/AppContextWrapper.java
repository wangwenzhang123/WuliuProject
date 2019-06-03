package com.tongdada.base.appContext;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.webkit.URLUtil;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * description：appliction封装类
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/7/20 16:43
 * <p>
 */
public class AppContextWrapper {

    private Application mContext;
    private static AppContextWrapper instance = new AppContextWrapper();

    private AppContextWrapper() {

    }

    public static AppContextWrapper getInstance() {
        return instance;
    }

    protected void init(Application mContext) {
        this.mContext = mContext;
    }

    public Application getContext() {
        return mContext;
    }

    public void onCreate() {

    }

}
