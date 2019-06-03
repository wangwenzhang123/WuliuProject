package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.MixStationBean;
import com.example.library_commen.model.RequestRegisterBean;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

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
 * Created by wangshen on 2019/5/25.
 */

public class MaintencancePlanPresenter extends BasePresenter<MaintencancePlanContract.View> implements MaintencancePlanContract.Presenter {
    @Override
    public void register(RequestRegisterBean requestRegisterBean) {
        MainApiUtils.getMainApi().updateMixStation(UserMapUtils.getMixingStationsMap(requestRegisterBean))
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> userBeanBaseAppEntity) throws Exception {
                        if (userBeanBaseAppEntity != null && userBeanBaseAppEntity.getContent() != null){
                            getView().showToast("修改成功！");
                            CommenUtils.getIncetance().setRequestRegisterBean(userBeanBaseAppEntity.getContent());
                            getView().updataSuccess();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void upload(final String path, final int dex) {
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
                        MainApiUtils.getMainApi().upload(requestBody)
                                .subscribeOn(Schedulers.io())
                                .compose(MaintencancePlanPresenter.this.<BaseAppEntity<UploadBean>>handleEverythingResult())
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
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getMixStationById() {
        MainApiUtils.getMainApi().getMixStationById(CommenUtils.getIncetance().getUserBean().getStationId())
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity != null && objectBaseAppEntity.getContent() != null){
                            CommenUtils.getIncetance().setRequestRegisterBean(objectBaseAppEntity.getContent());
                            getView().setMixStationData(objectBaseAppEntity.getContent());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
