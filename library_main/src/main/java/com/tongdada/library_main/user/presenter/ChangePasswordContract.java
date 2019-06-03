package com.tongdada.library_main.user.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/23.
 */

public class ChangePasswordContract {
    public interface View extends BaseView{
        void editPasswordSueecss();
    }
    public interface Presenter{
        void editPassword(String od);
    }
}
