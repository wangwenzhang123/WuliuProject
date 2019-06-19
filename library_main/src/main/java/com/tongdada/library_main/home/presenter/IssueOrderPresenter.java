package com.tongdada.library_main.home.presenter;

import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.example.library_commen.model.IssueOrderBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.user.presenter.AddUserPresenter;

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
 * Created by wangshen on 2019/5/18.
 */

public class IssueOrderPresenter extends BasePresenter<IssueOrderContract.View> implements IssueOrderContract.Presenter {

    @Override
    public void publishOrder(OrderBean issueOrderBean) {
        MainApiUtils.getMainApi().publishOrder(UserMapUtils.getOrderMap(issueOrderBean)/*issueOrderBean.getStationId(),issueOrderBean.getOrderAmount(),issueOrderBean.getStartPlace(),issueOrderBean.getDestinationPlace(),issueOrderBean.getStartLongitude(),
                issueOrderBean.getStartLatitude(),issueOrderBean.getDstLongitude(),issueOrderBean.getDstLatitude(),issueOrderBean.getTotalDistance(),issueOrderBean.getPerPrice(),issueOrderBean.getOrderStatus(),issueOrderBean.getOrderName(),
                issueOrderBean.getCarType(),issueOrderBean.getOrderRemark(),issueOrderBean.getPublishTime(),issueOrderBean.getOrderPic()*/)
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {
                        getView().showToast("发布成功！");
                        getView().publishSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });

    }

    @Override
    public void upload(final String path) {
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
                                .compose(IssueOrderPresenter.this.<BaseAppEntity<UploadBean>>handleEverythingResult())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<BaseAppEntity<UploadBean>>() {
                                    @Override
                                    public void accept(BaseAppEntity<UploadBean> uploadBeanBaseAppEntity) throws Exception {
                                        getView().uploadSuccess(path,uploadBeanBaseAppEntity.getContent().getUrl());
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
    public void editOrder(OrderBean issueOrderBean) {
        MainApiUtils.getMainApi().editOrder(UserMapUtils.getOrderMap(issueOrderBean))
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {
                        getView().publishSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
