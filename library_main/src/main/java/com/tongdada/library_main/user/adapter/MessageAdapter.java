package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.library_main.user.respose.MessageBean;

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
}
