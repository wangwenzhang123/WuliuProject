package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.user.ui.InformationFragment;
import com.tongdada.library_main.user.ui.MessageFragment;
import com.tongdada.library_main.utils.TalUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangshen on 2019/5/20.
 */
@Route(path = ArouterKey.HOME_INFORMMANAGEMENTACTIVITY)
public class InformManagementActivity extends BaseActivity {
    @BindView(R2.id.register_back)
    ImageView ivOrderSearch;
    @BindView(R2.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R2.id.ll)
    LinearLayout ll;
    @BindView(R2.id.notice_tab)
    TabLayout noticeTab;
    @BindView(R2.id.notice_pager)
    ViewPager noticePager;
    List<String> list = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int getView() {
        return R.layout.activity_inform_management;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        list.add("消息通知");
        list.add("咨询信息");
        Observable.create(new ObservableOnSubscribe<List<Fragment>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Fragment>> e) throws Exception {
                fragments.add(new MessageFragment());
                fragments.add(new InformationFragment());
                e.onNext(fragments);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Fragment>>() {
                    @Override
                    public void accept(final List<Fragment> fragments) throws Exception {
                        noticePager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                            @Override
                            public Fragment getItem(int position) {
                                return fragments.get(position);
                            }

                            @Override
                            public int getCount() {
                                return fragments.size();
                            }

                            @Nullable
                            @Override
                            public CharSequence getPageTitle(int position) {
                                return list.get(position);
                            }
                        });
                        //
                        //initTab();
                        noticeTab.setupWithViewPager(noticePager);
                        noticeTab.post(new Runnable() {
                            @Override
                            public void run() {
                                TalUtils.setIndicator(noticeTab, 15, 15);
                            }
                        });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showToast(mContext, throwable.getMessage());
                    }
                });
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onViewClicked() {
        finish();
    }
}
