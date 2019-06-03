package com.tongdada.base.ui.mvp.base.refresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.tongdada.base.R;
import com.tongdada.base.R2;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.view.empty.IStateLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * description：列表页面基类
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/30 17:38
 * <p>
 */
public abstract class BaseRecyclerListFragment<V extends BaseRecyclerListContact.View, P extends BaseRecyclerListPresenter<V, Model>, Model> extends BaseMvpFragment<P> implements BaseRecyclerListContact.View {

    @BindView(R2.id.tbl_title)
    TextView tblTitle;
    @BindView(R2.id.rv_content)
    RecyclerView rvContent;
    @BindView(R2.id.ll_root)
    LinearLayout llRoot;
    @BindView(R2.id.ll_title_content)
    RelativeLayout llTitleContent;
    BaseAdapter adapter;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.ll_back)
    LinearLayout llBack;
    @BindView(R2.id.st_state_layout)
    IStateLayout stStateLayout;
    @Override
    public int getViewId() {
        return R.layout.common_activity_recycler_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(rvContent);
        getBackView().setVisibility(View.GONE);
    }

    @Override
    public void setRecyclerAdapter(RecyclerView recyclerView) {
        adapter = createRecyclerAdapter();
        if (adapter == null) {
            return;
        }
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
        rvContent.setAdapter(adapter);
    }

    @Override
    public BaseAdapter getRecyclerAdapter() {
        return adapter;
    }

    @Override
    public void setCustomTitleLayout(View view) {
        if (view == null) {
            return;
        }
        ViewGroup parentView = (ViewGroup) view.getParent();
        if (parentView != null) {
            parentView.removeAllViews();
        }
        tblTitle.setVisibility(View.GONE);
        llTitleContent.addView(view);
    }

    @Override
    public IStateLayout getStateLayout() {
        return stStateLayout;
    }

    @Override
    public void setEnableStateLayout(boolean enabled) {
        stStateLayout.setEnableStateLayout(enabled);
    }

    @Override
    public TextView getTitleBarLayout()
    {
        return tblTitle;
    }
    @Override
    public ImageView getBackImage() {
        return backIv;
    }

    @Override
    public LinearLayout getBackView() {
        return llBack;
    }

    @Override
    public TextView getBackTextView() {
        return backTv;
    }
    @OnClick(R2.id.ll_back)
    public void onViewClicked() {
        finishActivity();
    }
}
