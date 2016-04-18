package com.dong.huang.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.base.BaseActivity;
import com.dong.huang.healthapp.fragments.FootPrintFragment;
import com.dong.huang.healthapp.fragments.HomeFragment;
import com.dong.huang.healthapp.fragments.SelfRatingFragment;
import com.dong.huang.healthapp.fragments.StoreFragment;
import com.dong.huang.healthapp.service.StepService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Map<String,Fragment> mFragments;
    private Toolbar mToolbar;
    private int mCurrentPage;

    private static final int MSG_EXIT = 0x01;
    private static final int MSG_EXIT_WAIT = 0x02;
    private static final int EXIT_DELAY_TIME = 2000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_EXIT:
                    if(handler.hasMessages(MSG_EXIT_WAIT)) {
                        handler.removeMessages(MSG_EXIT_WAIT);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                        handler.sendEmptyMessageDelayed(MSG_EXIT_WAIT, EXIT_DELAY_TIME);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化视图
     */
    private void initView(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() != mCurrentPage) {
                    mCurrentPage = item.getItemId();
                    mToolbar.setTitle(item.getTitle());

                    Fragment fragment = mFragments.get(item.getTitle());
                    //判断操作的是否时fragment， fragment若为空，则加载的是Activity
                    if (fragment != null) {
                        //若fragment没有在管理类中，则添加
                        if (getSupportFragmentManager().findFragmentByTag(item.getTitle().toString()) == null) {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .add(R.id.content_main, fragment, item.getTitle().toString())
                                    .commit();
                        } //否则，找到该fragment并显示
                        show(fragment);
                    }
                }
                mDrawerLayout.closeDrawers();
                return false;
            }
        });

        setStatusBarColor(R.color.color_title_bar);

        mNavigationView.getHeaderView(0).findViewById(R.id.ll_user_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断用户是否登陆
                //若没登录
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化数据
     */
    public void initData(){
        mFragments = new HashMap<String, Fragment>();

        mFragments.put(getString(R.string.menu_home_str), new HomeFragment());
        mFragments.put(getString(R.string.menu_zice_str), new SelfRatingFragment());
        mFragments.put(getString(R.string.menu_store_str), new StoreFragment());
        mFragments.put(getString(R.string.menu_footprint_str), new FootPrintFragment());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_main, mFragments.get(getString(R.string.menu_home_str)), getString(R.string.menu_home_str))
                .commit();

        Intent intent = new Intent(this, StepService.class);
        startService(intent);
    }

    /**
     * 连续按返回键退出程序
     */
    @Override
    public void onBackPressed() {
        handler.sendEmptyMessage(MSG_EXIT);
    }

    /**
     * 显示一个fragment
     * @param fragment
     */
    public void show(Fragment fragment){
        //先隐藏所有的fragment
        hide();
        //显示指定的fragment
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    /**
     * 隐藏所有的fragment
     */
    public void hide(){
        List<Fragment> list = getSupportFragmentManager().getFragments();
        for(int i = 0;i < list.size();i++){
            getSupportFragmentManager().beginTransaction().hide(list.get(i)).commit();
        }
    }
}
