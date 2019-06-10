package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.DriverRequest;
import com.example.library_main.R;
import com.tongdada.base.config.BaseUrl;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:30
 * @change
 */
public class DriverManagerAdapter extends BaseQuickAdapter<DriverRequest,BaseViewHolder> {
    public DriverManagerAdapter(int layoutResId, @Nullable List<DriverRequest> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DriverRequest item) {
        helper.addOnClickListener(R.id.item_slide);
        helper.setText(R.id.user_name,item.getDriverName());
        helper.setText(R.id.user_position,"年龄 "+item.getDriAge());
        helper.setText(R.id.user_position1,"驾龄 "+item.getDriveringAge());
        RequestOptions requestOptions=new RequestOptions().centerCrop()
                .error(R.mipmap.user_defut)
                .placeholder(R.mipmap.user_defut);
        ImageView imageView=helper.getView(R.id.user_pic);
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getIdBack()).into(imageView);
    }
}
