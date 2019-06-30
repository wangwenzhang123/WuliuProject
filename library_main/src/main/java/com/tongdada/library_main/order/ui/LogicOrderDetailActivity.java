package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.utils.CheckUtils;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.presenter.LogicOrderDetailContract;
import com.example.library_commen.presenter.LogicOrderDetailPresenter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/19.
 */
@Route(path = ArouterKey.ORDER_LOGICORDERDETAILACTIVITY)
public class LogicOrderDetailActivity extends BaseMvpActivity<LogicOrderDetailPresenter> implements LogicOrderDetailContract.View {
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
    String id;
    @BindView(R2.id.ll_loading_evidence)
    LinearLayout llLoadingEvidence;
    @BindView(R2.id.iv_loading_evidence)
    ImageView ivLoadingEvidence;
    @BindView(R2.id.ll_business_license)
    LinearLayout llBusinessLicense;
    @BindView(R2.id.iv_business_license)
    ImageView ivBusinessLicense;
    @BindView(R2.id.confirm_submit)
    TextView confirmSubmit;
    @BindView(R2.id.order_price)
    TextView orderPrice;
    @BindView(R2.id.order_state)
    TextView orderState;
    @Override
    public int getView() {
        return R.layout.activity_logic_orderdetail;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public LogicOrderDetailPresenter getPresenter() {
        return new LogicOrderDetailPresenter();
    }

    @Override
    public void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString(IntentKey.ORDER_ID);
            presenter.getOrderDetail(id);
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
    public void setOrderDetail(DriverOrderDetailBean orderDetail) {
        orderStart.setText(orderDetail.getPsTotalOrder().getStartPlace());
        orderEnd.setText(orderDetail.getPsTotalOrder().getDestinationPlace());
        orderAmount.setText(orderDetail.getOrderAmount() + "方");
        orderName.setText(orderDetail.getPsTotalOrder().getOrderName());
        orderPublishTime.setText(orderDetail.getAcceptTime());
        carType2.setText(orderDetail.getPsTotalOrder().getCarType());
        orderPrice.setText(orderDetail.getPsTotalOrder().getPerPrice());
        if (orderDetail.getPsTotalOrder().getCarType().contains("B")) {
            carType1.setText("泵车");
            carType2.setText(CheckUtils.getBangName(orderDetail.getPsTotalOrder().getCarType()));
        } else {
            carType1.setText("砼车");
            carType2.setText(orderDetail.getPsTotalOrder().getCarType());
        }
        orderremark.setText(orderDetail.getOrderRemark());
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + orderDetail.getLoadLicense()).apply(requestOptions).into(ivLoadingEvidence);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + orderDetail.getUnloadLicense()).apply(requestOptions).into(ivBusinessLicense);
        if (orderDetail.getOrderStatus().equals("H")){
            confirmSubmit.setVisibility(View.VISIBLE);
            orderState.setText("待核算");
        }else if (orderDetail.getOrderStatus().equals("S")){
            orderState.setText("已核算");
            confirmSubmit.setVisibility(View.GONE);
        }
    }


    @Override
    public void cancelOrderSuccess() {

    }

    @OnClick(R2.id.confirm_submit)
    public void onConfirmSubmitClicked() {
        presenter.batchUpdateDetailOrders(id,"H");
    }

}
