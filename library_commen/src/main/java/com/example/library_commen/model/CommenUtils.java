package com.example.library_commen.model;

import com.example.library_commen.appkey.ShareKey;
import com.google.gson.Gson;
import com.tongdada.base.util.SharedPreferencesUtil;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/23 16:23
 * @change
 */
public class CommenUtils {
    private static CommenUtils commenUtils;
    private UserBean userBean;
    private RequestRegisterBean requestRegisterBean;
    private CommenUtils() {
    }
    public static CommenUtils getIncetance(){
        synchronized (CommenUtils.class){
            if (commenUtils == null){
                synchronized (CommenUtils.class){
                    commenUtils=new CommenUtils();
                }
            }
        }
        return commenUtils;
    }

    public RequestRegisterBean getRequestRegisterBean() {
        return (requestRegisterBean==null)? new RequestRegisterBean():requestRegisterBean;
    }

    public void setRequestRegisterBean(RequestRegisterBean requestRegisterBean) {
        this.requestRegisterBean = requestRegisterBean;
    }

    public UserBean getUserBean() {
        return (userBean== null)? new UserBean():userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
        SharedPreferencesUtil.getInstance().putString(ShareKey.USER_BEAN,new Gson().toJson(userBean));
    }
}
