package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.library_main.home.request.MessageIntentBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/6/1.
 */
@Route(path = ArouterKey.MESSAGE_MESSAGEDETAILACTIVITY)
public class MessageDetailActivity extends BaseActivity {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.message_title)
    TextView messageTitle;
    @BindView(R2.id.message_time)
    TextView messageTime;
    @BindView(R2.id.message_pic)
    ImageView messagePic;
    @BindView(R2.id.message_conten)
    TextView messageConten;

    @Override
    public int getView() {
        return R.layout.activity_message_detail;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        MessageIntentBean messageIntentBean= (MessageIntentBean) getIntent().getSerializableExtra(IntentKey.MESSAGE_BEAN);
        if (messageIntentBean != null){
            messageTitle.setText(messageIntentBean.getTitle());
            messageConten.setText(messageIntentBean.getConten());
            RequestOptions requestOptions = new RequestOptions()
                    .error(R.mipmap.banner_place)
                    .placeholder(R.mipmap.banner_place)
                    .diskCacheStrategy(DiskCacheStrategy.DATA);
            Glide.with(mContext).load(BaseUrl.BASEURL + "/" + messageIntentBean.getPic())
                    .apply(requestOptions).into(messagePic);
            if (!TextUtils.isEmpty(messageIntentBean.getTime())){
                Date currentTime = new Date(Long.valueOf(messageIntentBean.getTime()));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateString = formatter.format(currentTime);
                messageTime.setText(dateString);
            }
        }

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.register_back, R2.id.back_tv})
    public void onViewClicked(View view) {
        finish();
    }
}
