package com.tongdada.library_main.order.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.utils.CheckUtils;
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
        if (TextUtils.isEmpty(item.getAcceptNumber())){
            helper.setText(R.id.order_accept_number,"暂无人接单");
        }else {
            helper.setText(R.id.order_accept_number,item.getAcceptNumber()+"人已接单");
        }

        ImageView imageView=helper.getView(R.id.order_iv);
        ImageView state=helper.getView(R.id.order_state_iv);
        if (item.getCarType().contains("B")){
            helper.setText(R.id.order_cart,CheckUtils.getBangName(item.getCarType())+"| 总货物量"+ item.getOrderAmount()+"|剩余"+item.getLeftAmount()+"方");
        }else {
            helper.setText(R.id.order_cart,"砼车| 总货物量"+item.getOrderAmount()+"|剩余"+item.getLeftAmount()+"方");
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
        if (TextUtils.isEmpty(item.getOrderPic())){
            if (item.getCarType().contains("T")){
                imageView.setImageResource(R.mipmap.tong_pic);
            }else {
                imageView.setImageResource(R.mipmap.beng_pic);
            }
        }else {
            Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getOrderPic()).apply(requestOptions).into(imageView);
        }
    }
}
