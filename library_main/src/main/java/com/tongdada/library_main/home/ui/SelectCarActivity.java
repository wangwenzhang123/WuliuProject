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
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.SelectCarBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.home.adapter.SelectCarAdapter;
import com.tongdada.library_main.user.presenter.CarManagerContract;
import com.tongdada.library_main.user.presenter.CarManagerPresenter;
import com.tongdada.library_main.widget.SpaceItemDecoration;

import org.greenrobot.eventbus.EventBus;

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
public class SelectCarActivity extends BaseMvpActivity<CarManagerPresenter> implements CarManagerContract.View {
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
    @BindView(R2.id.amount_tv)
    TextView amountTv;
    private SelectCarAdapter selectCarAdapter;
    private String total,accept="0";
    @Override
    public int getView() {
        return R.layout.activity_select_car;
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
        List<CarRequestBean> list = new ArrayList<>();
        selectCarAdapter = new SelectCarAdapter(R.layout.item_select_car, list);
        carRecycle.setLayoutManager(new GridLayoutManager(mContext, 2));
        carRecycle.setAdapter(selectCarAdapter);
        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(10, 20);
        carRecycle.addItemDecoration(spaceItemDecoration);
        presenter.getCarList();

    }

    @Override
    public void getData() {
        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        total=bundle.getString(IntentKey.ORDER_AMOUNT);
    }

    private void updateUi(){
        int amuont=0;
        for (int i = 0; i < selectCarAdapter.getData().size(); i++) {
            CarRequestBean carRequestBean=selectCarAdapter.getData().get(i);
            if (carRequestBean.isCheck()){
                amuont= Integer.parseInt(carRequestBean.getCarLoad())+amuont;
            }
        }
        amountTv.setText("剩余"+total+"，当前可以运输总量"+amuont+"方");
    }
    @Override
    public void initLinsenterner() {
        selectCarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarRequestBean finaceBean = selectCarAdapter.getData().get(position);
                if (finaceBean.isCheck()) {
                    finaceBean.setCheck(false);
                } else {
                    finaceBean.setCheck(true);
                }
                adapter.notifyDataSetChanged();
                updateUi();
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

    private boolean isCheckAll = false;

    @OnClick(R2.id.check_all)
    public void onCheckAllClicked() {
        for (int i = 0; i < selectCarAdapter.getData().size(); i++) {
            if (!isCheckAll) {
                selectCarAdapter.getData().get(i).setCheck(true);
            } else {
                selectCarAdapter.getData().get(i).setCheck(false);
            }
        }
        if (isCheckAll) {
            isCheckAll = false;
        } else {
            isCheckAll = true;
        }
        selectCarAdapter.notifyDataSetChanged();
        updateUi();
    }

    @OnClick(R2.id.settlement_bt)
    public void onSettlementBtClicked() {
        List<SelectCarBean> list = new ArrayList<>();
        for (int i = 0; i < selectCarAdapter.getData().size(); i++) {
            CarRequestBean requestBean = selectCarAdapter.getData().get(i);
            if (requestBean.isCheck()) {
                list.add(new SelectCarBean(requestBean.getId(), requestBean.getCarNo()));
            }
        }
        EventBus.getDefault().post(list);
        finish();
    }

    @Override
    public void setCarList(List<CarRequestBean> list) {
        selectCarAdapter.setNewData(list);
        updateUi();
    }
}
