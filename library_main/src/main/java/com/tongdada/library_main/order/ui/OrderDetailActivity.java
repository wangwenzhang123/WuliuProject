package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.adapter.OrderDetailCarAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.CarBean;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.DetailCarListBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.presenter.OrderDetailContract;
import com.example.library_commen.presenter.OrderPresenter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/19.
 */
@Route(path = ArouterKey.ORDER_ORDERDETAILACTIVITY)
public class OrderDetailActivity extends BaseMvpActivity<OrderPresenter> implements OrderDetailContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.text1)
    TextView text1;
    @BindView(R2.id.distance_text)
    TextView distanceText;
    @BindView(R2.id.text2)
    TextView text2;
    @BindView(R2.id.order_start)
    TextView orderStart;
    @BindView(R2.id.order_end)
    TextView orderEnd;
    @BindView(R2.id.orderName)
    TextView orderName;
    @BindView(R2.id.order_publish)
    TextView orderPublish;
    @BindView(R2.id.order_publishTime)
    TextView orderPublishTime;
    @BindView(R2.id.orderAmount)
    TextView orderAmount;
    @BindView(R2.id.car_type1)
    TextView carType1;
    @BindView(R2.id.car_type2)
    TextView carType2;
    @BindView(R2.id.orderremark)
    TextView orderremark;
    @BindView(R2.id.recycle_car)
    RecyclerView recycleCar;
    String id;
    private List<CarBean> list = new ArrayList<>();
    private OrderDetailCarAdapter adapter;
    @Override
    public int getView() {
        return R.layout.activity_orderdetail;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        adapter = new OrderDetailCarAdapter(R.layout.item_order_car, new ArrayList<DetailCarListBean>());
        recycleCar.setLayoutManager(new GridLayoutManager(mContext, 4));
        recycleCar.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public OrderPresenter getPresenter() {
        return new OrderPresenter();
    }

    @Override
    public void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString(IntentKey.ORDER_ID);
            presenter.getOrderById(id);
            presenter.getOrderCarsList(id);
        }
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
    public void setOrderDetail(OrderBean orderDetail) {
        orderStart.setText(orderDetail.getStartPlace());
        orderEnd.setText(orderDetail.getDestinationPlace());
        orderAmount.setText(orderDetail.getOrderAmount() + "方");
        orderName.setText(orderDetail.getOrderName());
        orderPublishTime.setText(orderDetail.getPublishTime());
        orderPublish.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStationName());
        carType2.setText(orderDetail.getCarType());
        if (orderDetail.getCarType().equals("B")) {
            carType1.setText("泵车");
        } else {
            carType1.setText("砼车");
        }
        orderremark.setText(orderDetail.getOrderRemark());
    }

    @Override
    public void setOrderCarList(List<DetailCarListBean> carList) {
        adapter.setNewData(carList);
    }

    @Override
    public void cancelOrderSuccess() {

    }
}
