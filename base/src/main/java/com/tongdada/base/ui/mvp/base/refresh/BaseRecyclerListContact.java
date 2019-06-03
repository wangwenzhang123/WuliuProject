package com.tongdada.base.ui.mvp.base.refresh;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
public interface BaseRecyclerListContact {

    interface Presenter<Model> {
       /* *//**
         * 获取数据
         *
         * @param callback 结果回调
         *//*
        void requestData(RequestCallback<Model> callback);*/
        /**
         * 是否启用状态View
         *
         * @return true 启用
         */
        boolean isEnableStateLayout();

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
         * 获取状态控件
         *
         * @return StateLayout 控件
         */
        IStateLayout getStateLayout();

        /**
         * 进入界面第一次加载数据
         */
        void loadData();
        /**
         * 获取标题栏
         *
         * @return TitleBarLayout
         */
        TextView getTitleBarLayout();

        /**
         * 设置自定义标题栏
         *
         * @param view 自定义标题栏
         */
        void setCustomTitleLayout(android.view.View view);

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
