package com.tongdada.library_main.home.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.example.library_commen.model.TransportCarBean;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 11:13
 * @change
 */
public class TransportCarrAdapter extends BaseAdapter<FinaceBean> {
    public TransportCarrAdapter(int layoutResId, @Nullable List<FinaceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FinaceBean item) {
        helper.setText(R.id.transport_carnumber,item.getCarNo());
        helper.setText(R.id.driver_name,item.getDriverName());
        helper.setText(R.id.order_accept_time,item.getAcceptTime());
        helper.setText(R.id.distance_text,item.getTotalDistance()+"km");
        helper.setText(R.id.car_title,item.getOrderName());
        ImageView imageView=helper.getView(R.id.user_pic_iv);
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.user_sample)
                .placeholder(R.mipmap.user_sample)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getIconPic()).apply(requestOptions).into(imageView);
        if (item.getCarType().equals("B")){
            helper.setText(R.id.car_type,"泵车");
        }else {
            helper.setText(R.id.car_type,"砼车| 装载"+item.getCarType().substring(item.getCarType().length()-2,item.getCarType().length())+"方");
        }
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
    }
}
