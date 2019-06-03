package com.tongdada.library_main.statistics.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library_main.R;
import com.example.library_main.R2;
import com.github.mikephil.charting.charts.BarChart;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.statistics.presenter.StatiscsPresenter;
import com.tongdada.library_main.statistics.presenter.StatisticsContract;
import com.tongdada.library_main.widget.BarChartManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/19.
 */

public class StatistisSupplierFragment extends BaseMvpFragment<StatiscsPresenter> implements StatisticsContract.View {
    @BindView(R2.id.statistics_supplier_barchart)
    BarChart statisticsSupplierBarchart;
    Unbinder unbinder;
    private BarChartManager barChartManager;
    @Override
    public int getViewId() {
        return R.layout.fragment_statistics_supplier;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        barChartManager=new BarChartManager(statisticsSupplierBarchart);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        ArrayList<Float> xValues=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            xValues.add(Float.valueOf(i));
        }
        List<Float> yValues=new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            yValues.add((float) (Math.random() * 5000));
        }
        List<String> stringList=new ArrayList<>();
        stringList.add("周一");
        stringList.add("周二");
        stringList.add("周三");
        stringList.add("周四");
        stringList.add("周五");
        stringList.add("周六");
        stringList.add("周日");
        barChartManager.showBarChart(xValues,yValues,"",R.color._ffe06e38,mContext);
    }

    @Override
    public StatiscsPresenter getPresenter() {
        return new StatiscsPresenter();
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
}
