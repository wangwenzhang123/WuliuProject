package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.RequestRegisterBean;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:16
 * @change
 */
public class AddCarPresenter extends BasePresenter<AddCarContract.View> implements AddCarContract.Presenter {

    @Override
    public void addCar(CarRequestBean carRequestBean) {
        MainApiUtils.getMainApi().addCar(UserMapUtils.getCarRequestMap(carRequestBean))
             .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> requestRegisterBeanBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void upload(String path, int dex) {

    }
}
