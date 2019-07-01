package com.tongdada.library_main.user.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventMessageBran;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.home.request.MessageIntentBean;
import com.tongdada.library_main.user.adapter.MessageAdapter;
import com.tongdada.library_main.user.presenter.MessageContract;
import com.tongdada.library_main.user.presenter.MessagePresenter;
import com.tongdada.library_main.user.respose.MessageBean;
import com.tongdada.library_main.widget.SlideRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/20.
 */

public class MessageFragment extends BaseMvpFragment<MessagePresenter> implements MessageContract.View {
    @BindView(R2.id.message_recycle)
    SlideRecyclerView messageRecycle;
    Unbinder unbinder;
    private List<MessageBean.PagenationBean.ListBean> messageBeans=new ArrayList<>();
    private MessageAdapter adapter;
    @Override
    public int getViewId() {
        return R.layout.fragment_message;
    }

    public MessageFragment() {
    }
    private boolean isPare=false;
    @SuppressLint("ValidFragment")
    public MessageFragment(boolean isPare) {
        this.isPare=isPare;
    }
    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        messageRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        messageRecycle.setInterceptTouch(isPare);
        adapter=new MessageAdapter(R.layout.item_message,messageBeans);
        messageRecycle.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {
/*
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                presenter.readMessage(adapter.getData().get(position).getId());
            }
        });
*/
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter1, View view, int position) {
                if (view.getId() == R.id.ll_conten){
                    presenter.readMessage(adapter.getData().get(position).getId(),position);
                }else if (view.getId() == R.id.item_slide){
                    presenter.deleteMessage(adapter.getData().get(position).getId());
                }
            }
        });
    }

    @Override
    public void getData() {
        presenter.getMessageList();
    }

    @Override
    public MessagePresenter getPresenter() {
        return new MessagePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setMessgeList(List<MessageBean.PagenationBean.ListBean> list) {
        adapter.setNewData(list);
    }

    @Override
    public void readSuccess(int postion) {
        int a=0;
        for (int i = 0; i < adapter.getData().size() ; i++) {
            MessageBean.PagenationBean.ListBean listBean=adapter.getData().get(i);
            if (listBean.getReadStatus().equals("N")){
                a++;
            }
        }
        EventBus.getDefault().post(new EventMessageBran(a));
        MessageBean.PagenationBean.ListBean rowsBean=adapter.getData().get(postion);
        MessageIntentBean messageIntentBean=new MessageIntentBean(rowsBean.getMessageContent(),null,null,rowsBean.getSendTime());
        ARouter.getInstance().build(ArouterKey.MESSAGE_MESSAGEDETAILACTIVITY).withSerializable(IntentKey.MESSAGE_BEAN,messageIntentBean)
                .navigation(mContext);
    }
}
