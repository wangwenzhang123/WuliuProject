package com.tongdada.library_login.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.example.library_commen.model.RequestRegisterBean;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class RegisterContact {
   public interface Presnter{
      void register(RequestRegisterBean requestRegisterBean);
      void upload(String path,int dex);
   }
   public interface View extends BaseView{
      void selectPic(int  code);
      void uploadSuccess(String path,String url,int dex);
   }
}
