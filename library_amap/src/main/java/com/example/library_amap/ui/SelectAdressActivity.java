package com.example.library_amap.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_amap.adapter.SelectMapAdapter;
import com.example.library_amap.model.AdressBean;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventAdressBean;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

@Route(path = ArouterKey.MAP_SELECTADRESSACTIVITY)
public class SelectAdressActivity extends BaseActivity implements LocationSource, AMap.OnMapTouchListener, AMapLocationListener, GeocodeSearch.OnGeocodeSearchListener {

    @BindView(R2.id.select_mapview)
    MapView selectMapview;
    @BindView(R2.id.select_recycler)
    RecyclerView selectRecycler;
    @BindView(R2.id.select_search_tv)
    TextView selectSearchTv;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    private AMap aMap;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    boolean useMoveToLocationWithMapMode = true;
    GeocodeSearch geocoderSearch;
    Marker locationMarker, selectMarker;
    private SelectMapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        selectMapview.onCreate(savedInstanceState);
    }

    @Override
    public int getView() {
        return R.layout.activity_select_adress;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    int mapType;

    @Override
    public void initView() {
        mapType = getIntent().getIntExtra(IntentKey.MAP_TYPE, 0);
        adapter = new SelectMapAdapter(R.layout.itme_selectadress, new ArrayList<AdressBean>());
        selectRecycler.setLayoutManager(new LinearLayoutManager(this));
        selectRecycler.setAdapter(adapter);
        if (aMap == null) {
            aMap = selectMapview.getMap();
        }
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setOnMapTouchListener(this);
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                EventAdressBean eventAdressBean = new EventAdressBean();
                List<AdressBean> adressBeans = adapter.getData();
                AdressBean adressBean = adressBeans.get(position);
                eventAdressBean.setAdressName(adressBean.getPoiItem().getTitle());
                eventAdressBean.setLatitude(adressBean.getPoiItem().getLatLonPoint().getLatitude());
                eventAdressBean.setLongitude(adressBean.getPoiItem().getLatLonPoint().getLongitude());
                eventAdressBean.setCode(mapType);
                EventBus.getDefault().post(eventAdressBean);
                finish();
            }
        });
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                LatLonPoint latLonPoint = new LatLonPoint(latLng.latitude, latLng.longitude);
                RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200, GeocodeSearch.AMAP);
                geocoderSearch.getFromLocationAsyn(query);
                if (selectMarker == null) {
                    selectMarker = aMap.addMarker(new MarkerOptions().position(latLng)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.map_select))
                            .anchor(0.5f, 0.5f));
                } else {
                    selectMarker.setPosition(latLng);
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventAdress(EventAdressBean eventAdressBean) {
        finish();
    }

    @Override
    public void getData() {

    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(this);
            mLocationOption = new AMapLocationClientOption();
            //设置定位监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //是指定位间隔
            mLocationOption.setInterval(2000);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onTouch(MotionEvent motionEvent) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        selectMapview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        selectMapview.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        selectMapview.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
        if (locationMarker == null) {
            //首次定位
            locationMarker = aMap.addMarker(new MarkerOptions().position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_marker))
                    .anchor(0.5f, 0.5f));
            //首次定位,选择移动到地图中心点并修改级别到15级
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        } else {
            if (!useMoveToLocationWithMapMode) {
                aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            }
        }
    }

    @Override
    public void onRegeocodeSearched(final RegeocodeResult regeocodeResult, int i) {
        Observable.create(new ObservableOnSubscribe<List<AdressBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<AdressBean>> e) throws Exception {
                List<AdressBean> list = new ArrayList<>();
                if (regeocodeResult != null && regeocodeResult.getRegeocodeAddress() != null) {
                    if (regeocodeResult.getRegeocodeAddress().getPois() != null) {
                        for (int i = 0; i < regeocodeResult.getRegeocodeAddress().getPois().size(); i++) {
                            PoiItem poiItem = regeocodeResult.getRegeocodeAddress().getPois().get(i);
                            AdressBean adressBean = new AdressBean();
                            adressBean.setPoiItem(poiItem);
                            list.add(adressBean);
                            if (i == 2) {
                                break;
                            }
                        }
                        e.onNext(list);
                    }
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<AdressBean>>() {
                    @Override
                    public void accept(List<AdressBean> adressBeans) throws Exception {
                        adapter.setNewData(adressBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }

    @OnClick(R2.id.select_search_tv)
    public void onViewClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SEARCHADRESSACTIVITY).withInt(IntentKey.MAP_TYPE, mapType).navigation(mContext);
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }
}
