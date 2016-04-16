package com.dong.huang.healthapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.dong.huang.healthapp.R;

/**
 * A simple {@link Fragment} subclass.
 * 附近药店页面
 */
public class StoreFragment extends Fragment {

    private MapView mMapView;
    private RecyclerView mRecyclerView;
    private AMap mMap;

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
    }

    private void initView(View view){
        AMap aMap = mMapView.getMap();
        aMap.getUiSettings().setZoomControlsEnabled(false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.near_recyclerView);
    }
}
