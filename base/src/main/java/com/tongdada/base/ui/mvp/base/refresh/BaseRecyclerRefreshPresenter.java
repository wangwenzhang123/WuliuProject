package com.tongdada.base.ui.mvp.base.refresh;

import android.view.View;


import com.scwang.smartrefresh.layout.api.RefreshLayout;
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
public abstract class BaseRecyclerRefreshPresenter<V extends BaseRecyclerRefreshContact.View, Model> extends BasePresenter<V> implements BaseRecyclerRefreshContact.Presenter<Model>, View.OnClickListener {
    private int mCurrentPage;

    @Override
    public void init() {
        getView().setEnableLoadMore(isEnableLoadMore());
        getView().setEnableRefresh(isEnableRefresh());
        getView().setEnableStateLayout(isEnableStateLayout());
        getView().getStateLayout().showErrorViewButton(this);
        if (isSelfMotionRefresh()){
            getView().getRefreshLayout().autoRefresh();
        }
    }


    @Override
    public boolean isEnableLoadMore() {
        return true;
    }

    @Override
    public boolean isSelfMotionRefresh() {
        return true;
    }

    @Override
    public boolean isEnableRefresh() {
        return true;
    }

    @Override
    public boolean isEnableStateLayout() {
        return true;
    }

    @Override
    public int getFirstPageIndex() {
        return 1;
    }

    public int getCurrentPage() {
        return mCurrentPage;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        onLoadData(refreshLayout, true, false);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        onLoadData(refreshLayout, false, false);
    }

    class Callback implements RequestCallback<Model> {
        private RefreshLayout refreshLayout;
        private boolean isRefresh;
        private boolean isFirstLoad;

        Callback(boolean isRefresh) {
            this.isRefresh = isRefresh;
        }

        Callback(boolean isRefresh, boolean isFirstLoad) {
            this.isRefresh = isRefresh;
            this.isFirstLoad = isFirstLoad;
        }

        public Callback(RefreshLayout refreshLayout, boolean isRefresh, boolean isFirstLoad) {
            this.refreshLayout = refreshLayout;
            this.isRefresh = isRefresh;
            this.isFirstLoad = isFirstLoad;
        }

        @Override
        public void onStart() {
        }

        @Override
        public void onSuccess(List<Model> dataSources) {
            if (!isViewAttached()) {
                return;
            }
            isFirstLoad = false;
            BaseAdapter rvAdapter = getView().getRecyclerAdapter();
                if (isRefresh) {
                    rvAdapter.setNewData(dataSources);
                    refreshLayout.finishRefresh();
                } else {
                    rvAdapter.addData(dataSources);
                    refreshLayout.finishLoadMore();
                }
                boolean isEmptyResult = dataSources == null || dataSources.size() == 0;
                if (isEmptyResult && mCurrentPage > getFirstPageIndex()) {
                    mCurrentPage--;
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }
                int adapterItemCount = rvAdapter.getItemCount();
                if (adapterItemCount == 0) {
                    showEmptyView();
                } else {
                    getView().getStateLayout().hideStateView();
                }
        }

        @Override
        public void onFail(String message) {
            if (!isViewAttached()) {
                return;
            }
            isFirstLoad = false;
            getView().showMessage(message);
            if (isRefresh) {
                refreshLayout.finishRefresh();
            } else {
                refreshLayout.finishLoadMore();
            }
            if (mCurrentPage > getFirstPageIndex()) {
                mCurrentPage--;
            }
            getView().getStateLayout().showErrorView();
        }
    }

    public void showEmptyView() {
        getView().getStateLayout().showEmptyView();
    }

    @Override
    public void onClick(View v) {
        if (isViewAttached()) {
            onLoadData(getView().getRefreshLayout(), true, true);
        }
    }


    private void onLoadData(RefreshLayout refreshLayout, boolean isRefresh, boolean isFirstLoad) {
        if (!isViewAttached()) {
            return;
        }
        if (isRefresh && isFirstLoad) {
            //getView().getStateLayout().showLoadingView();
        }
        Callback callback = new Callback(refreshLayout, isRefresh, isFirstLoad);
        if (isRefresh) {
            mCurrentPage = getFirstPageIndex();
            refreshLayout.setNoMoreData(false);
            onRefresh(callback);
        } else {
            mCurrentPage++;
            onLoadMore(callback);
        }

    }
}
