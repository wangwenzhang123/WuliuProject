package com.tongdada.library_main.statistics.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library_main.R;
import com.example.library_main.R2;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.statistics.presenter.StatiscsPresenter;
import com.tongdada.library_main.statistics.presenter.StatisticsContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/19.
 */

public class StatistisOrderFragment extends BaseMvpFragment<StatiscsPresenter> implements StatisticsContract.View {
    @BindView(R2.id.statistics_order)
    LineChart lineChart;
    Unbinder unbinder;

    @Override
    public int getViewId() {
        return R.layout.fragment_statistics_order;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        Description description =new Description();
        description.setText("测试图表");
        description.setTextColor(Color.RED);
        description.setTextSize(20);
        lineChart.setDescription(description);//设置图表描述信息
        lineChart.setNoDataText("没有数据熬");//没有数据时显示的文字
        lineChart.setNoDataTextColor(Color.BLUE);//没有数据时显示文字的颜色
        lineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        lineChart.setDrawBorders(false);
        setchartData(lineChart);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        ArrayList<Entry> values1 = new ArrayList<>();
        values1.add(new Entry(4,10));
        values1.add(new Entry(6,15));
        values1.add(new Entry(9,20));
        values1.add(new Entry(12,5));
        values1.add(new Entry(15,30));

    }
    private void setchartData(LineChart chart){
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(1, 9));
        entries.add(new Entry(2, 11));
        entries.add(new Entry(3, 5));
        entries.add(new Entry(4, 20));
        entries.add(new Entry(5, 15));
        entries.add(new Entry(6, 20));
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(getResources().getColor(R.color._ffe06e38));//线条颜色
//        dataSet.setCircleColor(Color.parseColor("#7d7d7d"));//圆点颜色
        dataSet.setDrawValues(false);                     // 设置是否显示数据点的值
        dataSet.setDrawCircleHole(true);                 // 设置数据点是空心还是实心，默认空心
        dataSet.setCircleColor(Color.parseColor("#AABCC6"));              // 设置数据点的颜色
        dataSet.setCircleSize(3);                         // 设置数据点的大小
        dataSet.setHighLightColor(Color.parseColor("#AABCC6"));            // 设置点击时高亮的点的颜色
        dataSet.setLineWidth(2f);//线条宽度
        //设置样式
        YAxis rightAxis = chart.getAxisRight();
        //设置图表右边的y轴禁用
        rightAxis.setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        //设置图表左边的y轴禁用
        leftAxis.setEnabled(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(Color.parseColor("#333333"));
        //设置x轴
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextColor(Color.parseColor("#333333"));
        xAxis.setTextSize(11f);
        xAxis.setAxisMinimum(0f);
        xAxis.setDrawAxisLine(false);//是否绘制轴线
        xAxis.setDrawGridLines(false);//设置x轴上每个点对应的线
        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setGranularity(1f);//禁止放大后x轴标签重绘

        final String [] xAxisName = {"周日","周一","周二","周三","周四","周五","周六"};
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return  xAxisName[(int) value];
            }
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xAxisName[(int) value];
            }
        });
        //透明化图例
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.NONE);
        legend.setTextColor(Color.WHITE);
        //隐藏x轴描述
        Description description = new Description();
        description.setEnabled(false);
        chart.setDescription(description);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
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
