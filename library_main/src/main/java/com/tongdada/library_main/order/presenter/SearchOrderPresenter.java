package com.tongdada.library_main.order.presenter;

import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.model.PagenationBase;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.order.respose.OrderListBean;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/6/2.
 */

public class SearchOrderPresenter extends BasePresenter<SearchOrderContract.View> implements SearchOrderContract.Presenter {
    @Override
    public void getSearchOrder(String resul) {
        MainApiUtils.getMainApi().orderList(CommenUtils.getIncetance().getUserBean().getStationId(),CommenUtils.getIncetance().getUserBean().getCompanyId(), "0", resul, "","")
                .compose(this.<PagenationBase<OrderListBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<OrderListBean>>() {
                    @Override
                    public void accept(final PagenationBase<OrderListBean> sampleBeanBaseAppEntity) throws Exception {
                        if (sampleBeanBaseAppEntity.getPagenation().getList() == null || sampleBeanBaseAppEntity.getPagenation().getList().size() == 0){
                            getView().showToast("未搜索到相关内容！");
                        }else {
                            getView().setSearchOrderList(sampleBeanBaseAppEntity.getPagenation().getList());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
