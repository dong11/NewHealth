package com.dong.huang.healthapp.fragments;


import android.animation.ObjectAnimator;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.RecyclerMapAdapter;
import com.dong.huang.healthapp.base.BaseApplication;
import com.dong.huang.healthapp.utils.ScreenUtils;

import java.util.ArrayList;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/22
 * @time 下午11:25
 * 附近药店页面
 */
public class StoreFragment extends Fragment implements PoiSearch.OnPoiSearchListener,
        AMap.InfoWindowAdapter, AMap.OnMapClickListener, AMap.OnMarkerClickListener, View.OnClickListener {

    private MapView mMapView;
    private RecyclerView mRecyclerView;
    private FloatingActionButton fabMap;
    private FloatingActionButton fabMapList;
    private FloatingActionButton fabMapRefresh;
    private FloatingActionButton fabMapShare;
    private RecyclerMapAdapter adapter;
    private ArrayList<PoiItem> datas;
    private AMap mMap;
    private boolean flag;
    private boolean flagList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        fabMap = (FloatingActionButton) view.findViewById(R.id.map_fab);
        fabMapList = (FloatingActionButton) view.findViewById(R.id.map_fab_list);
        fabMapRefresh = (FloatingActionButton) view.findViewById(R.id.map_fab_refresh);
        fabMapShare = (FloatingActionButton) view.findViewById(R.id.map_fab_share);


        mMap = mMapView.getMap();
        mMap.getUiSettings().setZoomControlsEnabled(false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.near_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        datas = new ArrayList<>();

        adapter = new RecyclerMapAdapter(getActivity(), datas);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mRecyclerView.setAdapter(adapter);

        fabMap.setOnClickListener(this);
        fabMapList.setOnClickListener(this);
        fabMapRefresh.setOnClickListener(this);
        fabMapShare.setOnClickListener(this);
    }

    private void initData() {

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                new CameraPosition(new LatLng(BaseApplication.lat, BaseApplication.lon), 15, 30, 0)), 1000, null);

        PoiSearch.Query query = new PoiSearch.Query("药店", "", BaseApplication.cityName);
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);//设置查第一页
        PoiSearch poiSearch = new PoiSearch(getActivity(), query);
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(BaseApplication.lat,
                BaseApplication.lon), 10000));//设置周边搜索的中心点以及区域
        poiSearch.setOnPoiSearchListener(this);//设置数据返回的监听器
        poiSearch.searchPOIAsyn();//开始搜索

        //绘制marker
        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(BaseApplication.lat, BaseApplication.lon))
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(), R.drawable.marker)))
                .draggable(true));

        Marker marker1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(BaseApplication.lat, BaseApplication.lon))
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(), R.drawable.marker)))
                .draggable(true));
    }

    private void setAnimation(boolean flag, View view, int dis, int mils) {
        ObjectAnimator oa = null;
        if (flag) {
            oa = ObjectAnimator.ofFloat(view, "translationY", dis, 0);
        } else {
            oa = ObjectAnimator.ofFloat(view, "translationY", 0, dis);
        }
        oa.setDuration(mils);
        oa.start();
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    //OnPoiSearchListener
    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        datas.addAll(poiResult.getPois());
        adapter.notifyDataSetChanged();
        for(int a = 0;a < poiResult.getPois().size();a++){
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(poiResult.getPois().get(a).getLatLonPoint().getLatitude(),
                            poiResult.getPois().get(a).getLatLonPoint().getLongitude()))
                    .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                            .decodeResource(getResources(), R.drawable.marker)))
                    .draggable(true));
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.map_fab:
                if (!flag) {
                    flag = true;
                    if (fabMapList.getVisibility() != View.VISIBLE) {
                        fabMapList.setVisibility(View.VISIBLE);
                        fabMapRefresh.setVisibility(View.VISIBLE);
                        fabMapShare.setVisibility(View.VISIBLE);
                    }
                } else {
                    flag = false;
                }
                setAnimation(flag, fabMapList, fabMap.getTop(), 300);
                setAnimation(flag, fabMapRefresh, fabMap.getTop(), 300);
                setAnimation(flag, fabMapShare, fabMap.getTop(), 300);
                break;
            case R.id.map_fab_list:
                if (!flagList) {
                    flagList = true;
                    if (mRecyclerView.getVisibility() != View.VISIBLE) {
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }
                } else {
                    flagList = false;
                }
                setAnimation(flagList, mRecyclerView, ScreenUtils.getScreenHeight(getActivity()), 500);
                break;
            case R.id.map_fab_refresh:
                initData();
                break;
            case R.id.map_fab_share:
                break;
        }
    }
}
