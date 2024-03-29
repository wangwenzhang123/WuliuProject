package com.tongdada.library_main.finance.presenter;

import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.model.PagenationBase;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by wangshen on 2019/6/2.
 */

public class SearchFiancePresenter extends BasePresenter<SearchFinaceContract.View> implements SearchFinaceContract.Presenter {


    @Override
    public void findDetailList(String result) {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getCompanyId(),"",result,"1",null,CommenUtils.getIncetance().getUserBean().getDriverId())
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
                                    stringList.get(15),
                                    stringList.get(16)
                            );
                            list.add(finaceBean);
                        }
                        return list;
                    }
                })
                .subscribe(new Consumer<List<FinaceBean>>() {
                    @Override
                    public void accept(List<FinaceBean> carOrderBeanPagenationBase) throws Exception {
                        getView().setDataList(carOrderBeanPagenationBase);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
