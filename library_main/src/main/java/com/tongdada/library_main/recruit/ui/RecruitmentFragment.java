package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventJobBean;
import com.example.library_commen.model.RecuritListBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.view.empty.StateLayout;
import com.tongdada.library_main.recruit.adapter.RecruitAdapter;
import com.tongdada.library_main.recruit.presenter.RecruitmentContract;
import com.tongdada.library_main.recruit.presenter.RecruitmentPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecruitmentFragment extends BaseMvpFragment<RecruitmentPresenter> implements RecruitmentContract.View, OnLoadMoreListener, OnRefreshListener {


    @BindView(R2.id.rv_content1)
    RecyclerView rvContent;
    @BindView(R2.id.srl_layout1)
    SmartRefreshLayout srlLayout;
    @BindView(R2.id.st_state_layout1)
    StateLayout stStateLayout;
    Unbinder unbinder;
    RecruitAdapter adapter;
    @Override
    public int getViewId() {
        return R.layout.fragment_recuritment;
    }

    @Override
    public RecruitmentPresenter getPresenter() {
        return new RecruitmentPresenter();
    }

    @Override
    public void initView() {
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new RecruitAdapter(R.layout.item_recruit,new ArrayList<RecuritListBean>());
        rvContent.setAdapter(adapter);
        srlLayout.setOnLoadMoreListener(this);
        srlLayout.setEnableLoadMore(true);
        srlLayout.setOnRefreshListener(this);
        srlLayout.autoRefresh();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void event(EventJobBean eventJobBean){
        srlLayout.autoRefresh();
    }
    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                ARouter.getInstance().build(ArouterKey.RECRUIT_PUBLISHJOBACTIVITY).withSerializable(IntentKey.RECUIRT_BEAN,adapter.getData().get(position)).navigation(mContext);
            }
        });
    }

    @Override
    public void getData() {

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
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getRefrshView() {
        return srlLayout;
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        presenter.getData(false);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        presenter.getData(true);
    }
}
