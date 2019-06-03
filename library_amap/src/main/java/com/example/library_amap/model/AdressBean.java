package com.example.library_amap.model;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeAddress;

/**
 * Created by wangshen on 2019/5/18.
 */

public class AdressBean {
    private boolean select;
    private PoiItem poiItem;
    private GeocodeAddress geocodeAddress;

    public GeocodeAddress getGeocodeAddress() {
        return geocodeAddress;
    }

    public void setGeocodeAddress(GeocodeAddress geocodeAddress) {
        this.geocodeAddress = geocodeAddress;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public PoiItem getPoiItem() {
        return poiItem;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.poiItem = poiItem;
    }
}
