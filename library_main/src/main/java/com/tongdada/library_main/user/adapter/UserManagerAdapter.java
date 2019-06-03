package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.example.library_commen.model.UserBean;
import com.example.library_main.R;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.library_main.user.respose.UserListBean;
import com.tongdada.library_main.user.respose.UserManagerBean;
import com.tongdada.library_main.widget.MessageSlidingMenu;
import com.tongdada.library_main.widget.UserSlidingMenu;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:56
 * @change
 */
public class UserManagerAdapter extends BaseQuickAdapter<UserBean,BaseViewHolder> {
    public UserManagerAdapter(int layoutResId, @Nullable List<UserBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserBean item) {
        ImageView imageView=helper.getView(R.id.user_pic);
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.user_sample)
                .placeholder(R.mipmap.user_sample)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+item.getIconPic()).apply(requestOptions).into(imageView);
        helper.setText(R.id.user_name,item.getUserName());
        helper.setText(R.id.user_position, item.getStationRemarks());
        helper.setText(R.id.user_position,item.getUserDuty());
        helper.addOnClickListener(R.id.cl_conten);
        helper.addOnClickListener(R.id.item_slide);
    }
    private UserSlidingMenu mOpenMenu;

    public void holdOpenMenu(UserSlidingMenu slidingMenu) {
        mOpenMenu = slidingMenu;
    }

    public void closeOpenMenu() {
        if (mOpenMenu != null && mOpenMenu.isOpen()) {
            mOpenMenu.closeMenu();
        }
    }
}
