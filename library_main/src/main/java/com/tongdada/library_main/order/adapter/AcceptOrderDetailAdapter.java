package com.tongdada.library_main.order.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.base.config.BaseUrl;
import com.example.library_commen.model.TransportCarBean;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 17:40
 * @change
 */
public class AcceptOrderDetailAdapter extends BaseQuickAdapter<FinaceBean,BaseViewHolder> {
    public AcceptOrderDetailAdapter(int layoutResId, @Nullable List<FinaceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FinaceBean item) {
        helper.setText(R.id.transport_carnumber,item.getCarNo());
        helper.setText(R.id.driver_name,item.getDriverName());
        helper.setText(R.id.order_accept_time,item.getAcceptTime());
        helper.setText(R.id.distance_text,item.getTotalDistance()+"km");
        helper.setText(R.id.order_time,item.getAcceptTime());
        helper.setText(R.id.address_start,item.getStartPlace());
        helper.setText(R.id.address_end,item.getDestinationPlace());
        helper.setText(R.id.car_title,item.getOrderName());
        ImageView state=helper.getView(R.id.car_state_iv);
        switch (item.getOrderStatus()){
            case "F":
                state.setImageResource(R.mipmap.ongoing);
                break;
            case "E":
                state.setImageResource(R.mipmap.yiwancheng);
                break;
            case "A":
                state.setImageResource(R.mipmap.yijiedan);
                break;
            case "X":
                state.setImageResource(R.mipmap.daiqueren);
                break;
            case "Z":
                state.setImageResource(R.mipmap.ongoing);
                break;
        }
        ImageView imageView=helper.getView(R.id.user_pic_iv);
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getIconPic()).apply(requestOptions).into(imageView);
    }
}
