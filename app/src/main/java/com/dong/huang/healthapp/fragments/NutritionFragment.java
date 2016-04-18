package com.dong.huang.healthapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.activity.OneImageActivity;
import com.dong.huang.healthapp.activity.SubjectActivity;
import com.dong.huang.healthapp.adapters.RVNutritionAdapter;
import com.dong.huang.healthapp.adapters.RecyclerSubjectAdapter;
import com.dong.huang.healthapp.beans.homebean.NutritionInfo;
import com.dong.huang.healthapp.beans.homebean.SubjectInfo;
import com.dong.huang.healthapp.component.ApiInterface;
import com.dong.huang.healthapp.component.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class NutritionFragment extends Fragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean isRefresh = true;
    private List<NutritionInfo.DataBean.ItemsBean> datas;
    private RVNutritionAdapter adapter;

    public NutritionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_hot, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        loadMore();
    }

    private void initView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_home_hot);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.slr);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                loadMore();
            }
        });

        swipeRefreshLayout.setColorSchemeResources(R.color.color_title_bar, R.color.colorPrimaryDark, R.color.colorAccent);

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    private void initData(){
        datas = new ArrayList<>();
        adapter = new RVNutritionAdapter(getActivity(), datas);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), OneImageActivity.class);
                intent.putExtra("title", datas.get(position).getTitle());
                intent.putExtra("id", datas.get(position).getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void loadMore(){

        RetrofitSingleton.getApiService(getActivity(), ApiInterface.URL_HOME_IMAGE)
                .getNutritionInfo("1", "d5424fa6-adff-4b0a-8917-4264daf4a348", "10", "6")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NutritionInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getActivity(), "网络异常,请检查网络", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(NutritionInfo nutritionInfo) {
                        datas.addAll(nutritionInfo.getData().getItems());
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

}
