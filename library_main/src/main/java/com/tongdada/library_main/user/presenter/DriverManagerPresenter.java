package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.RequestRegisterBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApi;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:16
 * @change
 */
public class DriverManagerPresenter extends BasePresenter<DriverManagerContract.View> implements DriverManagerContract.Presenter {

    @Override
    public void driverList() {
        MainApiUtils.getMainApi().driverList(CommenUtils.getIncetance().getUserBean().getCompanyId())
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> requestRegisterBeanBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void deleteDriver(String id) {
        MainApiUtils.getMainApi().deleteDriver(id)
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> carOrderBeanPagenationBase) throws Exception {
                        driverList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
