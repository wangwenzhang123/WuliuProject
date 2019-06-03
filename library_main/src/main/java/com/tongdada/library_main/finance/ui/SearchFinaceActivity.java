package com.tongdada.library_main.finance.ui;

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
import com.alibaba.android.arouter.launcher.ARouter;
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
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.finance.presenter.SearchFiancePresenter;
import com.tongdada.library_main.finance.presenter.SearchFinaceContract;
import com.tongdada.library_main.home.adapter.TransportCarrAdapter;
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
@Route(path = ArouterKey.ORDER_SEARCHFINACEACTIVITY)
public class SearchFinaceActivity extends BaseMvpActivity<SearchFiancePresenter> implements SearchFinaceContract.View {
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
    TransportCarrAdapter adapter;

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
        adapter = new TransportCarrAdapter(R.layout.item_transport_car, new ArrayList<FinaceBean>());
        searchRecycle.setAdapter(adapter);

    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                if (adapter.getData().get(position).getOrderStatus().equals("H")){
                    ARouter.getInstance().build(ArouterKey.FINANCE_FINACEORDERACTIVITY).withString(IntentKey.MAP_ORDERID,adapter.getData().get(position).getRowId()).navigation(mContext);
                }else {
                    ARouter.getInstance().build(ArouterKey.MAP_MAPCARDETAILACTIVITY).withString(IntentKey.MAP_ORDERID,adapter.getData().get(position).getRowId()).navigation(mContext);
                }
            }
        });
    }

    @Override
    public void getData() {
        search = SharedPreferencesUtil.getInstance().getString(ShareKey.SEARCH_FINACE, null);
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
                        presenter.findDetailList(tv.getText().toString());
                    }
                });
                historyFll.addView(tv);
            }
        }

    }

    @Override
    public SearchFiancePresenter getPresenter() {
        return new SearchFiancePresenter();
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
        presenter.findDetailList(result);
        if (TextUtils.isEmpty(search)) {
            search = result;
            SharedPreferencesUtil.getInstance().putString(ShareKey.SEARCH_FINACE, search);
        } else {
            SharedPreferencesUtil.getInstance().putString(ShareKey.SEARCH_FINACE, search + "," + result);
        }
        selectSearchTv.setText("");
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }

    @Override
    public void setDataList(List<FinaceBean> list) {
        adapter.setNewData(list);
    }
}
