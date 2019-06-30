package com.tongdada.library_main.finance.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.TransportCarBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.finance.adapter.FinaceCompleteAdapter;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.finance.presenter.FinanceContract;
import com.tongdada.library_main.finance.presenter.FinancePresenter;
import com.tongdada.library_main.utils.LoginUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinanceCompleteFragment extends BaseMvpFragment<FinancePresenter> implements FinanceContract.View, OnRefreshListener {
    @BindView(R2.id.finance_complete_recycle)
    RecyclerView financeCompleteRecycle;
    Unbinder unbinder;
    @BindView(R2.id.finace_complete_smart)
    SmartRefreshLayout finaceCompleteSmart;
    private FinaceCompleteAdapter adapter;
    @Override
    public int getViewId() {
        return R.layout.fragment_finance_complete;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        presenter.setType("S");
        financeCompleteRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new FinaceCompleteAdapter(R.layout.item_finace_complete, new ArrayList<FinaceBean>());
        financeCompleteRecycle.setAdapter(adapter);
        finaceCompleteSmart.setEnableLoadMore(false);
        finaceCompleteSmart.setOnRefreshListener(this);
        finaceCompleteSmart.autoRefresh();
    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                if (LoginUtils.isLogin()){
                    ARouter.getInstance().build(ArouterKey.ORDER_LOGICORDERDETAILACTIVITY).withString(IntentKey.ORDER_ID,adapter.getData().get(position).getRowId()).navigation(mContext);
                }else {
                    ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
                }
                //routerIntent(ArouterKey.FINANCE_FINACEORDERACTIVITY,null);
            }
        });
    }

    @Override
    public void getData() {

    }

    @Override
    public FinancePresenter getPresenter() {
        return new FinancePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setOrderList(final List<FinaceBean> list) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setNewData(list);
                finaceCompleteSmart.finishRefresh();
            }
        },1000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        presenter.detailOrderList();
    }
}
