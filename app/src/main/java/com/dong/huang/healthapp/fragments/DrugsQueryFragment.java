package com.dong.huang.healthapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.RVDrugsSortAdapter;
import com.dong.huang.healthapp.beans.DrugsSortBean;
import com.dong.huang.healthapp.component.ApiInterface;
import com.dong.huang.healthapp.component.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * 药品查询页面
 */
public class DrugsQueryFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RVDrugsSortAdapter mAdapter;
    private List<DrugsSortBean.DataBean.ItemsBean> mBeans;

    public DrugsQueryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drugs_query, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_query_drugs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mBeans = new ArrayList<>();

        mAdapter = new RVDrugsSortAdapter(getActivity(), mBeans);
        mRecyclerView.setAdapter(mAdapter);

        initData();
    }

    public void initData(){
        RetrofitSingleton.getApiService(getActivity(), ApiInterface.URL_HOME_IMAGE)
                .getDrugsSortBean("d5424fa6-adff-4b0a-8917-4264daf4a348")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DrugsSortBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), "网络异常,请检查网络", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(DrugsSortBean bean) {
                        mBeans.addAll(bean.getData().getItems());
                        mAdapter.notifyDataSetChanged();
                    }
                });
    }
}
