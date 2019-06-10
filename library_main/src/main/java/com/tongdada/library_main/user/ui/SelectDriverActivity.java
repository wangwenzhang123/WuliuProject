package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.adapter.SelectDriverAdapter;
import com.tongdada.library_main.user.presenter.CarManagerContract;
import com.tongdada.library_main.user.presenter.CarManagerPresenter;
import com.tongdada.library_main.user.presenter.DriverManagerContract;
import com.tongdada.library_main.user.presenter.DriverManagerPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/6/7.
 */
@Route(path = ArouterKey.USER_SELECTDRIVER)
public class SelectDriverActivity extends BaseMvpActivity<DriverManagerPresenter> implements DriverManagerContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.add_driver_title)
    TextView addDriverTitle;
    @BindView(R2.id.select_driver_recycler)
    RecyclerView selectDriverRecycler;
    SelectDriverAdapter adapter;
    @Override
    public void initView() {
        adapter=new SelectDriverAdapter(R.layout.item_select_driver,new ArrayList<DriverRequest>());
        selectDriverRecycler.setLayoutManager(new LinearLayoutManager(this));
        selectDriverRecycler.setAdapter(adapter);
        presenter.driverList();
    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                EventBus.getDefault().post(adapter.getData().get(position));
                finish();
            }
        });
    }

    @Override
    public int getView() {
        return R.layout.activity_select_driver;
    }

    @Override
    public DriverManagerPresenter getPresenter() {
        return new DriverManagerPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }

    @Override
    public void setDriverList(List<DriverRequest> list) {
        adapter.setNewData(list);
    }
}
