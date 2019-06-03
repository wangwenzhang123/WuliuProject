package com.tongdada.library_main.user.ui;

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
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.home.presenter.HomeContract;
import com.tongdada.library_main.home.presenter.HomePresenter;
import com.tongdada.library_main.home.request.MessageIntentBean;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.user.adapter.InformationAdapter;
import com.tongdada.library_main.user.respose.InformationBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/20.
 */

public class InformationFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.View {
    @BindView(R2.id.information_recycle)
    RecyclerView informationRecycle;
    Unbinder unbinder;
    private List<BannerBean.RowsBean> informationBeanList=new ArrayList<>();
    private InformationAdapter adapter;
    @Override
    public int getViewId() {
        return R.layout.fragment_information;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        informationRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new InformationAdapter(R.layout.item_information,informationBeanList);
        informationRecycle.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                BannerBean.RowsBean rowsBean=adapter.getData().get(position);
                MessageIntentBean messageIntentBean=new MessageIntentBean(rowsBean.getNewsTitle(),rowsBean.getPriviewPic(),rowsBean.getNewsContent(),String.valueOf(rowsBean.getCreateTime().getTime()));
                ARouter.getInstance().build(ArouterKey.MESSAGE_MESSAGEDETAILACTIVITY).withSerializable(IntentKey.MESSAGE_BEAN,messageIntentBean)
                        .navigation(mContext);
            }
        });
    }

    @Override
    public void getData() {

    }


    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
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
    public void setBannerData(List<BannerBean.RowsBean> bannerData) {
        adapter.setNewData(bannerData);
    }
}
