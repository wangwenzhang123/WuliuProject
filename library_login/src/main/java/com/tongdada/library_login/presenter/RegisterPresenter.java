package com.tongdada.library_login.presenter;

import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_login.net.LoginApi;
import com.example.library_commen.model.UploadBean;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class RegisterPresenter extends BasePresenter<RegisterContact.View> implements RegisterContact.Presnter {
    private LoginApi loginApi;

    public RegisterPresenter() {
        loginApi= KRetrofitFactory.createService(LoginApi.class);
    }

    @Override
    public void registerUser(DriverRequest requestRegisterBean) {
        loginApi.driverRegister(UserMapUtils.getDriverRegisterMap(requestRegisterBean))
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        getView().routerIntent(ArouterKey.LOGIN_SUBMITAUDITACTIVITY,null);
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void registerLogistics(LogisticsRequestBean requestRegisterBean) {
        loginApi.logiUserRegister(UserMapUtils.getLogiUserRegisterMap(requestRegisterBean))
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        getView().routerIntent(ArouterKey.LOGIN_SUBMITAUDITACTIVITY,null);
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void upload(String path,int dex) {
    Observable.create(new ObservableOnSubscribe<RequestBody>() {
        @Override
        public void subscribe(ObservableEmitter<RequestBody> e) throws Exception {
            RequestBody requestBody=new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("uploadFileName","21321.jpg")
                    .addFormDataPart("upload","321321.jpg",RequestBody.create(MediaType.parse("image/*"),new File(path)))
                    .build();
            e.onNext(requestBody);
        }
    }).subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<RequestBody>() {
                @Override
                public void accept(RequestBody requestBody) throws Exception {
                    loginApi.upload(requestBody)
                            .subscribeOn(Schedulers.io())
                            .compose(RegisterPresenter.this.<BaseAppEntity<UploadBean>>handleEverythingResult())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<BaseAppEntity<UploadBean>>() {
                                @Override
                                public void accept(BaseAppEntity<UploadBean> uploadBeanBaseAppEntity) throws Exception {
                                        getView().uploadSuccess(path,uploadBeanBaseAppEntity.getContent().getUrl(),dex);
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    getView().showToast(throwable.getMessage());
                                }
                            });
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {

                }
            });

    }

    @Override
    public void updateLogi(LogisticsRequestBean requestRegisterBean) {
        loginApi.updateLogi(UserMapUtils.getLogiUserRegisterMap(requestRegisterBean))
                .compose(this.<BaseAppEntity<LogisticsRequestBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<LogisticsRequestBean>>() {
                    @Override
                    public void accept(BaseAppEntity<LogisticsRequestBean> userBeanBaseAppEntity) throws Exception {
                        CommenUtils.getIncetance().setRequestBean(userBeanBaseAppEntity.getContent());
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
