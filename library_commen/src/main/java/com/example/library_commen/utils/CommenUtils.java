package com.example.library_commen.utils;

import com.example.library_commen.appkey.ShareKey;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.model.UserBean;
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
    private CarRequestBean carRequestBean;
    private LogisticsRequestBean requestBean;
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

    public CarRequestBean getCarRequestBean() {
        return (carRequestBean==null)? new CarRequestBean():carRequestBean;
    }

    public void setCarRequestBean(CarRequestBean carRequestBean) {
        this.carRequestBean = carRequestBean;
    }

    public LogisticsRequestBean getRequestBean() {
        return (requestBean==null)? new LogisticsRequestBean():requestBean;
    }

    public void setRequestBean(LogisticsRequestBean requestBean) {
        this.requestBean = requestBean;
    }

    public UserBean getUserBean() {
        return (userBean== null)? new UserBean():userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
        SharedPreferencesUtil.getInstance().putString(ShareKey.USER_BEAN,new Gson().toJson(userBean));
    }
}
