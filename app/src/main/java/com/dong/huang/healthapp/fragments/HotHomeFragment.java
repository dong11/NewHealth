package com.dong.huang.healthapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.activity.WebViewActivity;
import com.dong.huang.healthapp.adapters.RecyclerHotAdapter;
import com.dong.huang.healthapp.beans.homebean.HotData;
import com.dong.huang.healthapp.beans.homebean.HotInfo;
import com.dong.huang.healthapp.component.ApiInterface;
import com.dong.huang.healthapp.component.RetrofitSingleton;
import com.dong.huang.healthapp.utils.LiteOrmDBUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dong on 16/2/14.
 */
public class HotHomeFragment extends BaseHomeFragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView lvHotData;
    private RecyclerHotAdapter adapter;

    private boolean isCanAddPage = true;
    private int currentPage;
    private int totalItem = Integer.MAX_VALUE;

    private List<HotData> hotDatas;
    private boolean isRefresh = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_base, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
    }

    /**
     * 初始化视图
     * @param view
     */
    private void initView(View view){
        lvHotData = (RecyclerView) view.findViewById(R.id.rv_home_base);
        lvHotData.setLayoutManager(new LinearLayoutManager(getActivity()));
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

        lvHotData.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //用来标记是否正在向最后一个滑动，既是否向右滑动或向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager manager = (LinearLayoutManager)recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == (totalItemCount -1) && isSlidingToLast) {
                        //加载更多功能的代码
                        Log.i("123", "howes right=" + manager.findLastCompletelyVisibleItemPosition());
                        Toast.makeText(getActivity(), "加载更多", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if(dy > 0){
                    //大于0表示，正在向右滚动
                    isSlidingToLast = true;
                }else{
                    //小于等于0 表示停止或向左滚动
                    isSlidingToLast = false;
                }

            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData(){
        hotDatas = LiteOrmDBUtil.getQueryAll(HotData.class);
        adapter = new RecyclerHotAdapter(getActivity(), hotDatas);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("id", hotDatas.get(position).getId());
                intent.putExtra("title", hotDatas.get(position).getTitle());
                intent.putExtra("image", hotDatas.get(position).getH5Img());
                startActivity(intent);
            }
        });
        lvHotData.setAdapter(adapter);

        loadMore();
    }

    /**
     * 加载更多
     */
    private void loadMore(){
        if(isCanAddPage){
            isCanAddPage = false;

            if(isRefresh){
                currentPage = 0;
            }

            if(currentPage++ * 10 > totalItem){
                swipeRefreshLayout.setRefreshing(false);
                return;
            }

            RetrofitSingleton.getApiService(getActivity().getApplicationContext(), ApiInterface.URL_HOME_HOT)
                                .getHomeInfo(String.valueOf(10), String.valueOf(currentPage))
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<HotInfo>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        swipeRefreshLayout.setRefreshing(false);
                                        Toast.makeText(getActivity(), "网络异常,请稍后再试", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onNext(HotInfo hotInfo) {
                                        isCanAddPage = true;
                                        totalItem = hotInfo.getTotalCount();
                                        swipeRefreshLayout.setRefreshing(false);
                                        if(isRefresh){
                                            hotDatas.clear();
                                            isRefresh = false;
                                            LiteOrmDBUtil.deleteAll(HotData.class);
                                            LiteOrmDBUtil.insertAll(hotInfo.getList());
                                        }
                                        hotDatas.addAll(hotInfo.getList());
                                        adapter.notifyDataSetChanged();
                                    }
                                });
        }
    }
}
