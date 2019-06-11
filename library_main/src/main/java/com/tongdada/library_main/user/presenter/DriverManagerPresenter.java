package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.DriverBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:16
 * @change
 */
public class DriverManagerPresenter extends BasePresenter<DriverManagerContract.View> implements DriverManagerContract.Presenter {

    @Override
    public void driverList() {
        MainApiUtils.getMainApi().driverList(CommenUtils.getIncetance().getUserBean().getCompanyId())
                .compose(this.<PagenationBase< DriverBean >>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase< DriverBean >>() {
                    @Override
                    public void accept(PagenationBase<DriverBean> requestRegisterBeanBaseAppEntity) throws Exception {
                        getView().setDriverList(requestRegisterBeanBaseAppEntity.getPagenation().getList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void deleteDriver(String id) {
        MainApiUtils.getMainApi().deleteDriver(id)
                .compose(this.<BaseAppEntity<DriverRequest>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<DriverRequest>>() {
                    @Override
                    public void accept(BaseAppEntity<DriverRequest> carOrderBeanPagenationBase) throws Exception {
                        driverList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
