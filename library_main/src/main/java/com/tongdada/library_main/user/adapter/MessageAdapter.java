package com.tongdada.library_main.user.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.library_main.user.respose.InformationBean;
import com.tongdada.library_main.user.respose.MessageBean;
import com.tongdada.library_main.widget.MessageSlidingMenu;
import com.tongdada.library_main.widget.slideswaphelper.SlideSwapAction;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:56
 * @change
 */
public class MessageAdapter extends BaseQuickAdapter<MessageBean.PagenationBean.ListBean,BaseViewHolder> {
    public MessageAdapter(int layoutResId, @Nullable List<MessageBean.PagenationBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageBean.PagenationBean.ListBean item) {
        helper.setText(R.id.message_title,item.getMessageContent());
        helper.setText(R.id.message_time,item.getSendTime());
        helper.addOnClickListener(R.id.ll_conten);
        helper.addOnClickListener(R.id.item_slide);
        switch (item.getReadStatus()){
            case "N":
                helper.setText(R.id.message_state,"未读") ;
                break;
            case "Y":
                helper.setText(R.id.message_state,"已读") ;
                break;
                default:
                    helper.setText(R.id.message_state,"未知") ;
                    break;
        }

    }
    private MessageSlidingMenu mOpenMenu;

    public void holdOpenMenu(MessageSlidingMenu slidingMenu) {
        mOpenMenu = slidingMenu;
    }

    public void closeOpenMenu() {
        if (mOpenMenu != null && mOpenMenu.isOpen()) {
            mOpenMenu.closeMenu();
        }
    }
    /**
     * 根据手机分辨率从DP转成PX
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
