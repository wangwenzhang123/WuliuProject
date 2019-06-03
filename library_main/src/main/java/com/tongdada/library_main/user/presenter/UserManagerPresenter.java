package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApi;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.user.respose.UserListBean;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/24.
 */

public class UserManagerPresenter extends BasePresenter<UserManagerContract.View> implements  UserManagerContract.Presenter {

    @Override
    public void getUserList() {
        MainApiUtils.getMainApi().userList(CommenUtils.getIncetance().getUserBean().getStationId())
                .compose(this.<UserListBean>handleEverythingResult())
                .subscribe(new Consumer<UserListBean>() {
                    @Override
                    public void accept(UserListBean objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity.getPagenation() != null &&objectBaseAppEntity.getPagenation().getList()!= null && objectBaseAppEntity.getPagenation().getList().size() > 0){
                            getView().setUserList(objectBaseAppEntity.getPagenation().getList());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void deleteUser(String id) {
        MainApiUtils.getMainApi().deleteUser(id)
                .compose(this.<UserListBean>handleEverythingResult())
                .subscribe(new Consumer<UserListBean>() {
                    @Override
                    public void accept(UserListBean userListBean) throws Exception {
                        getUserList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

}
