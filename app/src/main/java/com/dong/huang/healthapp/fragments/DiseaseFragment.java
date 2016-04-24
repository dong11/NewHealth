package com.dong.huang.healthapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.ShareGridViewAdapter;
import com.dong.huang.healthapp.beans.ShareBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/22
 * @time 下午11:25
 * 疾病列表碎片
 */
public class DiseaseFragment extends Fragment {

    private List<ShareBean> mBeans;
    private RecyclerView mRecyclerView;
    private ShareGridViewAdapter mAdapter;

    public DiseaseFragment() {

    }

    public static DiseaseFragment newInstance(ArrayList<ShareBean> mBeans) {
        DiseaseFragment fragment = new DiseaseFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("beans", mBeans);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mBeans = bundle.getParcelableArrayList("beans");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_disease, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_selfrating_disease);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    }

    private void initData() {
        mAdapter = new ShareGridViewAdapter(getActivity(), mBeans);
        mRecyclerView.setAdapter(mAdapter);
    }
}
