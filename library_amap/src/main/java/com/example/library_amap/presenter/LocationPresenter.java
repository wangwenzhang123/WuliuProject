package com.example.library_amap.presenter;

import com.example.library_commen.model.OrderBean;
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
}
