package com.tongdada.library_main.recruit.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.UserBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.view.empty.StateLayout;
import com.tongdada.library_main.recruit.adapter.ResumeAdapter;
import com.tongdada.library_main.recruit.presenter.ResumeCenterContract;
import com.tongdada.library_main.recruit.presenter.ResumeCenterPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
@SuppressLint("ValidFragment")
public class ResumeCenterFragment extends BaseMvpFragment<ResumeCenterPresenter> implements ResumeCenterContract.View, OnRefreshListener, OnLoadMoreListener {
    @BindView(R2.id.rv_content1)
    RecyclerView rvContent1;
    @BindView(R2.id.srl_layout1)
    SmartRefreshLayout srlLayout1;
    @BindView(R2.id.st_state_layout1)
    StateLayout stStateLayout1;
    Unbinder unbinder;
    private String id="";
    private ResumeAdapter resumeAdapter;
    @SuppressLint("ValidFragment")
    public ResumeCenterFragment(String id) {
        this.id=id;
    }

    public ResumeCenterFragment() {
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_resume;
    }


    @Override
    public ResumeCenterPresenter getPresenter() {
        return new ResumeCenterPresenter();
    }

    @Override
    public void initView() {
        resumeAdapter=new ResumeAdapter(R.layout.item_resume,new ArrayList<UserBean>());
        rvContent1.setLayoutManager(new LinearLayoutManager(mContext));
        rvContent1.setAdapter(resumeAdapter);
        srlLayout1.setOnLoadMoreListener(this);
        srlLayout1.setOnRefreshListener(this);
        srlLayout1.autoRefresh();
        presenter.setPositionId(id);
    }

    @Override
    public void initLinsenterner() {
        resumeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ARouter.getInstance().build(ArouterKey.RECUIT_RESUMEDETAILACTIVITY).withSerializable(IntentKey.USER_DETAIL,resumeAdapter.getData().get(position)).navigation(mContext);
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
        return resumeAdapter;
    }

    @Override
    public SmartRefreshLayout getRefrshView() {
        return srlLayout1;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        presenter.getData();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        presenter.loadMore();
    }
}
