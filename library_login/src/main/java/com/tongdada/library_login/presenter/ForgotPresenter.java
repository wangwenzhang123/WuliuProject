package com.tongdada.library_login.presenter;

import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_login.net.LoginApi;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/16 16:38
 * @change
 */
public class ForgotPresenter extends BasePresenter<ForgotContract.View> implements ForgotContract.Presenter {
    private LoginApi loginApi;

    public ForgotPresenter() {
        loginApi= KRetrofitFactory.createService(LoginApi.class);
    }
    @Override
    public void getForgotPassword(String phone) {
        loginApi.forgetPassword(phone)
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        getView().routerIntent(ArouterKey.LOGIN_LOGINACTIVITY,null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
