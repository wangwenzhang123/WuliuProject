package com.example.library_amap.presenter;

import com.example.library_amap.model.AcceptRequestBean;
import com.example.library_commen.event.EventAddBean;
import com.example.library_commen.event.EventSuccessBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/6/8.
 */

public class AcceptOrderPresenter extends BasePresenter<AcceptOrderContract.View>implements AcceptOrderContract.Presenter {
    private CommenApi commenApi;

    public AcceptOrderPresenter() {
        commenApi= KRetrofitFactory.createService(CommenApi.class);
    }

    @Override
    public void getOrderById(String id) {
        commenApi.getOrderById(id)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().setOrderDetail(orderBeanBaseAppEntity.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void acceptOrderOfLogi(AcceptRequestBean acceptRequestBean) {
        commenApi.acceptOrderOfLogi(acceptRequestBean.getOrderAmount(),acceptRequestBean.getOrderId(),acceptRequestBean.getTotalDistance(),
                acceptRequestBean.getOrderRemark(),acceptRequestBean.getStationId(),acceptRequestBean.getStationName(),acceptRequestBean.getCompanyId(),
                acceptRequestBean.getCarIds(),acceptRequestBean.getOrderPrice())
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        EventBus.getDefault().post(new EventSuccessBean());
                        getView().showToast("接单成功");
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
    @Override
    public void acceptOrderOfDriver(AcceptRequestBean acceptRequestBean) {
        commenApi.acceptOrderOfDriver(acceptRequestBean.getOrderAmount(),
                acceptRequestBean.getOrderId(),
                acceptRequestBean.getTotalDistance(),
                acceptRequestBean.getOrderRemark(),
                acceptRequestBean.getStationId(),
                acceptRequestBean.getStationName(),
                acceptRequestBean.getCompanyId(),
                acceptRequestBean.getDriverId(),
                acceptRequestBean.getDriverName(),
                acceptRequestBean.getCarNo(),
                acceptRequestBean.getCarId(),
                acceptRequestBean.getOrderPrice())
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        EventBus.getDefault().post(new EventSuccessBean());
                        getView().showToast("接单成功");
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
