package com.dong.huang.healthapp.fragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.RecyclerMapAdapter;
import com.dong.huang.healthapp.base.BaseApplication;
import com.dong.huang.healthapp.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 附近药店页面
 */
public class StoreFragment extends Fragment {

    private MapView mMapView;
    private RecyclerView mRecyclerView;
    private FloatingActionButton fabMap;
    private RecyclerMapAdapter adapter;
    private AMap mMap;
    private boolean flag;

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

        mMap = mMapView.getMap();
        mMap.getUiSettings().setZoomControlsEnabled(false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.near_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        adapter = new RecyclerMapAdapter(getActivity(), list);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mRecyclerView.setAdapter(adapter);

        fabMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    flag = true;
                    mRecyclerView.setVisibility(View.VISIBLE);
                    setAnimation(mRecyclerView);
                } else {
                    flag = false;
                    setAnimation(mRecyclerView);
                }
            }
        });
    }

    private void initData() {

        Log.i("123", "----->" + BaseApplication.lat + "------>" + BaseApplication.lon);

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                new CameraPosition(new LatLng(BaseApplication.lat, BaseApplication.lon), 15, 30, 0)), 1000, null);

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

    private void setAnimation(View view){
        ObjectAnimator oa = null;
        if(flag) {
            oa = ObjectAnimator.ofFloat(view, "translationY", ScreenUtils.getScreenHeight(getActivity()), 0);
        } else {
            oa = ObjectAnimator.ofFloat(view, "translationY", 0, ScreenUtils.getScreenHeight(getActivity()));
        }
        oa.setDuration(500);
        oa.start();
    }
}
