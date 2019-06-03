package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.UserBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/24.
 */

public class AddUserConstract {
    public interface View extends BaseView{
        void selectPic(int  code);
        void uploadSuccess(String path,String url,int dex);
        void addStationUserSuccess();
    }
    public interface Presenter{
        void upload(String path,int dex);
        void addStationUser(UserBean userBean);
    }
}
