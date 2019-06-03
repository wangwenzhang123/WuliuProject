package com.tongdada.sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tongdada.base.app.AppActivityKey;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.base.view.NavigationView;
import com.tongdada.sample.R;
import com.tongdada.sample.R2;
import com.tongdada.sample.SampleBean;
import com.tongdada.sample.dialog.SampleDialog;
import com.tongdada.sample.presenter.SampleContact;
import com.tongdada.sample.presenter.SamplePresenterImp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

@Route(path = AppActivityKey.SAMPLE_ACTIVITY)
public class SampleActivity extends BaseMvpActivity<SamplePresenterImp> implements SampleContact.View {

    @BindView(R2.id.sample_bt1)
    Button sampleBt1;
    @BindView(R2.id.sample_bt2)
    Button sampleBt2;
    @BindView(R2.id.sample_bt3)
    Button sampleBt3;

    @Override
    public SamplePresenterImp getPresenter() {
        return new SamplePresenterImp();
    }

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public BaseDialog getDialog() {
        return new SampleDialog(this);
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        Observable.interval(1, 10, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return String.valueOf(aLong) + "a";
            }
        }).subscribe(observer);
        //Observable.range(1,10).map(String :: valueOf).subscribe(observer);
    }

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String value) {
            Log.e(TGA, value);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }

    @Override
    public void getSampleData(final SampleBean sampleBean) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(mContext, "取到了=" + sampleBean.getResult().size() + "条数据");
            }
        });
        Log.e(TGA, "取到了=" + sampleBean.getResult().size() + "条数据");
    }

    @OnClick({R2.id.sample_bt1, R2.id.sample_bt2, R2.id.sample_bt3,R2.id.sample_bt4})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.sample_bt1) {
            presenter.getSampleData("123");
        } else if (i == R.id.sample_bt2) {
            //startActivity(new Intent(this, SampleListActivity.class));
            ARouter.getInstance().build(AppActivityKey.SAMPLELIST_ACTIVITY).navigation(this, new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    Log.e(TGA, "onArrival: 找到了 ");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Log.e(TGA, "onArrival: 找不到了 "+postcard.getPath());
                }

                @Override
                public void onArrival(Postcard postcard) {

                }

                @Override
                public void onInterrupt(Postcard postcard) {

                }
            });
        } else if (i == R.id.sample_bt3) {
            ARouter.getInstance().build(AppActivityKey.SAMPLEREFESH_ACTIVITY).navigation(this);
        }else if (i == R.id.sample_bt4){
           // startActivity(new Intent(this,NavigationActivity.class));
            ARouter.getInstance().build(AppActivityKey.LOGIN_REGISTER).navigation(this);
        }
    }

}
