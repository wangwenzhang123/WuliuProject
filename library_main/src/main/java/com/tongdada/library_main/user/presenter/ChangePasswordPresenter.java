package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApi;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/23.
 */

public class ChangePasswordPresenter extends BasePresenter<ChangePasswordContract.View> implements ChangePasswordContract.Presenter {
    @Override
    public void editPassword(String od) {
        MainApiUtils.getMainApi().editPassword(CommenUtils.getIncetance().getUserBean().getId(),CommenUtils.getIncetance().getUserBean().getUserPassword(),od)
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> objectBaseAppEntity) throws Exception {

                        CommenUtils.getIncetance().setUserBean(objectBaseAppEntity.getContent());
                        getView().showToast("修改密码成功");
                        getView().editPasswordSueecss();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
