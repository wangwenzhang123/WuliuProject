package com.tongdada.library_main.order.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.OrderBean;
import com.example.library_main.R;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 11:13
 * @change
 */
public class OrderAdapter extends BaseAdapter<OrderBean> {
    public OrderAdapter(int layoutResId, @Nullable List<OrderBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean item) {
        helper.setText(R.id.order_name,item.getOrderName());
        helper.setText(R.id.order_start_tv,item.getStartPlace());
        helper.setText(R.id.order_end_tv,item.getDestinationPlace());
        helper.setText(R.id.order_time,item.getPublishTime());
        ImageView imageView=helper.getView(R.id.order_iv);
        ImageView state=helper.getView(R.id.order_state_iv);
        if (item.getCarType().equals("B")){
            helper.setText(R.id.order_cart,"泵车");
        }else {
            helper.setText(R.id.order_cart,"砼车| 装载"+item.getCarType().substring(item.getCarType().length()-2,item.getCarType().length())+"方");
        }
        switch (item.getOrderStatus()){
            case "F":
                state.setImageResource(R.mipmap.ongoing);
                break;
            case "E":
                state.setImageResource(R.mipmap.yiwancheng);
                break;
            case "A":
                state.setImageResource(R.mipmap.accounting);
                break;
            case "Z":
                state.setImageResource(R.mipmap.daihesuan);
                break;
        }
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getOrderPic()).apply(requestOptions).into(imageView);
    }
}
