package com.tongdada.library_main.user.presenter;

import com.example.library_commen.event.EventAddBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.model.RequestRegisterBean;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:16
 * @change
 */
public class AddDriverPresenter extends BasePresenter<AddDriverContract.View> implements AddDriverContract.Presenter {

    @Override
    public void addDriver(DriverRequest request) {
        MainApiUtils.getMainApi().addDriver(UserMapUtils.getDriverRegisterMap(request))
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> requestRegisterBeanBaseAppEntity) throws Exception {
                        EventBus.getDefault().post(new EventAddBean());
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }


}
