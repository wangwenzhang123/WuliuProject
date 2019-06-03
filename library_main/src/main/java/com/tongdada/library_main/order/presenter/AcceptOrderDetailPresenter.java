package com.tongdada.library_main.order.presenter;

import com.example.library_commen.model.CommenUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.example.library_commen.model.PagenationBase;

import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 17:30
 * @change
 */
public class AcceptOrderDetailPresenter extends BasePresenter<AcceptOrderDetailContract.View> implements AcceptOrderDetailContract.Presenter {

    @Override
    public void detailOrderList(String id) {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getStationId(),"",null,"1", id)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .map(new Function<PagenationBase<CarOrderBean>, List<FinaceBean>>() {
                    @Override
                    public List<FinaceBean> apply(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        List<FinaceBean> list=new ArrayList<>();
                        for (int i = 0; i < carOrderBeanPagenationBase.getPagenation().getList().size(); i++) {
                            try {
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
                            } catch (Exception e) {
                                e.printStackTrace();
                                continue;
                            }
                        }
                        return list;
                    }
                })
                .subscribe(new Consumer<List<FinaceBean>>() {
                    @Override
                    public void accept(List<FinaceBean> carOrderBeanPagenationBase) throws Exception {
                        getView().setOrderList(carOrderBeanPagenationBase);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
