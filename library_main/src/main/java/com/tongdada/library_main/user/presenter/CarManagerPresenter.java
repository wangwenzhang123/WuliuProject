package com.tongdada.library_main.user.presenter;

import android.text.TextUtils;

import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.user.respose.CarListBean;

import io.reactivex.functions.Consumer;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:16
 * @change
 */
public class CarManagerPresenter extends BasePresenter<CarManagerContract.View> implements CarManagerContract.Presenter {

    @Override
    public void getCarList() {
        if (!TextUtils.isEmpty(CommenUtils.getIncetance().getUserBean().getCompanyId())){
            MainApiUtils.getMainApi().listCars(CommenUtils.getIncetance().getRequestBean().getId(),"")
                    .compose(this.<PagenationBase<CarListBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<CarListBean>>() {
                        @Override
                        public void accept(PagenationBase<CarListBean> driverBeanPagenationBase) throws Exception {
                            getView().setCarList(driverBeanPagenationBase.getPagenation().getList());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });
        }else {
            MainApiUtils.getMainApi().listCars("",CommenUtils.getIncetance().getUserBean().getDriverId())
                    .compose(this.<PagenationBase<CarListBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<CarListBean>>() {
                        @Override
                        public void accept(PagenationBase<CarListBean> driverBeanPagenationBase) throws Exception {
                            getView().setCarList(driverBeanPagenationBase.getPagenation().getList());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });
        }

    }

    @Override
    public void deleteCar(String id) {
        MainApiUtils.getMainApi().deleteCar(id)
                .compose(this.<BaseAppEntity<CarRequestBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<CarRequestBean>>() {
                    @Override
                    public void accept(BaseAppEntity<CarRequestBean> requestRegisterBeanBaseAppEntity) throws Exception {
                        getCarList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
