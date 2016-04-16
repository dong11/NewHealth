package com.dong.huang.healthapp.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.dong.huang.healthapp.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by dong on 16/4/5.
 */
public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    private void initWindow(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //状态栏变透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //底部导航栏变为透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 设置状态栏颜色
     * 也就是所谓沉浸式状态栏
     */
    public void setStatusBarColor(int color) {
        /**
         * Android4.4以上  但是抽屉有点冲突，目前就重写一个方法暂时解决4.4的问题
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);
            tintManager.setNavigationBarTintResource(color);
        }
    }

}
