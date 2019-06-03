package com.example.library_amap.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_amap.adapter.SelectMapAdapter;
import com.example.library_amap.model.AdressBean;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventAdressBean;
import com.example.util.ToastUtil;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Route(path = ArouterKey.MAP_SEARCHADRESSACTIVITY)
public class SearchAdressActivity extends BaseActivity implements PoiSearch.OnPoiSearchListener {
    GeocodeSearch geocoderSearch;
    @BindView(R2.id.search_et)
    EditText searchEt;
    @BindView(R2.id.search_recycler)
    RecyclerView searchRecycler;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    private SelectMapAdapter adapter;
    private int mapType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getView() {
        return R.layout.activity_search_adress;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        mapType = getIntent().getIntExtra(IntentKey.MAP_TYPE, 0);
        searchRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectMapAdapter(R.layout.itme_selectadress, new ArrayList<AdressBean>());
        searchRecycler.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {
        searchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (null != keyEvent && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()) {
                    switch (keyEvent.getAction()) {
                        case KeyEvent.ACTION_UP:
                            query(searchEt.getText().toString().trim());
                            return true;
                        default:
                            return true;
                    }
                }
                return false;
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<AdressBean> adressBeans = adapter.getData();
                AdressBean adressBean = adressBeans.get(position);
                EventAdressBean eventAdressBean = new EventAdressBean();
                eventAdressBean.setAdressName(adressBean.getPoiItem().getTitle());
                eventAdressBean.setLatitude(adressBean.getPoiItem().getLatLonPoint().getLatitude());
                eventAdressBean.setLongitude(adressBean.getPoiItem().getLatLonPoint().getLongitude());
                eventAdressBean.setCode(mapType);
                EventBus.getDefault().post(eventAdressBean);
                finish();
            }
        });
    }

    private void query(String adress) {
        if (TextUtils.isEmpty(adress)) {
            ToastUtil.show(mContext, "请输入搜索地址");
            return;
        }
        PoiSearch.Query query = new PoiSearch.Query(adress, "", "南京市");
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);//设置查询页码
        PoiSearch poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void getData() {

    }

    @Override
    public void onPoiSearched(final PoiResult poiResult, int i) {
        Observable.create(new ObservableOnSubscribe<List<AdressBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<AdressBean>> e) throws Exception {
                List<AdressBean> list = new ArrayList<>();
                if (poiResult != null && poiResult.getPois() != null) {
                    for (int i = 0; i < poiResult.getPois().size(); i++) {
                        PoiItem poiItem = poiResult.getPois().get(i);
                        AdressBean adressBean = new AdressBean();
                        adressBean.setPoiItem(poiItem);
                        list.add(adressBean);
                    }
                    e.onNext(list);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<AdressBean>>() {
                    @Override
                    public void accept(List<AdressBean> adressBeans) throws Exception {
                        adapter.setNewData(adressBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @OnClick(R2.id.back_iv)
    public void onViewClicked() {
        finish();
    }
}
