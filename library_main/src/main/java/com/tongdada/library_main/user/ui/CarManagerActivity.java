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
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.adapter.CarManagerAdapter;
import com.tongdada.library_main.user.presenter.CarManagerContract;
import com.tongdada.library_main.user.presenter.CarManagerPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:21
 * @change
 */
@Route(path = ArouterKey.USER_CARMANAGERACTIVITY)
public class CarManagerActivity extends BaseMvpActivity<CarManagerPresenter> implements CarManagerContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.add_car_tv)
    TextView addCarTv;
    @BindView(R2.id.car_manager_recycle)
    RecyclerView carManagerRecycle;
    private CarManagerAdapter carManagerAdapter;
    @Override
    public int getView() {
        return R.layout.activity_carmanager;
    }

    @Override
    public CarManagerPresenter getPresenter() {
        return new CarManagerPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        carManagerAdapter=new CarManagerAdapter(R.layout.item_car,new ArrayList<String>());
        carManagerRecycle.setLayoutManager(new LinearLayoutManager(this));
        carManagerRecycle.setAdapter(carManagerAdapter);
    }

    @Override
    public void initLinsenterner() {
        carManagerAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view .getId() == R.id.item_slide){

                }
            }
        });
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.add_car_tv)
    public void onAddCarTvClicked() {
        routerIntent(ArouterKey.USER_ADDUSERDETAILACTIVITY,null);
    }
}
