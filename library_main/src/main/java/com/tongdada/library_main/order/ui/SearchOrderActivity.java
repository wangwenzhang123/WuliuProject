package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.appkey.ShareKey;
import com.example.library_commen.model.OrderBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.util.SharedPreferencesUtil;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.order.adapter.OrderAdapter;
import com.tongdada.library_main.order.presenter.SearchOrderContract;
import com.tongdada.library_main.order.presenter.SearchOrderPresenter;
import com.tongdada.library_main.widget.FlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.ORDER_SEARCHORDERACTIVITY)
public class SearchOrderActivity extends BaseMvpActivity<SearchOrderPresenter> implements SearchOrderContract.View {
    @BindView(R2.id.select_search_tv)
    EditText selectSearchTv;
    @BindView(R2.id.history_fll)
    FlowLayout historyFll;
    @BindView(R2.id.search_recycle)
    RecyclerView searchRecycle;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    @BindView(R2.id.search_tv)
    TextView searchTv;
    private OrderAdapter orderAdapter;
    private List<OrderBean> orderBeanList = new ArrayList<>();
    private String[] mVals = new String[]{};
    private String search;

    @Override
    public int getView() {
        return R.layout.activity_search_order;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        searchRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        orderAdapter = new OrderAdapter(R.layout.item_order, orderBeanList);
        searchRecycle.setAdapter(orderAdapter);

    }

    @Override
    public void initLinsenterner() {
        orderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString(IntentKey.ORDER_ID,orderAdapter.getData().get(position).getId());
                if (orderAdapter.getData().get(position).getOrderStatus() .equals("F")){
                    routerIntent(ArouterKey.MAP_MAPORDERDETAILACTIVITY,bundle);
                }else {
                    routerIntent(ArouterKey.ORDER_ORDERDETAILACTIVITY,bundle);
                }
            }
        });
    }

    @Override
    public void getData() {
        search = SharedPreferencesUtil.getInstance().getString(ShareKey.SEARCH_RECORD, null);
        if (search != null) {
            mVals = search.split(",");
            String [] strings=new String[10];
            if (mVals.length > 10){
                strings= Arrays.copyOfRange(mVals, mVals.length-11, mVals.length-1);
            }else {
                strings=mVals;
            }
            for (int i = 0; i < strings.length; i++) {
                final TextView tv = (TextView) LayoutInflater.from(mContext).inflate(
                        R.layout.history_item, historyFll, false);
                tv.setText(strings[i]);
                final String str = tv.getText().toString();
                //点击事件
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.getSearchOrder(tv.getText().toString());
                    }
                });
                historyFll.addView(tv);
            }
        }

    }

    @Override
    public SearchOrderPresenter getPresenter() {
        return new SearchOrderPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.search_tv)
    public void onViewClicked() {
        String result = selectSearchTv.getText().toString().trim();
        if (TextUtils.isEmpty(result)) {
            ToastUtils.showToast(mContext, "请输入想要搜索的内容！");
            return;
        }
        presenter.getSearchOrder(result);
        if (TextUtils.isEmpty(search)) {
            search = result;
            SharedPreferencesUtil.getInstance().putString(ShareKey.SEARCH_RECORD, search);
        } else {
            SharedPreferencesUtil.getInstance().putString(ShareKey.SEARCH_RECORD, search + "," + result);
        }
        selectSearchTv.setText("");
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }

    @Override
    public void setSearchOrderList(List<OrderBean> list) {
        orderAdapter.setNewData(list);
    }
}
