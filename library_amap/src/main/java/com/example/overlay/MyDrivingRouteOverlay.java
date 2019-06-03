package com.example.overlay;

import android.content.Context;

import com.amap.api.maps.AMap;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/21 15:31
 * @change
 */
public class MyDrivingRouteOverlay extends DrivingRouteOverlay {
    /**
     * 根据给定的参数，构造一个导航路线图层类对象。
     *
     * @param context          当前的activity对象。
     * @param amap             地图对象。
     * @param path             导航路线规划方案。
     * @param start
     * @param end
     * @param throughPointList
     */
    private int color;
    public MyDrivingRouteOverlay(Context context, AMap amap, DrivePath path, LatLonPoint start, LatLonPoint end, List<LatLonPoint> throughPointList) {
        super(context, amap, path, start, end, throughPointList);
    }
    public void setColor(int color){
        this.color=color;
    }
    @Override
    protected int getDriveColor() {
        return color;
    }
}
