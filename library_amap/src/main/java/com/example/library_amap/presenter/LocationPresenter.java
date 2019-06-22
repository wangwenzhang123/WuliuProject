package com.example.library_amap.presenter;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.example.library_commen.appkey.SettingString;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.SignBean;
import com.example.library_commen.net.CommenApi;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.view.BaseView;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2019/6/13.
 */

public class LocationPresenter extends BasePresenter<BaseView>implements LocationContract.Presenter {
    private CommenApi commenApi;

    public LocationPresenter() {
        commenApi= KRetrofitFactory.createService(CommenApi.class);
    }

    @Override
    public void updateCarLocation(String carLatitude, String carLongitude) {
        if (CommenUtils.LOGIN_TYPE != 0){
            commenApi.updateDriverLocation(CommenUtils.getIncetance().getUserBean().getDriverId(),carLatitude,carLongitude)
                    .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                    .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                        @Override
                        public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });
        }
    }

    @Override
    public void getSignInfo(final double la, final double lo) {
        if (CommenUtils.LOGIN_TYPE != 0){
            commenApi.getSignInfo(CommenUtils.getIncetance().getUserBean().getDriverId())
                    .compose(this.<PagenationBase<SignBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<SignBean>>() {
                        @Override
                        public void accept(PagenationBase<SignBean> orderBeanBaseAppEntity) throws Exception {
                            LatLng latLng=new LatLng(la,lo);
                            LatLng latLng1=new LatLng(Double.valueOf(orderBeanBaseAppEntity.getPagenation().getList().get(0).get(0)),Double.valueOf(orderBeanBaseAppEntity.getPagenation().getList().get(0).get(1)));
                            float distance = AMapUtils.calculateLineDistance(latLng,latLng1);
                            if (distance <= SettingString.DISTANCE){
                                driverSign(orderBeanBaseAppEntity.getPagenation().getList().get(0).get(2));
                            }/*else {
                                driverSign(orderBeanBaseAppEntity.getPagenation().getList().get(0).get(2));
                            }*/
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });
        }
    }

    @Override
    public void driverSign(String id) {
        commenApi.driverSign(id)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
