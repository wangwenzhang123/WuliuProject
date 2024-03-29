package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.dialog.DeleteDialog;
import com.example.library_commen.event.EventAddBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.utils.PhoneCallUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.adapter.DriverManagerAdapter;
import com.tongdada.library_main.user.presenter.DriverManagerContract;
import com.tongdada.library_main.user.presenter.DriverManagerPresenter;
import com.tongdada.library_main.widget.SlideRecyclerView;

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
 * @time 2019/6/4 16:43
 * @change
 */
@Route(path = ArouterKey.USER_DRIVERMANAGERACTIVITY)
public class DriverManagerActivity extends BaseMvpActivity<DriverManagerPresenter> implements DriverManagerContract.View, DeleteDialog.OnClick {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.add_driver_tv)
    TextView addDriverTv;
    @BindView(R2.id.driver_manager_recycle)
    SlideRecyclerView driverManagerRecycle;
    DriverManagerAdapter driverManagerAdapter;
    private DeleteDialog deleteDialog;
    @Override
    public int getView() {
        return R.layout.activity_driver_manager;
    }

    @Override
    public DriverManagerPresenter getPresenter() {
        return new DriverManagerPresenter();
    }

    @Override
    public void initView() {
        driverManagerAdapter=new DriverManagerAdapter(R.layout.item_driver,new ArrayList<DriverRequest>());
        driverManagerRecycle.setLayoutManager(new LinearLayoutManager(this));
        driverManagerRecycle.setAdapter(driverManagerAdapter);
        presenter.driverList();
        deleteDialog=new DeleteDialog(this);
        deleteDialog.setOnClick(this);
    }

    @Override
    public void initLinsenterner() {
        driverManagerAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view .getId() == R.id.item_slide){
                    deleteDialog.show(position);
                }else if (view .getId() == R.id.user_call){
                    PhoneCallUtils.call(driverManagerAdapter.getData().get(position).getDriverMobile(),mContext);
                }
            }
        });
        driverManagerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ARouter.getInstance().build(ArouterKey.USER_ADDDRIVERACTIVITY).withSerializable(IntentKey.DRIVER_BEAN,driverManagerAdapter.getData().get(position)).navigation(mContext);
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void addUser(EventAddBean eventAddBean){
        presenter.driverList();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @OnClick(R2.id.add_driver_tv)
    public void onAddDriverTvClicked() {
        routerIntent(ArouterKey.USER_ADDDRIVERACTIVITY,null);
    }

    @Override
    public void setDriverList(List<DriverRequest> list) {
        driverManagerAdapter.setNewData(list);
    }

    @Override
    public void onClick(int position) {
        presenter.deleteDriver(driverManagerAdapter.getData().get(position).getId());
    }
}
