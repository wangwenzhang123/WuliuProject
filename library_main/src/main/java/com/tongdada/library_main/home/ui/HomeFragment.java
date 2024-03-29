package com.tongdada.library_main.home.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventMessageBran;
import com.example.library_commen.model.OrderBean;
import com.example.library_main.MyViewPagerAdapter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.home.presenter.HomeContract;
import com.tongdada.library_main.home.presenter.HomePresenter;
import com.tongdada.library_main.home.request.MessageIntentBean;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.order.adapter.OrderAdapter;
import com.tongdada.library_main.order.ui.LogicOrderListFragment;
import com.tongdada.library_main.order.ui.OrderListFragment;
import com.tongdada.library_main.order.ui.TenOrderListFragment;
import com.tongdada.library_main.utils.LoginUtils;
import com.tongdada.library_main.utils.TalUtils;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
 * @time 2019/5/14 9:46
 * @change
 */
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.View {


    @BindView(R2.id.iv_home_search)
    ImageView ivHomeSearch;
    @BindView(R2.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R2.id.ll)
    LinearLayout ll;
    @BindView(R2.id.banner)
    MZBannerView banner;
    @BindView(R2.id.home_view)
    View homeView;
    Unbinder unbinder;
    @BindView(R2.id.home_order_rv)
    FrameLayout homeOrderRv;
    @BindView(R2.id.more_order)
    TextView moreOrder;
    @BindView(R2.id.weidu)
    TextView weidu;
    @BindView(R2.id.horizontal_scrollview)
    TabLayout horizontalScrollview;
    @BindView(R2.id.pager)
    ViewPager pager;
    private OrderAdapter orderAdapter;
    private List<OrderBean> orderBeanList = new ArrayList<>();
    private List<Fragment> fragments=new ArrayList<>();
    List<String> list=new ArrayList<>();
    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        presenter.shuffling();
        presenter.initData();
        presenter.getMessageList();
        list.add("砼车");
        list.add("泵车");
        list.add("10公里");
        list.add("全部");
        //list.add("已装货");
        /* list.add("已核算");*/
        pager.setOffscreenPageLimit(3);
        Observable.create(new ObservableOnSubscribe<List<Fragment>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Fragment>> e) throws Exception {
                fragments.add(new OrderListFragment("F","T","",""));
                fragments.add(new OrderListFragment("F","B","",""));
                fragments.add(new TenOrderListFragment());
                fragments.add(new OrderListFragment("F","","",""));
                //fragments.add(new TransportCarFragment("Z"));
                //fragments.add(new TransportCarFragment("S"));
                e.onNext(fragments);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Fragment>>() {
                    @Override
                    public void accept(final List<Fragment> fragments) throws Exception {
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
                                TalUtils.setIndicator(horizontalScrollview,32,32);
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
        getChildFragmentManager()    //
                .beginTransaction()
                .add(R.id.home_order_rv, new OrderListFragment("F"))
                .commit();
    }

    @Override
    public void getData() {

        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                BannerBean.RowsBean rowsBean = rowsBeanList.get(position);
                MessageIntentBean messageIntentBean = new MessageIntentBean(rowsBean.getNewsTitle(), rowsBean.getPriviewPic(), rowsBean.getNewsContent(), String.valueOf(rowsBean.getCreateTime().getTime()));
                ARouter.getInstance().build(ArouterKey.MESSAGE_INFORMDETAILACTIVITY).withSerializable(IntentKey.MESSAGE_BEAN, messageIntentBean)
                        .navigation(mContext);
            }
        });
        banner.setIndicatorVisible(false);
        //banner.setIndicatorRes(R.color.transparency,R.color.transparency);
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();//开始轮播

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventMessage(EventMessageBran a) {
        if (a.getNum() == 0) {
            weidu.setVisibility(View.GONE);
        } else {
            weidu.setVisibility(View.VISIBLE);
        }
        weidu.setText(a.getNum() + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R2.id.iv_home_search)
    public void onIvHomeSearchClicked() {
        if (LoginUtils.isLogin()) {
            routerIntent(ArouterKey.ORDER_SEARCHORDERACTIVITY, null);
        } else {
            ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
        }

    }

    @OnClick(R2.id.iv_home_message)
    public void onIvHomeMessageClicked() {
        if (LoginUtils.isLogin()) {
            routerIntent(ArouterKey.HOME_INFORMMANAGEMENTACTIVITY, null);
        } else {
            ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
        }

    }

    private List<BannerBean.RowsBean> rowsBeanList = new ArrayList<>();

    @Override
    public void setBannerData(List<BannerBean.RowsBean> bannerData) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < bannerData.size(); i++) {
            list.add(bannerData.get(i).getPriviewPic());
        }
        rowsBeanList.clear();
        rowsBeanList.addAll(bannerData);
        banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
    }

    @OnClick(R2.id.more_order)
    public void onViewClicked() {
        if (LoginUtils.isLogin()) {
            routerIntent(ArouterKey.HOME_MOREORDERACTIVITY, null);
        } else {
            ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
        }

    }

    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            RequestOptions requestOptions = new RequestOptions()
                    .error(R.mipmap.banner_place)
                    .placeholder(R.mipmap.banner_place)
                    .diskCacheStrategy(DiskCacheStrategy.DATA);
            Glide.with(context).load(BaseUrl.BASEURL + "/" + data)
                    .apply(requestOptions).into(mImageView);
        }
    }
}
