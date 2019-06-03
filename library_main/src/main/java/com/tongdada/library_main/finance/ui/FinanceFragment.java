package com.tongdada.library_main.finance.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.MyViewPagerAdapter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.finance.presenter.FinancePresenter;
import com.tongdada.library_main.order.ui.OrderListFragment;
import com.tongdada.library_main.utils.TalUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
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
 * @time 2019/5/14 9:16
 * @change
 */
public class FinanceFragment extends BaseMvpFragment<FinancePresenter> {

    @BindView(R2.id.iv_order_search)
    ImageView ivOrderSearch;
    @BindView(R2.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R2.id.ll)
    LinearLayout ll;
    @BindView(R2.id.finance_horizontal_scrollview)
    TabLayout horizontalScrollview;
    @BindView(R2.id.pager)
    ViewPager pager;
    Unbinder unbinder;
    private List<Fragment> fragments=new ArrayList<>();
    private MyViewPagerAdapter adapter;
    List<String> list=new ArrayList<>();
    @Override
    public FinancePresenter getPresenter() {
        return new FinancePresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_finance;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        list.add("待卸货");
        list.add("未核算");
        list.add("已核算");
        pager.setOffscreenPageLimit(2);
        Observable.create(new ObservableOnSubscribe<List<Fragment>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Fragment>> e) throws Exception {
                fragments.add(new FinanceOrderFragment("R"));
                fragments.add(new FinanceOrderFragment("H"));
                fragments.add(new FinanceCompleteFragment());
                e.onNext(fragments);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Fragment>>() {
                    @Override
                    public void accept(final List<Fragment> fragments) throws Exception {
                        adapter = new MyViewPagerAdapter(getChildFragmentManager(), fragments);
                        pager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
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
                        horizontalScrollview.setupWithViewPager(pager);
                        horizontalScrollview.post(new Runnable() {
                            @Override
                            public void run() {
                                TalUtils.setIndicator(horizontalScrollview,25,25);
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

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R2.id.iv_order_search)
    public void onViewClicked() {
        routerIntent(ArouterKey.ORDER_SEARCHFINACEACTIVITY,null);
    }
}
