package com.tongdada.library_main.web;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 14:15
 * @change
 */
@Route(path = ArouterKey.WEB_WEBACITIVITY)
public class WebAcitivity extends BaseActivity {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.web_web)
    WebView webWeb;

    @Override
    public int getView() {
        return R.layout.activity_web;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        webWeb.loadUrl("http://www.baidu.com");
        webWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        webWeb.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webWeb.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webWeb.destroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onViewClicked() {
        finish();
    }
}
