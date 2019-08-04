package com.tongdada.library_main.order.presenter;

import android.os.Handler;

import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.order.respose.OrderListBean;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 16:59
 * @change
 */
public class TenOrderListPresenter extends BaseRecyclerRefreshPresenter<OrderListContract.View,OrderBean> implements OrderListContract.Presenter{

    @Override
    public void onRefresh(final RequestCallback<OrderBean> callback) {
        MainApiUtils.getMainApi().orderListOfRange(CommenUtils.getIncetance().getUserBean().getStationId(),CommenUtils.getIncetance().getUserBean().getCompanyId(), String.valueOf(getFirstPageIndex()),"",
                "F","",CommenUtils.latitude,CommenUtils.longitude)
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
        MainApiUtils.getMainApi().orderListOfRange(CommenUtils.getIncetance().getUserBean().getStationId(),CommenUtils.getIncetance().getUserBean().getCompanyId(), String.valueOf(getCurrentPage()),
                "","F","",CommenUtils.latitude,CommenUtils.longitude)
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
