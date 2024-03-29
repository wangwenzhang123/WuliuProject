package com.tongdada.library_login.presenter;

import android.text.TextUtils;

import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.event.EventMainFinishBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_login.net.LoginApi;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presnter {
    private LoginApi loginApi;

    public LoginPresenter() {
        loginApi= KRetrofitFactory.createService(LoginApi.class);
    }

    @Override
    public void login(String phone, String password) {
        if (TextUtils.isEmpty(phone)){
            getView().showToast("请输入手机号");
            return;
        }
        if (TextUtils.isEmpty(password)){
            getView().showToast("请输入密码");
            return;
        }
        loginApi.login(phone,password)
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> objectBaseAppEntity) throws Exception {
                        EventBus.getDefault().post(new EventMainFinishBean());
                        CommenUtils.getIncetance().setUserBean(objectBaseAppEntity.getContent());
                        getView().routerIntent(ArouterKey.MAIN_MAINACTIVITY,null);
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
