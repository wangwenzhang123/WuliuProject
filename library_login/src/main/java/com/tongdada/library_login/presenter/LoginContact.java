package com.tongdada.library_login.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class LoginContact {
   public interface Presnter{
      void login(String phone,String password);
   }
   public interface View extends BaseView{

   }
}
