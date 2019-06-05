package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.home.adapter.SelectCarAdapter;
import com.tongdada.library_main.home.presenter.SelectCarContract;
import com.tongdada.library_main.home.presenter.SelectCarPresenter;
import com.tongdada.library_main.home.respose.SelectCarBean;
import com.tongdada.library_main.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/5 14:58
 * @change
 */
@Route(path = ArouterKey.HONE_SELECTCARACTIVITY)
public class SelectCarActivity extends BaseMvpActivity<SelectCarPresenter> implements SelectCarContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.car_recycle)
    RecyclerView carRecycle;
    @BindView(R2.id.select_car_tv)
    TextView selectCarTv;
    @BindView(R2.id.check_all)
    TextView checkAll;
    @BindView(R2.id.settlement_bt)
    Button settlementBt;
    private SelectCarAdapter selectCarAdapter;
    @Override
    public int getView() {
        return R.layout.activity_select_car;
    }

    @Override
    public SelectCarPresenter getPresenter() {
        return new SelectCarPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        List<SelectCarBean> list=new ArrayList<>();
        list.add(new SelectCarBean());
        list.add(new SelectCarBean());
        list.add(new SelectCarBean());
        list.add(new SelectCarBean());
        list.add(new SelectCarBean());
        list.add(new SelectCarBean());
        selectCarAdapter=new SelectCarAdapter(R.layout.item_select_car,list);
        carRecycle.setLayoutManager(new GridLayoutManager(mContext,2));
        carRecycle.setAdapter(selectCarAdapter);
        SpaceItemDecoration spaceItemDecoration=new SpaceItemDecoration(10,20);
        carRecycle.addItemDecoration(spaceItemDecoration);
    }

    @Override
    public void initLinsenterner() {
        selectCarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SelectCarBean finaceBean=selectCarAdapter.getData().get(position);
                if (finaceBean.isCheck()){
                    finaceBean.setCheck(false);
                }else {
                    finaceBean.setCheck(true);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }

    @OnClick(R2.id.check_all)
    public void onCheckAllClicked() {

    }

    @OnClick(R2.id.settlement_bt)
    public void onSettlementBtClicked() {

    }
}
