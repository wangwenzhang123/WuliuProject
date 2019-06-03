package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/6/1.
 */
@Route(path = ArouterKey.ORDER_ACCEPTDETAILACTIVITY)
public class AcceptDetailActivity extends BaseActivity {
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
    @BindView(R2.id.transport_carnumber)
    TextView transportCarnumber;
    @BindView(R2.id.driver_name)
    TextView driverName;
    @BindView(R2.id.driver_phone)
    TextView driverPhone;
    @BindView(R2.id.accept_total)
    TextView acceptTotal;
    @BindView(R2.id.driver_attribution)
    TextView driverAttribution;
    @BindView(R2.id.now_loading)
    TextView nowLoading;
    @BindView(R2.id.unit_price)
    TextView unitPrice;
    @BindView(R2.id.order_start)
    TextView orderStart;
    @BindView(R2.id.order_end)
    TextView orderEnd;
    private FinaceBean finaceBean;

    @Override
    public int getView() {
        return R.layout.activity_accept_detail;
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
    public void getData() {
        finaceBean = (FinaceBean) getIntent().getSerializableExtra(IntentKey.ORDER_BEAN);
        orderStart.setText(finaceBean.getStartPlace());
        orderEnd.setText(finaceBean.getDestinationPlace());
        transportCarnumber.setText(finaceBean.getCarNo());
        distanceText.setText(finaceBean.getTotalDistance());
        driverName.setText(finaceBean.getDriverName());
        nowLoading.setText(finaceBean.getOrderAmount());
        unitPrice.setText(finaceBean.getAcceptTime());
        driverPhone.setText(finaceBean.getDriverMobile());
        driverAttribution.setText(finaceBean.getCompanyName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.register_back, R2.id.back_tv})
    public void onViewClicked(View view) {
        finish();
    }
}
