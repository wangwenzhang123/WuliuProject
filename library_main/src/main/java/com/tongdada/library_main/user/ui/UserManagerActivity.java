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
import com.example.library_commen.event.EventAddBean;
import com.example.library_commen.model.UserBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.adapter.UserManagerAdapter;
import com.tongdada.library_main.user.presenter.UserInfoContract;
import com.tongdada.library_main.user.presenter.UserManagerContract;
import com.tongdada.library_main.user.presenter.UserManagerPresenter;
import com.tongdada.library_main.user.respose.UserListBean;
import com.tongdada.library_main.user.respose.UserManagerBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:06
 * @change
 */
@Route(path = ArouterKey.USER_USERMANAGERACTIVITY)
public class UserManagerActivity extends BaseMvpActivity<UserManagerPresenter> implements UserManagerContract.View{
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.user_manager_recycle)
    RecyclerView userManagerRecycle;
    @BindView(R2.id.add_user_tv)
    TextView addUserTv;
    private List<UserBean> userManagerBeanList = new ArrayList<>();
    private UserManagerAdapter adapter;

    @Override
    public int getView() {
        return R.layout.activity_usermanager;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        userManagerRecycle.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserManagerAdapter(R.layout.item_usermanager, userManagerBeanList);
        userManagerRecycle.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter1, View view, int position) {
                int id=view.getId();
                if (id == R.id.cl_conten) {
                    ARouter.getInstance().build(ArouterKey.USER_ADDUSERDETAILACTIVITY).withSerializable(IntentKey.USER_DETAIL,adapter.getData().get(position)).navigation(mContext);
                } else if (id == R.id.item_slide) {
                    presenter.deleteUser(adapter.getData().get(position).getId());
                }
            }
        });
    }

    @Override
    public void getData() {
        presenter.getUserList();
    }

    @Override
    public UserManagerPresenter getPresenter() {
        return new UserManagerPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void addUser(EventAddBean eventAddBean){
        presenter.getUserList();
    }
    @OnClick(R2.id.register_back)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R2.id.add_user_tv)
    public void onAddViewClicked() {
        routerIntent(ArouterKey.USER_ADDUSERACTIVITY,null);
    }

    @Override
    public void setUserList(List<UserBean> list) {
        adapter.setNewData(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
