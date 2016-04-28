package com.dong.huang.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.RVDrugsItemAdapter;
import com.dong.huang.healthapp.adapters.RVSubjectItemAdapter;
import com.dong.huang.healthapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueryDrugsActivity extends BaseActivity {

    private String mTitle;
    private List<String> mDatas;
    private RecyclerView mRecyclerView;
    private RVDrugsItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        setStatusBarColor(R.color.color_title_bar);

        String tags = getIntent().getStringExtra("tags_str");
        mTitle = getIntent().getStringExtra("title");

        mDatas = Arrays.asList(tags.split(","));
        initView();
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
        toolbar.setTitle(mTitle);

        mRecyclerView = (RecyclerView) findViewById(R.id.subject_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RVDrugsItemAdapter(this, mDatas);
        mAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QueryDrugsActivity.this, DrugsInfoActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}
