package com.example.library_amap.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
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
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventAdressBean;
import com.example.library_commen.model.IssueOrderBean;
import com.example.library_commen.model.OrderBean;
import com.example.overlay.DrivingRouteOverlay;
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

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/21 9:32
 * @change
 */
@Route(path = ArouterKey.MAP_ROUTEACTIVITY)
public class RouteActivity extends BaseActivity implements LocationSource, AMap.OnMapTouchListener, RouteSearch.OnRouteSearchListener {

    @BindView(R2.id.route_map)
    MapView routeMap;
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
    @BindView(R2.id.issueorder_route_cl)
    ConstraintLayout issueorderRouteCl;
    @BindView(R2.id.route_start)
    TextView routeStart;
    @BindView(R2.id.route_end)
    TextView routeEnd;
    @BindView(R2.id.plan_one_tv)
    TextView planOneTv;
    @BindView(R2.id.plan_one_distance)
    TextView planOneDistance;
    @BindView(R2.id.plan_one_time)
    TextView planOneTime;
    @BindView(R2.id.plan_one_ll)
    LinearLayout planOneLl;
    @BindView(R2.id.plan_two_tv)
    TextView planTwoTv;
    @BindView(R2.id.plan_two_distance)
    TextView planTwoDistance;
    @BindView(R2.id.plan_two_time)
    TextView planTwoTime;
    @BindView(R2.id.plan_two_ll)
    LinearLayout planTwoLl;
    @BindView(R2.id.plan_three_tv)
    TextView planThreeTv;
    @BindView(R2.id.plan_three_distance)
    TextView planThreeDistance;
    @BindView(R2.id.plan_three_time)
    TextView planThreeTime;
    @BindView(R2.id.plan_three_ll)
    LinearLayout planThreeLl;
    @BindView(R2.id.sure_tv)
    TextView sureTv;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    private AMap aMap;
    private RouteSearch routeSearch;
    private LatLonPoint start, end;
    private OrderBean issueOrderBean;

    @Override
    public int getView() {
        return R.layout.activity_route;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        if (aMap == null) {
            aMap = routeMap.getMap();
        }
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setOnMapTouchListener(this);
        routeSearch = new RouteSearch(this);
        routeSearch.setRouteSearchListener(this);
        issueOrderBean = (OrderBean) getIntent().getSerializableExtra(IntentKey.MAP_ADDRESS);
        if (issueOrderBean != null) {
            routeStart.setText(issueOrderBean.getStartPlace());
            routeEnd.setText(issueOrderBean.getDestinationPlace());
            start = new LatLonPoint(Double.valueOf(issueOrderBean.getStartLatitude()), Double.valueOf(issueOrderBean.getStartLongitude()));
            end = new LatLonPoint(Double.valueOf(issueOrderBean.getDstLatitude()), Double.valueOf(issueOrderBean.getDstLongitude()));
            queryRoute();
        }
    }

    @Override
    public void initLinsenterner() {


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventAdress(EventAdressBean adressBean) {
        if (adressBean.getCode() == 0) {
            start = new LatLonPoint(adressBean.getLatitude(), adressBean.getLongitude());
            routeStart.setText(adressBean.getAdressName());
        } else {
            end = new LatLonPoint(adressBean.getLatitude(), adressBean.getLongitude());
            routeEnd.setText(adressBean.getAdressName());
        }
        queryRoute();
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
        routeMap.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        routeMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        routeMap.onPause();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        routeMap.onDestroy();
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
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    private List<DrivePath> drivePaths = new ArrayList<>();
    private DriveRouteResult driveRouteResult;

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int errorCode) {
        aMap.clear();// 清理地图上的所有覆盖物
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (driveRouteResult != null && driveRouteResult.getPaths() != null) {
                drivePaths.clear();
                drivePaths.addAll(driveRouteResult.getPaths());
                this.driveRouteResult = driveRouteResult;
            }
            index = 0;
            setTextColor();
            drawPath();
        }
    }

    private void drawPath() {
        aMap.clear();
        for (int i = 0; i < driveRouteResult.getPaths().size(); i++) {
            DrivePath drivePath = driveRouteResult.getPaths().get(i);
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
            switch (i) {
                case 0:
                    planOneDistance.setText(drivePath.getDistance() / 1000 + "KM");
                    planOneTime.setText(drivePath.getDuration() / 60 + "分钟");
                    break;
                case 1:
                    planTwoDistance.setText(drivePath.getDistance() / 1000 + "KM");
                    planTwoTime.setText(drivePath.getDuration() / 60 + "分钟");
                    break;
                case 2:
                    planThreeDistance.setText(drivePath.getDistance() / 1000 + "KM");
                    planThreeTime.setText(drivePath.getDuration() / 60 + "分钟");
                    break;
            }
        }
        setRoute();
    }

    int index = 0;

    private void setRoute() {
        DrivePath drivePath = driveRouteResult.getPaths().get(index);
        DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(
                mContext, aMap, drivePath,
                driveRouteResult.getStartPos(),
                driveRouteResult.getTargetPos(), null);
        drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
        drivingRouteOverlay.setIsColorfulline(true);//是否用颜色展示交通拥堵情况，默认true
        drivingRouteOverlay.setoneColor(Color.parseColor("#1CB954"));
        drivingRouteOverlay.removeFromMap();
        drivingRouteOverlay.addToMap();
        drivingRouteOverlay.zoomToSpan();
    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }

    @OnClick(R2.id.route_start)
    public void onRouteStartClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SELECTADRESSACTIVITY).withInt(IntentKey.MAP_TYPE, 0).navigation(mContext);
    }

    @OnClick(R2.id.route_end)
    public void onRouteEndClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SELECTADRESSACTIVITY).withInt(IntentKey.MAP_TYPE, 1).navigation(mContext);
    }

    @OnClick(R2.id.plan_one_ll)
    public void onPlanOneLlClicked() {
        index = 0;
        selectRoute();
    }

    @OnClick(R2.id.plan_two_ll)
    public void onPlanTwoLlClicked() {
        index = 1;
        selectRoute();
    }

    @OnClick(R2.id.plan_three_ll)
    public void onPlanThreeLlClicked() {
        index = 2;
        selectRoute();
    }

    private void selectRoute() {
        setTextColor();
        drawPath();
    }

    private void setTextColor() {
        switch (index) {
            case 0:
                planOneDistance.setTextColor(getResources().getColor(R.color._E06E38));
                planOneTime.setTextColor(getResources().getColor(R.color._E06E38));
                planOneTv.setTextColor(getResources().getColor(R.color._E06E38));
                planThreeDistance.setTextColor(getResources().getColor(R.color._999999));
                planThreeTime.setTextColor(getResources().getColor(R.color._999999));
                planTwoTime.setTextColor(getResources().getColor(R.color._999999));
                planThreeTv.setTextColor(getResources().getColor(R.color._999999));
                planTwoTv.setTextColor(getResources().getColor(R.color._999999));
                planTwoDistance.setTextColor(getResources().getColor(R.color._999999));
                break;
            case 1:
                planOneDistance.setTextColor(getResources().getColor(R.color._999999));
                planOneTime.setTextColor(getResources().getColor(R.color._999999));
                planOneTv.setTextColor(getResources().getColor(R.color._999999));
                planThreeDistance.setTextColor(getResources().getColor(R.color._999999));
                planThreeTime.setTextColor(getResources().getColor(R.color._999999));
                planTwoTime.setTextColor(getResources().getColor(R.color._E06E38));
                planThreeTv.setTextColor(getResources().getColor(R.color._999999));
                planTwoTv.setTextColor(getResources().getColor(R.color._E06E38));
                planTwoDistance.setTextColor(getResources().getColor(R.color._E06E38));
                break;
            case 2:
                planOneDistance.setTextColor(getResources().getColor(R.color._999999));
                planOneTime.setTextColor(getResources().getColor(R.color._999999));
                planOneTv.setTextColor(getResources().getColor(R.color._999999));
                planThreeDistance.setTextColor(getResources().getColor(R.color._E06E38));
                planThreeTime.setTextColor(getResources().getColor(R.color._E06E38));
                planTwoTime.setTextColor(getResources().getColor(R.color._999999));
                planThreeTv.setTextColor(getResources().getColor(R.color._E06E38));
                planTwoTv.setTextColor(getResources().getColor(R.color._999999));
                planTwoDistance.setTextColor(getResources().getColor(R.color._999999));
                break;
        }
    }

    @OnClick(R2.id.sure_tv)
    public void onViewClicked() {
        issueOrderBean.setDestinationPlace(routeEnd.getText().toString());
        issueOrderBean.setStartPlace(routeStart.getText().toString());
        issueOrderBean.setStartLatitude(String.valueOf(start.getLatitude()));
        issueOrderBean.setStartLongitude(String.valueOf(start.getLongitude()));
        issueOrderBean.setDstLatitude(String.valueOf(end.getLatitude()));
        issueOrderBean.setDstLongitude(String.valueOf(end.getLongitude()));
        String total = "0.0KM";
        switch (index) {
            case 0:
                total = planOneDistance.getText().toString();
                break;
            case 1:
                total = planTwoDistance.getText().toString();
                break;
            case 2:
                total = planThreeDistance.getText().toString();
                break;
        }
        issueOrderBean.setTotalDistance(total);
        EventBus.getDefault().post(issueOrderBean);
        finish();
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }
}
