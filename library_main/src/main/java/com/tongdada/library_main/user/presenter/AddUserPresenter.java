package com.tongdada.library_main.user.presenter;

import com.example.library_commen.event.EventAddBean;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import org.greenrobot.eventbus.EventBus;

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
 * Created by wangshen on 2019/5/24.
 */

public class AddUserPresenter extends BasePresenter<AddUserConstract.View> implements AddUserConstract.Presenter {

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
                                .compose(AddUserPresenter.this.<BaseAppEntity<UploadBean>>handleEverythingResult())
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
    public void addStationUser(UserBean userBean) {
        MainApiUtils.getMainApi().addStationUser(UserMapUtils.getUserMap(userBean))
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        getView().showToast("添加成功");
                        EventBus.getDefault().post(new EventAddBean());
                        getView().addStationUserSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

}
