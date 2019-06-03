package com.tongdada.library_main.home.presenter;

import android.os.Handler;

import com.example.library_commen.model.CommenUtils;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.example.library_commen.model.TransportCarBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.example.library_commen.model.PagenationBase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 11:35
 * @change
 */
public class TransportCarPresenter extends BaseRecyclerRefreshPresenter<TransportCarContract.View,FinaceBean> implements TransportCarContract.Presenter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean isEnableLoadMore() {
        return true;
    }

    @Override
    public boolean isEnableRefresh() {
        return true;
    }

    @Override
    public void onRefresh(final RequestCallback<FinaceBean> callback) {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getStationId(),type,null, String.valueOf(getFirstPageIndex()),null)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .map(new Function<PagenationBase<CarOrderBean>, List<FinaceBean>>() {
                    @Override
                    public List<FinaceBean> apply(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        List<FinaceBean> list=new ArrayList<>();
                        for (int i = 0; i < carOrderBeanPagenationBase.getPagenation().getList().size(); i++) {
                            List<String> stringList=carOrderBeanPagenationBase.getPagenation().getList().get(i);
                            FinaceBean finaceBean=new FinaceBean(stringList.get(0),
                                    stringList.get(1),
                                    stringList.get(2),
                                    stringList.get(3),
                                    stringList.get(4),
                                    stringList.get(5),
                                    stringList.get(6),
                                    stringList.get(7),
                                    stringList.get(8),
                                    stringList.get(9),
                                    stringList.get(10),
                                    stringList.get(11),
                                    stringList.get(12),
                                    stringList.get(13),
                                    stringList.get(14),
                                    stringList.get(15)
                            );
                            list.add(finaceBean);
                        }
                        return list;
                    }
                }).subscribe(new Consumer<List<FinaceBean>>() {
                    @Override
                    public void accept(final List<FinaceBean> objectBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(objectBaseAppEntity);
                            }
                        },2000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void onLoadMore(final RequestCallback<FinaceBean> callback) {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getStationId(),type,null, String.valueOf(getCurrentPage()),null)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .map(new Function<PagenationBase<CarOrderBean>, List<FinaceBean>>() {
                    @Override
                    public List<FinaceBean> apply(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        List<FinaceBean> list=new ArrayList<>();
                        for (int i = 0; i < carOrderBeanPagenationBase.getPagenation().getList().size(); i++) {
                            List<String> stringList=carOrderBeanPagenationBase.getPagenation().getList().get(i);
                            FinaceBean finaceBean=new FinaceBean(stringList.get(0),
                                    stringList.get(1),
                                    stringList.get(2),
                                    stringList.get(3),
                                    stringList.get(4),
                                    stringList.get(5),
                                    stringList.get(6),
                                    stringList.get(7),
                                    stringList.get(8),
                                    stringList.get(9),
                                    stringList.get(10),
                                    stringList.get(11),
                                    stringList.get(12),
                                    stringList.get(13),
                                    stringList.get(14),
                                    stringList.get(15)
                            );
                            list.add(finaceBean);
                        }
                        return list;
                    }
                }).subscribe(new Consumer<List<FinaceBean>>() {
            @Override
            public void accept(final List<FinaceBean> objectBaseAppEntity) throws Exception {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(objectBaseAppEntity);
                    }
                },2000);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().showToast(throwable.getMessage());
            }
        });
    }
}
