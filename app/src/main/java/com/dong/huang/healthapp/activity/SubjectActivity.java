package com.dong.huang.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.RVSubjectItemAdapter;
import com.dong.huang.healthapp.base.BaseActivity;
import com.dong.huang.healthapp.beans.homebean.SubjectItemInfo;
import com.dong.huang.healthapp.component.ApiInterface;
import com.dong.huang.healthapp.component.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SubjectActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RVSubjectItemAdapter adapter;
    private List<SubjectItemInfo.DataBean.ItemsBean> datas;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        setStatusBarColor(R.color.color_title_bar);
        initView();
        initData();
        loadMore();
    }

    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.subject_toolBar);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.subject_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void initData(){
        datas = new ArrayList<>();
        adapter = new RVSubjectItemAdapter(this, datas);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SubjectActivity.this, OneImageActivity.class);
                intent.putExtra("title", datas.get(position).getTitle());
                intent.putExtra("id", datas.get(position).getId());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);

        id = getIntent().getIntExtra("id", 0);
    }

    private void loadMore(){
        RetrofitSingleton.getApiService(getApplicationContext(), ApiInterface.URL_HOME_SUB)
                .getSubjectItemInfo("1", "d5424fa6-adff-4b0a-8917-4264daf4a348","20",String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SubjectItemInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(SubjectItemInfo itemInfo) {
                        datas.addAll(itemInfo.getData().getItems());
                        adapter.notifyDataSetChanged();
                    }
                });
    }

}
