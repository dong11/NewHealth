package com.dong.huang.healthapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/22
 * @time 下午11:25
 * 首页资讯页面
 */
public class HomeFragment extends Fragment {

    private List<Fragment> fragments;
    private FragmentAdapter adapter;
    private List<String> titles;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    /**
     * 初始化视图
     * @param view
     */
    private void initView(View view){

        viewPager = (ViewPager) view.findViewById(R.id.vp_home);

        fragments = new ArrayList<>();

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        fragments.add(new HotHomeFragment());
        fragments.add(new OneImageFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new TruthFragment());
        fragments.add(new NutritionFragment());
//        fragments.add(new SelfRatingFragment());
//        fragments.add(new SelfRatingFragment());

        titles = new ArrayList<>();
        titles.add("热门");
        titles.add("一图读懂");
        titles.add("专题");
        titles.add("真相");
        titles.add("营养");
//        titles.add("碎片3");
//        titles.add("碎片4");

        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(4)));
//        tabLayout.addTab(tabLayout.newTab().setText(titles.get(5)));

        adapter = new FragmentAdapter(getChildFragmentManager(),fragments,titles);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);
    }
}
