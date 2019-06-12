package com.example.library_commen.presenter;

import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;

import io.reactivex.functions.Consumer;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/5 14:02
 * @change
 */
public class LogicOrderDetailPresenter extends BasePresenter<LogicOrderDetailContract.View> implements LogicOrderDetailContract.Presenter {
    private CommenApi commenApi;

    public LogicOrderDetailPresenter() {
        commenApi= KRetrofitFactory.createService(CommenApi.class);
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
    public void batchUpdateDetailOrders(String id, String state) {
        commenApi.batchUpdateDetailOrders(id,state)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
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
