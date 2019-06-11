package com.tongdada.library_main.order.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.OrderBean;
import com.example.library_main.R;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshFragment;
import com.tongdada.library_main.order.adapter.OrderAdapter;
import com.tongdada.library_main.order.presenter.LogicOrderListPresenter;
import com.tongdada.library_main.order.presenter.OrderListContract;
import com.tongdada.library_main.order.presenter.OrderListPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 16:57
 * @change
 */

public class LogicOrderListFragment extends BaseRecyclerRefreshFragment<OrderListContract.View,LogicOrderListPresenter,OrderBean> implements OrderListContract.View {
    private List<OrderBean> orderBeanList=new ArrayList<>();

    public LogicOrderListFragment() {
    }

    @Override
    public void initView() {
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            if (!EventBus.getDefault().isRegistered(this)){
                EventBus.getDefault().register(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getRecyclerAdapter().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString(IntentKey.ORDER_ID,getRecyclerAdapter().getData().get(position).getId());
                routerIntent(ArouterKey.MAP_MAPORDERDETAILACTIVITY,bundle);

            }
        });
    }

    @Override
    public void getData() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventOrder(OrderBean orderBean){
        getRefreshLayout().autoRefresh();
    }
    @Override
    public LogicOrderListPresenter getPresenter() {
        return new LogicOrderListPresenter();
    }
    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new OrderAdapter(R.layout.item_order,orderBeanList);
    }
}
