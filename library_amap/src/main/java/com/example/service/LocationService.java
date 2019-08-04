package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.example.library_amap.presenter.LocationPresenter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.ui.mvp.base.view.BaseView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/13.
 */
@Route(path = ArouterKey.MAP_LOCATIONSERVICE)
public class LocationService extends Service implements AMapLocationListener ,BaseView {
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    private LocationPresenter presenter;
    public static LatLng START;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        presenter=new LocationPresenter();
        presenter.attchView(this);
        mlocationClient = new AMapLocationClient(this);
//初始化定位参数
        mLocationOption = new AMapLocationClientOption();
//设置定位监听
        mlocationClient.setLocationListener(this);
//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(22000);
//设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
// 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
// 在定位结束后，在合适的生命周期调用onDestroy()方法
// 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//启动定位
        mlocationClient.startLocation();

    }
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                amapLocation.getLatitude();//获取纬度
                amapLocation.getLongitude();//获取经度
                amapLocation.getAccuracy();//获取精度信息
                CommenUtils.latitude= String.valueOf(amapLocation.getLatitude());
                CommenUtils.longitude= String.valueOf(amapLocation.getLongitude());
                START=new LatLng(amapLocation.getLatitude(),amapLocation.getLongitude());
                Log.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getLatitude() + ", errInfo:"
                        + amapLocation.getLongitude());
                presenter.getSignInfo(amapLocation.getLatitude(),amapLocation.getLongitude());
                presenter.updateCarLocation(String.valueOf(amapLocation.getLatitude()),String.valueOf(amapLocation.getLongitude()));
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void hideLoadingDialog() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }

    @Override
    public void routerIntent(String path, Bundle bundle) {

    }

    @Override
    public void showToast(String ms) {

    }
}
