package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventSelectCarBean;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.SelectCarBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.weight.SpaceItemDecoration;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.home.adapter.SelectCarAdapter;
import com.tongdada.library_main.user.presenter.CarManagerContract;
import com.tongdada.library_main.user.presenter.CarManagerPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    @BindView(R2.id.add_car)
    TextView addCar;
    private SelectCarAdapter selectCarAdapter;
    private int total, accept, acceptCar;
    private int accpetTotal;
    private boolean isSelect = true;
    private String carType;

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
        EventBus.getDefault().register(this);
    }

    @Override
    public void initView() {
        List<CarRequestBean> list = new ArrayList<>();
        selectCarAdapter = new SelectCarAdapter(R.layout.item_select_car, list);
        carRecycle.setLayoutManager(new GridLayoutManager(mContext, 2));
        carRecycle.setAdapter(selectCarAdapter);
        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(10, 20);
        carRecycle.addItemDecoration(spaceItemDecoration);

        if (CommenUtils.LOGIN_TYPE != 0) {
            checkAll.setVisibility(View.GONE);
        }
    }

    @Override
    public void getData() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        total = Integer.parseInt(bundle.getString(IntentKey.ORDER_AMOUNT));
        accpetTotal = total;
        carType = bundle.getString(IntentKey.CAR_TYPE);
        if (TextUtils.isEmpty(carType)){
            return;
        }
        if (carType.contains("B")) {
            checkAll.setVisibility(View.GONE);
            selectCarTv.setText("可选泵车");
        }
        presenter.getCarList(true, carType);
    }

    private void updateUi() {
        if (carType.equals("B")) {
            boolean is = false;
            for (int i = 0; i < selectCarAdapter.getData().size(); i++) {
                CarRequestBean carRequestBean = selectCarAdapter.getData().get(i);
                if (carRequestBean.isCheck()) {
                    accept = Integer.parseInt(carRequestBean.getCarLoad());
                    is = true;
                } else {
                    accept = 0;
                }
            }
            if (is) {
                amountTv.setText("剩余" + 0 + "方");
            } else {
                amountTv.setText("剩余" + total + "方");
            }
            if (total == 0) {
                isSelect = false;
            } else {
                isSelect = true;
            }
        } else {
            int amuont = 0;
            accept = 0;
            acceptCar = 0;
            for (int i = 0; i < selectCarAdapter.getData().size(); i++) {
                CarRequestBean carRequestBean = selectCarAdapter.getData().get(i);
                if (!carRequestBean.isCheck()) {
                    amuont = Integer.parseInt(carRequestBean.getCarLoad()) + amuont;
                } else {
                    acceptCar += Integer.parseInt(carRequestBean.getCarLoad());
                }
            }
            if (isCheckAll) {
                amountTv.setText("剩余" + (total - accept) + "方，当前可以运输总量" + 0 + "方");
            } else {
                if (total == 0) {
                    isSelect = false;
                } else {
                    isSelect = true;
                }
                amountTv.setText("剩余" + (total - accept) + "方，当前可以运输总量" + acceptCar + "方");
                if (total < accept) {
                    checkAll.setFocusable(false);
                    checkAll.setClickable(false);
                } else {
                    checkAll.setFocusable(true);
                    checkAll.setClickable(true);
                }
            }
        }
    }

    @Override
    public void initLinsenterner() {
        selectCarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isSelect) {
                    try {
                        if (CommenUtils.LOGIN_TYPE != 0) {
                            for (int i = 0; i < selectCarAdapter.getData().size(); i++) {
                                CarRequestBean finaceBean = selectCarAdapter.getData().get(i);
                                if (i != position) {
                                    if (finaceBean.isCheck()) {
                                        total = total + Integer.parseInt(finaceBean.getCarLoad());
                                        finaceBean.setCheck(false);
                                    }
                                }
                            }
                        }
                        CarRequestBean finaceBean = selectCarAdapter.getData().get(position);
                        if (finaceBean.isCheck()) {
                            finaceBean.setCheck(false);
                            isCheckAll = false;
                            total = total + Integer.parseInt(finaceBean.getCarLoad());
                        } else {
                            finaceBean.setCheck(true);
                            total = total - Integer.parseInt(finaceBean.getCarLoad());
                            if (total <= 0) {
                                total = 0;
                            }
                        }
                        adapter.notifyDataSetChanged();
                        updateUi();
                    }catch (Exception e){
                        e.printStackTrace();
                        ToastUtils.showToast(mContext,"车辆信息不完善");
                    }
                } else {
                    try {
                        CarRequestBean finaceBean = selectCarAdapter.getData().get(position);
                        if (finaceBean.isCheck()) {
                            finaceBean.setCheck(false);
                            isCheckAll = false;
                            total = total + Integer.parseInt(finaceBean.getCarLoad());
                            adapter.notifyDataSetChanged();
                            updateUi();
                        } else {
                            showToast("装货量已满！");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        ToastUtils.showToast(mContext,"车辆信息不完善");
                    }

                }

            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getList(EventSelectCarBean eventSelectCarBean){
        presenter.getCarList(true, carType);
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
            total = accpetTotal;
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
                if (accpetTotal - Integer.parseInt(requestBean.getCarLoad()) > 0) {
                    list.add(new SelectCarBean(requestBean.getId(), requestBean.getCarNo(), requestBean.getCarLoad()));
                    accpetTotal = accpetTotal - Integer.parseInt(requestBean.getCarLoad());
                } else {
                    list.add(new SelectCarBean(requestBean.getId(), requestBean.getCarNo(), accpetTotal + ""));
                }
            }
        }
        EventBus.getDefault().post(list);
        finish();
    }

    @Override
    public void setCarList(List<CarRequestBean> list) {
        if (list.size() == 0){
            if (CommenUtils.LOGIN_TYPE == 0){
                addCar.setVisibility(View.VISIBLE);
            }
        }else {
            addCar.setVisibility(View.GONE);
        }
        for (int i = 0; i < list.size(); i++) {
            CarRequestBean requestBean = list.get(i);
            if (requestBean.getCarType().contains("B")) {
                requestBean.setCarLoad(accpetTotal + "");
            }
        }
        selectCarAdapter.setNewData(list);
        updateUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R2.id.add_car)
    public void onViewClicked() {
        routerIntent(ArouterKey.USER_ADDCARACTIVITY,null);
    }
}
