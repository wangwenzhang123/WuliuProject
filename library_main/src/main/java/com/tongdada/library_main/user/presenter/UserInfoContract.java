package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.UserBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/23.
 */

public class UserInfoContract {
    public interface View extends BaseView{
        void editUserSuccess();
        void selectPic(int  code);
        void uploadSuccess(String path,String url,int dex);
    }
    public interface Presenter{
        void editUser(UserBean userBean);
        void upload(String path,int dex);
    }
}
