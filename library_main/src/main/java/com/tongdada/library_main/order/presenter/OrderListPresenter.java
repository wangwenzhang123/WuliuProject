package com.tongdada.library_main.order.presenter;

import android.os.Handler;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.library_main.net.MainApiUtils;
import com.example.library_commen.model.PagenationBase;
import com.tongdada.library_main.order.respose.OrderListBean;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 16:59
 * @change
 */
public class OrderListPresenter extends BaseRecyclerRefreshPresenter<OrderListContract.View,OrderBean> implements OrderListContract.Presenter{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void onRefresh(final RequestCallback<OrderBean> callback) {
        MainApiUtils.getMainApi().orderList(CommenUtils.getIncetance().getUserBean().getStationId(), String.valueOf(getFirstPageIndex()),"",type)
                .compose(this.<PagenationBase<OrderListBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<OrderListBean>>() {
                    @Override
                    public void accept(final PagenationBase<OrderListBean> sampleBeanBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(sampleBeanBaseAppEntity.getPagenation().getList());
                            }
                        },2000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFail(throwable.getMessage());
                            }
                        },2000);

                    }
                });
    }

    @Override
    public void onLoadMore(final RequestCallback<OrderBean> callback) {
        MainApiUtils.getMainApi().orderList(CommenUtils.getIncetance().getUserBean().getStationId(), String.valueOf(getCurrentPage()),"",type)
                .compose(this.<PagenationBase<OrderListBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<OrderListBean>>() {
                    @Override
                    public void accept(final PagenationBase<OrderListBean> sampleBeanBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(sampleBeanBaseAppEntity.getPagenation().getList());
                            }
                        },2000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFail(throwable.getMessage());
                            }
                        },2000);

                    }
                });
    }
}
