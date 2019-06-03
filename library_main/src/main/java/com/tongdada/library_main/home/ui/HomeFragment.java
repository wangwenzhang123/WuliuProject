package com.tongdada.library_main.home.ui;

import android.content.Context;
import android.os.Bundle;
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
import com.example.library_commen.model.OrderBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.home.presenter.HomeContract;
import com.tongdada.library_main.home.presenter.HomePresenter;
import com.tongdada.library_main.home.request.MessageIntentBean;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.order.adapter.OrderAdapter;
import com.tongdada.library_main.order.ui.OrderListFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    @BindView(R2.id.home_order)
    TextView homeOrder;
    @BindView(R2.id.home_view)
    View homeView;
    Unbinder unbinder;
    @BindView(R2.id.home_car)
    TextView homeCar;
    @BindView(R2.id.home_order_rv)
    FrameLayout homeOrderRv;
    private OrderAdapter orderAdapter;
    private List<OrderBean> orderBeanList = new ArrayList<>();

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
        presenter.getMixStationById();
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
                BannerBean.RowsBean rowsBean=rowsBeanList.get(position);
                MessageIntentBean  messageIntentBean=new MessageIntentBean(rowsBean.getNewsTitle(),rowsBean.getPriviewPic(),rowsBean.getNewsContent(),String.valueOf(rowsBean.getCreateTime().getTime()));
                ARouter.getInstance().build(ArouterKey.MESSAGE_MESSAGEDETAILACTIVITY).withSerializable(IntentKey.MESSAGE_BEAN,messageIntentBean)
                        .navigation(mContext);
            }
        });


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
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R2.id.iv_home_search)
    public void onIvHomeSearchClicked() {
        routerIntent(ArouterKey.ORDER_SEARCHORDERACTIVITY,null);
    }

    @OnClick(R2.id.iv_home_message)
    public void onIvHomeMessageClicked() {
        routerIntent(ArouterKey.HOME_INFORMMANAGEMENTACTIVITY, null);
    }

    @OnClick(R2.id.home_order)
    public void onHomeOrderClicked() {
        ARouter.getInstance().build(ArouterKey.MAIN_ISSUEORDERACTIVITY).navigation(mContext);
    }

    @OnClick(R2.id.home_car)
    public void onViewClicked() {
        ARouter.getInstance().build(ArouterKey.HOME_TRANSPORTCARACTIVITY).navigation(mContext);
    }
    private List<BannerBean.RowsBean> rowsBeanList=new ArrayList<>();
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
