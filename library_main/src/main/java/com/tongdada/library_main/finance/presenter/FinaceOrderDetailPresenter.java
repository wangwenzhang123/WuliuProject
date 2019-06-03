package com.tongdada.library_main.finance.presenter;

import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.example.library_commen.model.TransportCarBean;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 14:25
 * @change
 */
public class FinaceOrderDetailPresenter extends BasePresenter<FinaceOrderDetailContract.View> implements FinaceOrderDetailContract.Presenter {
    private CommenApi commenApi;

    public FinaceOrderDetailPresenter() {
        commenApi=KRetrofitFactory.createService(CommenApi.class);
    }

    @Override
    public void getOrderDetail(String id) {
        commenApi.getDetailOrderById(id)
                .compose(this.<BaseAppEntity<DriverOrderDetailBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<DriverOrderDetailBean>>() {
                    @Override
                    public void accept(BaseAppEntity<DriverOrderDetailBean> userBeanBaseAppEntity) throws Exception {
                        getView().setOrderDetail(userBeanBaseAppEntity.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void updateDetailOrders(String id, String state) {
        commenApi.batchUpdateDetailOrders(id,state)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> driverOrderDetailBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void batchUpdateDetailOrders(String id, String state) {
        commenApi.batchUpdateDetailOrders(id,state)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

}
