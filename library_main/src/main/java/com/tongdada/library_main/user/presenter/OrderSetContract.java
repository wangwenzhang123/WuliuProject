package com.tongdada.library_main.user.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/24.
 */

public class OrderSetContract {
    public interface View extends BaseView{
        void sysSetSuccess();
    }
    public interface Presenter{
        void sysSet(String tong,String beng);
    }
}
