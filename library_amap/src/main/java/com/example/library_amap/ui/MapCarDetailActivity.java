package com.example.library_amap.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_amap.model.MarkerBean;
import com.example.library_amap.presenter.MapCarDetailContract;
import com.example.library_amap.presenter.MapCarDetailPresenter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventUpdateOrderList;
import com.example.library_commen.model.CarBean;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.utils.PhoneCallUtils;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.winfo.photoselector.PhotoSelector;

import org.greenrobot.eventbus.EventBus;

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
 * Created by wangshen on 2019/5/19.
 */
@Route(path = ArouterKey.MAP_MAPCARDETAILACTIVITY)
public class MapCarDetailActivity extends BaseMvpActivity<MapCarDetailPresenter> implements LocationSource, AMap.InfoWindowAdapter, AMap.OnMapTouchListener, AMap.OnInfoWindowClickListener, MapCarDetailContract.View {


    @BindView(R2.id.search_et)
    TextView searchEt;
    @BindView(R2.id.order_detail_map)
    MapView orderDetailMap;
    @BindView(R2.id.back_iv)
    ImageView backIv;

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
    @BindView(R2.id.loading_pic)
    ImageView loadingPic;
    @BindView(R2.id.unload_pic)
    ImageView unloadPic;
    @BindView(R2.id.unload_accomplish_tv)
    TextView unloadAccomplishTv;
    @BindView(R2.id.bottom_ll)
    LinearLayout bottomLl;
    @BindView(R2.id.ll_loading_pic)
    LinearLayout llLoadingPic;
    @BindView(R2.id.ll_unload_pic)
    LinearLayout llUnloadPic;
    @BindView(R2.id.unload_tv)
    TextView unloadTv;
    @BindView(R2.id.unload_fl)
    FrameLayout unloadFl;
    @BindView(R2.id.cancel_tv)
    TextView cancelTv;
    private AMap aMap;
    private String id;
    private static final int LOADING_CODE = 1;
    private static final int UNLOADING_CODE = 2;
    private int state = 0;

    @Override
    public int getView() {
        return R.layout.activity_map_cardetail;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        if (aMap == null) {
            aMap = orderDetailMap.getMap();
        }
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setOnMapTouchListener(this);
        aMap.setInfoWindowAdapter(this);
        aMap.setOnInfoWindowClickListener(this);
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (!TextUtils.isEmpty(marker.getSnippet())) {
                    PhoneCallUtils.call(marker.getSnippet(), mContext);
                }
                return false;
            }
        });
        id = getIntent().getStringExtra(IntentKey.MAP_ORDERID);
        presenter.getDetailOrderById(id);
    }

    @Override
    public MapCarDetailPresenter getPresenter() {
        return new MapCarDetailPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        orderDetailMap.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.FFFFFF));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        orderDetailMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        orderDetailMap.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        orderDetailMap.onDestroy();
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onTouch(MotionEvent motionEvent) {

    }

    @Override
    public View getInfoWindow(Marker marker) {
        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return null;
    }

    /**
     * 自定义infowinfow窗口
     */
    public void render(Marker marker, View view) {
        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.info_title));
        titleUi.setText(title);
        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.info_contan));
        snippetUi.setText(snippet);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        // PhoneCallUtils.call(marker.getSnippet(), mContext);
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }

    @Override
    public void setDetailOrder(final DriverOrderDetailBean detailOrder) {
        driverName.setText(detailOrder.getDriverName());
        driverPhone.setText(detailOrder.getPsDriver().getDriverMobile());
        transportCarnumber.setText(detailOrder.getCarNo());
        unitPrice.setText(detailOrder.getPsTotalOrder().getPerPrice()+"元（单位 方/公里）");
        nowLoading.setText(detailOrder.getOrderAmount() + "方");
        aMap.addMarker(new MarkerOptions().position(new LatLng(Double.valueOf(detailOrder.getPsTotalOrder().getStartLatitude()), Double.valueOf(detailOrder.getPsTotalOrder().getStartLongitude())))
                .icon(BitmapDescriptorFactory.fromBitmap(getDestination()))
                .anchor(0.5f, 0.5f));
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(detailOrder.getPsTotalOrder().getStartLatitude()), Double.valueOf(detailOrder.getPsTotalOrder().getStartLongitude())), 13));
        Observable.create(new ObservableOnSubscribe<MarkerBean>() {
            @Override
            public void subscribe(ObservableEmitter<MarkerBean> e) throws Exception {
                CarBean carBean = new CarBean(detailOrder.getDriverName(), detailOrder.getCarNo(), detailOrder.getPsDriver().getDriverMobile(), Double.valueOf(detailOrder.getPsCar().getCarLatitude()), Double.valueOf(detailOrder.getPsCar().getCarLongitude()));
                Bitmap bitmap = getViewBitmap(carBean);
                MarkerBean markerBean = new MarkerBean(carBean.getJing(), carBean.getWei(), carBean.getPhone(), bitmap);
                e.onNext(markerBean);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MarkerBean>() {
                    @Override
                    public void accept(MarkerBean bitmap) throws Exception {
                        Marker marker = aMap.addMarker(new MarkerOptions().position(new LatLng(bitmap.getJing(), bitmap.getWei()))
                                .icon(BitmapDescriptorFactory.fromBitmap(bitmap.getBitmap()))
                                .anchor(0.5f, 0.5f));
                        marker.setSnippet(bitmap.getId());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        if (!TextUtils.isEmpty(detailOrder.getLoadLicense())) {
            Glide.with(mContext).load(BaseUrl.BASEURL + "/" + detailOrder.getLoadLicense()).apply(requestOptions).into(loadingPic);
            unloadTv.setVisibility(View.VISIBLE);
            unloadFl.setVisibility(View.VISIBLE);
            llLoadingPic.setFocusable(false);
            cancelTv.setVisibility(View.GONE);
            unloadAccomplishTv.setText("卸货完成");
            state=2;
        } else {
            state = 1;
            unloadTv.setVisibility(View.GONE);
            unloadFl.setVisibility(View.GONE);
            unloadAccomplishTv.setText("装货完成");
        }
        if (!TextUtils.isEmpty(detailOrder.getUnloadLicense())) {
            Glide.with(mContext).load(BaseUrl.BASEURL + "/" + detailOrder.getUnloadLicense()).apply(requestOptions).into(unloadPic);
            bottomLl.setVisibility(View.GONE);
            llUnloadPic.setFocusable(false);
        }

    }

    @Override
    public void updateSuccess() {
        EventBus.getDefault().post(new EventUpdateOrderList());
        finish();
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(this, code);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case LOADING_CODE:
                    //单选的话 images就只有一条数据直接get(0)即可
                    List<String> images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images.get(0)).into(loadingPic);
                    presenter.upload(images.get(0), LOADING_CODE);
                    break;
                case UNLOADING_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images2 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images2.get(0)).into(unloadPic);
                    presenter.upload(images2.get(0), UNLOADING_CODE);
                    break;
            }
        }
    }

    private String loadLicense, unloadLicense;

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case LOADING_CODE:
                Glide.with(mContext).load(path).into(loadingPic);
                loadLicense = url;
                break;
            case UNLOADING_CODE:
                Glide.with(mContext).load(path).into(unloadPic);
                unloadLicense = url;
                break;
        }
    }

    private Bitmap getViewBitmap(CarBean carBean) {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View view = factory.inflate(R.layout.custom_info_window, null);
        TextView title = (TextView) view.findViewById(R.id.info_title);
        title.setText(carBean.getName());
        TextView conten = view.findViewById(R.id.info_contan);
        conten.setText(carBean.getCarNo());
        view.setDrawingCacheEnabled(true);
        //调用下面这个方法非常重要，如果没有调用这个方法，得到的bitmap为null
        view.measure(View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY));
        //这个方法也非常重要，设置布局的尺寸和位置
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        //获得绘图缓存中的Bitmap
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    private Bitmap getDestination() {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View view = factory.inflate(R.layout.marker_destination, null);
        view.setDrawingCacheEnabled(true);
        //调用下面这个方法非常重要，如果没有调用这个方法，得到的bitmap为null
        view.measure(View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY));
        //这个方法也非常重要，设置布局的尺寸和位置
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        //获得绘图缓存中的Bitmap
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    @OnClick(R2.id.unload_accomplish_tv)
    public void onUnloadAccomplishTvClicked() {
        switch (state) {
            case 1:
                presenter.loadOrder(id,loadLicense);
                break;
            case 2:
                presenter.unloadOrder(id,unloadLicense);
                break;
        }
    }

    @OnClick(R2.id.ll_loading_pic)
    public void onLlLoadingPicClicked() {
        selectPic(LOADING_CODE);
    }

    @OnClick(R2.id.ll_unload_pic)
    public void onLlUnloadPicClicked() {
        selectPic(UNLOADING_CODE);
    }

    @OnClick(R2.id.cancel_tv)
    public void onViewClicked() {
        presenter.cancel(id);
    }
}
