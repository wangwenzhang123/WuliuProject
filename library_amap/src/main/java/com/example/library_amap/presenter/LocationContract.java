package com.example.library_amap.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by Administrator on 2019/6/13.
 */

public class LocationContract {

    public interface Presenter{
        void updateCarLocation(String carLatitude,String carLongitude);
        void getSignInfo(double la,double lo);
        void driverSign(String id);
    }
}
