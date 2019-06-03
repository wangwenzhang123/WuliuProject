package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.MyViewPagerAdapter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.order.ui.OrderListFragment;
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
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 11:25
 * @change
 */
@Route(path = ArouterKey.HOME_TRANSPORTCARACTIVITY)
public class TransportCarActivity extends BaseActivity {
    @BindView(R2.id.iv_order_search)
    ImageView ivOrderSearch;
    @BindView(R2.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R2.id.ll)
    LinearLayout ll;
    @BindView(R2.id.transport_tab)
    TabLayout transportTab;
    @BindView(R2.id.pager)
    ViewPager pager;
    List<String> list=new ArrayList<>()/*{"进行中","已完成","已卸货"}*/;
    private List<Fragment> fragments=new ArrayList<>();
    @Override
    public int getView() {
        return R.layout.activity_transport_car;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        pager.setOffscreenPageLimit(5);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        list.add("已接单");
        list.add("已装货");
        list.add("已卸货");
        list.add("已核算");
        Observable.create(new ObservableOnSubscribe<List<Fragment>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Fragment>> e) throws Exception {
                fragments.add(new TransportCarFragment("A"));
                fragments.add(new TransportCarFragment("Z"));
                fragments.add(new TransportCarFragment("S"));
                fragments.add(new TransportCarFragment("E"));
                e.onNext(fragments);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Fragment>>() {
                    @Override
                    public void accept(final List<Fragment> fragments) throws Exception {
                        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
                        transportTab.setupWithViewPager(pager);
                        transportTab.post(new Runnable() {
                            @Override
                            public void run() {
                                TalUtils.setIndicator(transportTab,15,15);
                            }
                        });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showToast(mContext,throwable.getMessage());
                    }
                });
    }
    private void initTab(){
        for (int i = 0; i <list.size() ; i++) {
            View  view= LayoutInflater.from(mContext).inflate(R.layout.item_tab,null);
            view.setLayoutParams(new LinearLayout.LayoutParams(
                            100,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
            TextView title=view.findViewById(R.id.text_day);
            title.setText(list.get(i));
            TabLayout.Tab tab=transportTab.newTab();
            tab.setCustomView(view);
            transportTab.addTab(tab);
        }
        //transportTab.setupWithViewPager(pager);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.iv_order_search)
    public void onViewClicked() {
    }
}
