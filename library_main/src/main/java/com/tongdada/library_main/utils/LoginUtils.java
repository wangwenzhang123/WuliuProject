package com.tongdada.library_main.utils;

import android.text.TextUtils;

import com.example.library_commen.utils.CommenUtils;

/**
 * Created by wangshen on 2019/6/30.
 */

public class LoginUtils {
    public static boolean isLogin(){
        if (TextUtils.isEmpty(CommenUtils.getIncetance().getUserBean().getId())){
            //ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
            return false;
        }else {
            return true;
        }
    }
}
