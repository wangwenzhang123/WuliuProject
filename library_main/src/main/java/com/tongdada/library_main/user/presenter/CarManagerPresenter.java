package com.tongdada.library_main.user.presenter;

import android.text.TextUtils;

import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.user.respose.CarListBean;

import java.util.ArrayList;
import java.util.List;

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
    public void getCarList(final boolean isSelect, final String type) {
            MainApiUtils.getMainApi().listCars(CommenUtils.getIncetance().getUserBean().getCompanyId(),CommenUtils.getIncetance().getUserBean().getDriverId())
                    .compose(this.<PagenationBase<CarListBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<CarListBean>>() {
                        @Override
                        public void accept(PagenationBase<CarListBean> driverBeanPagenationBase) throws Exception {
                            List <CarRequestBean> list=new ArrayList<>();
                            for (int i = 0; i < driverBeanPagenationBase.getPagenation().getList().size(); i++) {
                                CarRequestBean carRequestBean=driverBeanPagenationBase.getPagenation().getList().get(i);
                                if (isSelect){
                                    if (carRequestBean.getCarStatus().equals("K") ){
                                        if (type.contains("B")){
                                            if (type.equals(carRequestBean.getCarType())){
                                                list.add(carRequestBean);
                                            }
                                        }else {
                                            if (type.contains(carRequestBean.getCarType())){
                                                list.add(carRequestBean);
                                            }
                                        }

                                    }
                                }else {
                                    list.add(carRequestBean);
                                }
                            }
                            getView().setCarList(list);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                        }
                    });
    }

    @Override
    public void deleteCar(String id) {
        MainApiUtils.getMainApi().deleteCar(id)
                .compose(this.<BaseAppEntity<CarRequestBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<CarRequestBean>>() {
                    @Override
                    public void accept(BaseAppEntity<CarRequestBean> requestRegisterBeanBaseAppEntity) throws Exception {
                        getCarList(false,null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
