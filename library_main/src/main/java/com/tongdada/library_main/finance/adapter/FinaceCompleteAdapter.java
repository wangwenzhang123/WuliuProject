package com.tongdada.library_main.finance.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.example.library_commen.model.TransportCarBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinaceCompleteAdapter extends BaseQuickAdapter<TransportCarBean,BaseViewHolder>{
    public FinaceCompleteAdapter(int layoutResId, @Nullable List<TransportCarBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TransportCarBean item) {
        helper.setText(R.id.transport_carnumber,item.getCarNo());
        helper.setText(R.id.driver_name,item.getDriverName());
        helper.setText(R.id.order_accept_time,item.getAcceptTime());
        helper.setText(R.id.distance_text,item.getTotalDistance()+"km");
    }
}
