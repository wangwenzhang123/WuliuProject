package com.tongdada.library_login.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/16 16:37
 * @change
 */
public class ForgotContract {
    public interface View extends BaseView{

    }
    public interface Presenter{
        void getForgotPassword(String phone);
    }
}
