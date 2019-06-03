package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.user.respose.MessageBean;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/24 17:06
 * @change
 */
public class MessagePresenter extends BasePresenter<MessageContract.View> implements MessageContract.Presenter {
    @Override
    public void getMessageList() {
        MainApiUtils.getMainApi().messageList(CommenUtils.getIncetance().getUserBean().getId(),"")
                .compose(this.<MessageBean>handleEverythingResult())
                .subscribe(new Consumer<MessageBean>() {
                    @Override
                    public void accept(MessageBean objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity.getPagenation() != null && objectBaseAppEntity.getPagenation().getList().size() >0){
                            getView().setMessgeList(objectBaseAppEntity.getPagenation().getList());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void readMessage(String id) {
        MainApiUtils.getMainApi().readMessage(id)
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void deleteMessage(String id) {
        MainApiUtils.getMainApi().deleteMessage(id)
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {
                        getMessageList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
