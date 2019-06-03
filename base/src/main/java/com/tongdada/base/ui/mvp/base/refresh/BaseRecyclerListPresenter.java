package com.tongdada.base.ui.mvp.base.refresh;

import android.view.View;


import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;

import java.util.List;

/**
 * description：列表Presenter基类
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/30 18:06
 * <p>
 */
public abstract class BaseRecyclerListPresenter<V extends BaseRecyclerListContact.View,Model> extends BasePresenter<V> implements BaseRecyclerListContact.Presenter<Model>, View.OnClickListener {
    private RequestCallback<Model> callback;
    public BaseRecyclerListPresenter() {
        callback=new Callback();
    }
    public RequestCallback<Model> getCallback(){
        if (callback != null){
            return callback;
        }else {
            return new Callback();
        }
    }
    @Override
    public boolean isEnableStateLayout() {
        return true;
    }

    class Callback implements RequestCallback<Model> {

        @Override
        public void onStart() {
        }

        @Override
        public void onSuccess(List<Model> dataSources) {
            if (!isViewAttached()) {
                return;
            }
            BaseAdapter rvAdapter = getView().getRecyclerAdapter();
            if (dataSources != null) {
                rvAdapter.setNewData(dataSources);
                rvAdapter.notifyDataSetChanged();
                int adapterItemCount = rvAdapter.getItemCount();
                if (adapterItemCount == 0) {
                    showEmptyView();
                } else {
                    getView().getStateLayout().hideStateView();
                }
            }
        }

        @Override
        public void onFail(String message) {
            if (!isViewAttached()) {
                return;
            }
            getView().showMessage(message);
            getView().getStateLayout().showErrorView();
        }
    }

    public void showEmptyView() {
        //
        getView().getStateLayout().showEmptyView();
    }

    @Override
    public void onClick(View v) {

    }
}
