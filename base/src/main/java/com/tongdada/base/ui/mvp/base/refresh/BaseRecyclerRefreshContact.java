package com.tongdada.base.ui.mvp.base.refresh;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.base.view.empty.IStateLayout;

/**
 * description：列表契约接口类
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/30 17:38
 * <p>
 */
public interface BaseRecyclerRefreshContact {

    interface Presenter<Model> {
        /**
         * 初始化设置
         */
        void init();
        /**
         * 是否启用加载更多
         *
         * @return true 启用
         */
        boolean isEnableLoadMore();

        /**
         * 是否启用下拉刷新
         *
         * @return true 启用
         */
        boolean isEnableRefresh();

        /**
         * 是否启用状态View
         *
         * @return true 启用
         */
        boolean isEnableStateLayout();

        /**
         * 是否首次进去自动加载
         * @return true启用
         */
        boolean isSelfMotionRefresh();
        /**
         * 分页数据起始页码
         *
         * @return index
         */
        int getFirstPageIndex();

        /**
         * 下拉刷新
         *
         * @param refreshLayout 刷新控件
         */
        void onRefresh(RefreshLayout refreshLayout);

        /**
         * 加载更多
         *
         * @param refreshLayout 刷新控件
         */
        void onLoadMore(RefreshLayout refreshLayout);

        /**
         * 刷新数据
         *
         * @param callback 结果回调
         */
        void onRefresh(RequestCallback<Model> callback);

        /**
         * 加载更多
         *
         * @param callback 结果回调
         */
        void onLoadMore(RequestCallback<Model> callback);
    }

    interface View extends BaseView {
        /**
         * 获取返回按钮的图片
         * @return
         */
        ImageView getBackImage();

        /**
         * 获取返回按钮的文字
         * @return
         */
        TextView getBackTextView();

        /**
         * 获取返回按钮
         * @return
         */
        LinearLayout getBackView();
        /**
         * 获取下拉刷新控件
         *
         * @return SmartRefreshLayout 控件
         */
        RefreshLayout getRefreshLayout();

        /**
         * 获取标题栏
         *
         * @return TitleBarLayout
         */
        TextView getTitleBarLayout();
        /**
         * 获取状态控件
         *
         * @return StateLayout 控件
         */
        IStateLayout getStateLayout();
        /**
         * 设置自定义标题栏
         *
         * @param view 自定义标题栏
         */
        void setCustomTitleLayout(android.view.View view);

        /**
         * 设置是否启用上拉加载更多（默认启用）
         *
         * @param enabled 是否启用
         */
        void setEnableLoadMore(boolean enabled);

        /**
         * 是否启用下拉刷新（默认启用）
         *
         * @param enabled 是否启用
         */
        void setEnableRefresh(boolean enabled);

        /**
         * 是否启用状态View
         *
         * @param enabled 是否启用
         */
        void setEnableStateLayout(boolean enabled);

        /**
         * 设置Adapter
         *
         * @param recyclerView 列表控件
         */
        void setRecyclerAdapter(RecyclerView recyclerView);

        /**
         * 创建适配器
         *
         * @return 适配器
         */
        BaseAdapter createRecyclerAdapter();

        /**
         * 当前的adapter
         *
         * @return adapter
         */
        BaseAdapter getRecyclerAdapter();
    }
}
