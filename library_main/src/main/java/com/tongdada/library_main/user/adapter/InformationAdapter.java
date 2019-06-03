package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.user.respose.InformationBean;
import com.tongdada.library_main.user.respose.UserManagerBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:56
 * @change
 */
public class InformationAdapter extends BaseQuickAdapter<BannerBean.RowsBean,BaseViewHolder> {
    public InformationAdapter(int layoutResId, @Nullable List<BannerBean.RowsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BannerBean.RowsBean item) {
        ImageView pic=helper.getView(R.id.information_pic);
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        TextView time=helper.getView(R.id.information_time);
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getPriviewPic()).apply(requestOptions).into(pic);
        helper.setText(R.id.information_conten,item.getNewsContent());
        if (item.getCreateTime() == null){
            Date currentTime = new Date(item.getCreateTime().getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateString = formatter.format(currentTime);
            time.setText(dateString);
        }
    }
}
