package com.tongdada.library_login.presenter;

import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.model.LogisticsRequestBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class RegisterContact {
   public interface Presnter{
      void registerUser(DriverRequest requestRegisterBean);
      void registerLogistics(LogisticsRequestBean requestRegisterBean);
      void upload(String path,int dex);
      void updateLogi(LogisticsRequestBean requestRegisterBean);
   }
   public interface View extends BaseView{
      void selectPic(int  code);
      void uploadSuccess(String path,String url,int dex);
      void updateUi();
   }
}
