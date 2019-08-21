package com.example.library_amap.presenter;

import android.text.TextUtils;

import com.example.library_commen.event.EventSuccessBean;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.TransportCarBean;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;

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
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 10:57
 * @change
 */
public class MapCarDetailPresenter extends BasePresenter<MapCarDetailContract.View> implements MapCarDetailContract.Presenter {
    private CommenApi commenApi;

    public MapCarDetailPresenter() {
        commenApi= KRetrofitFactory.createService(CommenApi.class);
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
                        commenApi.upload(requestBody)
                                .subscribeOn(Schedulers.io())
                                .compose(MapCarDetailPresenter.this.<BaseAppEntity<UploadBean>>handleEverythingResult())
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
    public void getDetailOrderById(String orderid) {
        commenApi.getDetailOrderById(orderid)
                .compose(this.<BaseAppEntity<DriverOrderDetailBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<DriverOrderDetailBean>>() {
                    @Override
                    public void accept(BaseAppEntity<DriverOrderDetailBean> userBeanBaseAppEntity) throws Exception {
                        getView().setDetailOrder(userBeanBaseAppEntity.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void updateDetailOrders(String id, String state) {
        commenApi.batchUpdateDetailOrders(id,state)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> driverOrderDetailBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
    @Override
    public void batchUpdateDetailOrders(String id, String state) {
        commenApi.batchUpdateDetailOrders(id,state)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void loadOrder(String orderid, String path) {
        if (TextUtils.isEmpty(path)){
            getView().showToast("请先上传装货凭据！");
            return;
        }
        commenApi.loadOrder(orderid,path)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void unloadOrder(String orderid, String path,String laoding) {
        if (TextUtils.isEmpty(path)){
            getView().showToast("请先上传卸货凭据！");
            return;
        }
        commenApi.unloadOrder(orderid,path,laoding)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void cancel(String id) {
        commenApi.cancelDetailOrder(id)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().updateSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
