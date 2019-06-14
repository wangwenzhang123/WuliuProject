package com.example.library_amap.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_amap.adapter.AcceptCarAdapter;
import com.example.library_amap.model.AcceptRequestBean;
import com.example.library_amap.presenter.AcceptOrderContract;
import com.example.library_amap.presenter.AcceptOrderPresenter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.CarBean;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.SelectCarBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.utils.PhoneCallUtils;
import com.example.overlay.DrivingRouteOverlay;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.design.widget.BottomSheetBehavior.STATE_COLLAPSED;
import static android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED;

/**
 * Created by wangshen on 2019/5/19.
 */
@Route(path = ArouterKey.MAP_MAPACCEPTORDERDETAILACTIVITY)
public class MapAcceptOrderDetailActivity extends BaseMvpActivity<AcceptOrderPresenter> implements AcceptOrderContract.View, LocationSource, AMap.InfoWindowAdapter, AMap.OnMapTouchListener, AMap.OnInfoWindowClickListener, RouteSearch.OnRouteSearchListener {

    @BindView(R2.id.search_et)
    TextView searchEt;
    @BindView(R2.id.order_detail_map)
    MapView orderDetailMap;
    @BindView(R2.id.issueorder_start_iv)
    ImageView issueorderStartIv;
    @BindView(R2.id.issueorder_start_tv)
    TextView issueorderStartTv;
    @BindView(R2.id.issue_go_start_iv)
    ImageView issueGoStartIv;
    @BindView(R2.id.start_view)
    View startView;
    @BindView(R2.id.issueorder_end_iv)
    ImageView issueorderEndIv;
    @BindView(R2.id.issueorder_end_tv)
    TextView issueorderEndTv;
    @BindView(R2.id.issue_go_end_iv)
    ImageView issueGoEndIv;
    @BindView(R2.id.end_view)
    View endView;
    @BindView(R2.id.issueorder_issue_iv)
    ImageView issueorderIssueIv;
    @BindView(R2.id.issueorder_distance_tv)
    TextView issueorderDistanceTv;
    @BindView(R2.id.issue_go_distance_iv)
    ImageView issueGoDistanceIv;
    @BindView(R2.id.issueorder_route_cl)
    ConstraintLayout issueorderRouteCl;
    @BindView(R2.id.order_detail_tv)
    TextView orderDetailTv;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    BottomSheetBehavior bottomSheetBehavior;
    @BindView(R2.id.order_totalDistance)
    TextView orderTotalDistance;
    @BindView(R2.id.orderName)
    TextView orderName;
    @BindView(R2.id.order_publish)
    TextView orderPublish;
    @BindView(R2.id.order_publishTime)
    TextView orderPublishTime;
    @BindView(R2.id.orderAmount)
    TextView orderAmount;
    @BindView(R2.id.car_type1)
    TextView carType1;
    @BindView(R2.id.car_type2)
    TextView carType2;
    @BindView(R2.id.orderremark)
    TextView orderremark;
    @BindView(R2.id.order_startPlace)
    TextView orderStartPlace;
    @BindView(R2.id.order_destinationPlace)
    TextView orderDestinationPlace;
    @BindView(R2.id.order_cancel)
    TextView orderCancel;
    @BindView(R2.id.order_change)
    TextView orderChange;
    @BindView(R2.id.recycle_car)
    RecyclerView recycleCar;
    @BindView(R2.id.accpet_detail)
    TextView accpetDetail;
    @BindView(R2.id.leftAmount)
    TextView leftAmount;
    private AMap aMap;
    private List<CarBean> list = new ArrayList<>();
    private AcceptCarAdapter adapter;
    private String id;
    private OrderBean orderBean;
    private RouteSearch routeSearch;
    private LatLonPoint start, end;
    private AcceptRequestBean requestBean = new AcceptRequestBean();

    @Override
    public int getView() {
        return R.layout.activity_map_accept_orderdetail;
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
        aMap.getUiSettings().setRotateGesturesEnabled(false);//禁止地图旋转手势.
        aMap.getUiSettings().setTiltGesturesEnabled(false);
        aMap.setOnInfoWindowClickListener(this);

        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                PhoneCallUtils.call(marker.getSnippet(), mContext);
                return false;
            }
        });
        routeSearch = new RouteSearch(this);
        routeSearch.setRouteSearchListener(this);
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.design_bottom_sheet1));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        adapter = new AcceptCarAdapter(R.layout.item_order_car, new ArrayList<SelectCarBean>());
        recycleCar.setLayoutManager(new GridLayoutManager(mContext, 4));
        recycleCar.setAdapter(adapter);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString(IntentKey.ORDER_ID);
            presenter.getOrderById(id);
        }
    }

    @Override
    public void initLinsenterner() {
        //设置监听事件
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //拖动
                if (newState == STATE_EXPANDED) {
                    orderDetailTv.setVisibility(View.GONE);
                }
                if (newState == STATE_COLLAPSED) {
                    orderDetailTv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //状态变化
            }
        });
    }

    @Override
    public AcceptOrderPresenter getPresenter() {
        return new AcceptOrderPresenter();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventCar(List<SelectCarBean> list) {
        String car = "";
        String amount = "";
        int accept = 0;
        for (int i = 0; i < list.size(); i++) {
            accept += Integer.parseInt(list.get(i).getAmount());
            if (i == list.size() - 1) {
                car = car + list.get(i).getId();
                amount = amount + list.get(i).getAmount();
            } else {
                car = car + list.get(i).getId() + ",";
                amount = amount + list.get(i).getAmount() + ",";
            }
        }
        requestBean.setOrderPrice(String.valueOf(accept * (Integer.parseInt(orderBean.getPerPrice()))));
        requestBean.setCarIds(car);
        requestBean.setOrderAmount(amount);
        adapter.setNewData(list);
    }

    @Override
    public void getData() {

    }

    public void queryRoute() {
        if (start != null && end != null) {
            RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(start, end);
            RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION, null, null, "");
            routeSearch.calculateDriveRouteAsyn(query);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        orderDetailMap.onCreate(savedInstanceState);
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
        EventBus.getDefault().unregister(this);
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

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        return null;
    }


    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @OnClick(R2.id.order_detail_tv)
    public void onViewClicked() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(STATE_COLLAPSED);
        } else if (bottomSheetBehavior.getState() == STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }

    @Override
    public void setOrderDetail(OrderBean orderDetail) {
        orderBean = orderDetail;
        orderStartPlace.setText(orderDetail.getStartPlace());
        orderDestinationPlace.setText(orderDetail.getDestinationPlace());
        orderTotalDistance.setText(orderDetail.getTotalDistance());
        orderAmount.setText(orderDetail.getOrderAmount() + "方");
        orderName.setText(orderDetail.getOrderName());
        orderPublishTime.setText(orderDetail.getPublishTime());
        carType2.setText(orderDetail.getCarType());
        leftAmount.setText(orderDetail.getLeftAmount() + "方");
        if (orderDetail.getCarType().equals("B")) {
            carType1.setText("泵车");
        } else {
            carType1.setText("砼车");
        }
        orderremark.setText(orderDetail.getOrderRemark());
       /* aMap.addMarker(new MarkerOptions().position(new LatLng(31.985562554090762, 118.82025068383825))
                .icon(BitmapDescriptorFactory.fromBitmap(getDestination()))
                .anchor(0.5f, 0.5f));*/
        start = new LatLonPoint(Double.valueOf(orderBean.getStartLatitude()), Double.valueOf(orderBean.getStartLongitude()));
        end = new LatLonPoint(Double.valueOf(orderBean.getDstLatitude()), Double.valueOf(orderBean.getDstLongitude()));
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(end.getLatitude(), end.getLongitude()), 15));
        queryRoute();
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

    @OnClick(R2.id.order_change)
    public void onViewCommitClicked() {
        requestBean.setCompanyId(CommenUtils.getIncetance().getRequestBean().getId());
        requestBean.setStationId(orderBean.getStationId());
        requestBean.setOrderId(orderBean.getId());
        requestBean.setTotalDistance(orderBean.getTotalDistance());
        requestBean.setOrderRemark(orderBean.getOrderRemark());
        presenter.acceptOrderOfLogi(requestBean);
    }

    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int errorCode) {
        //aMap.clear();// 清理地图上的所有覆盖物
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            DrivePath drivePath = driveRouteResult.getPaths().get(0);
            DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(
                    mContext, aMap, drivePath,
                    driveRouteResult.getStartPos(),
                    driveRouteResult.getTargetPos(), null);
            drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
            drivingRouteOverlay.setIsColorfulline(true);//是否用颜色展示交通拥堵情况，默认true
            drivingRouteOverlay.setoneColor(Color.parseColor("#80CAB5"));
            drivingRouteOverlay.removeFromMap();
            drivingRouteOverlay.addToMap();
            drivingRouteOverlay.zoomToSpan();
        }
    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }

    @OnClick(R2.id.accpet_detail)
    public void onViewAcceptClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(IntentKey.ORDER_AMOUNT, orderBean.getLeftAmount());
        routerIntent(ArouterKey.HONE_SELECTCARACTIVITY, bundle);
    }
}
