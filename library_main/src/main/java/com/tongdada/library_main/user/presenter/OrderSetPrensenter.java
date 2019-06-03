package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/24.
 */

public class OrderSetPrensenter extends BasePresenter<OrderSetContract.View> implements OrderSetContract.Presenter{

    @Override
    public void sysSet(String tong, String beng) {
        MainApiUtils.getMainApi().sysSet(CommenUtils.getIncetance().getUserBean().getStationId(),tong,beng)
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {
                        getView().sysSetSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
