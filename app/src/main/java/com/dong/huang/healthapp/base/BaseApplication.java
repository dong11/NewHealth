package com.dong.huang.healthapp.base;

import android.app.Application;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.dong.huang.healthapp.utils.LiteOrmDBUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by dong on 16/4/5.
 */
public class BaseApplication extends Application implements AMapLocationListener{

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;

    public static double lat;
    public static double lon;
    public static String cityName;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        LiteOrmDBUtil.createDb(getApplicationContext(), "heath.db");
        PlatformConfig.setWeixin("wxcb98a56f7265f375", "444e6ff310d0a28a0af3c277dc5e03f1");
        PlatformConfig.setSinaWeibo("990358814", "3b764734e2882790a468d30c62e16038");

        initLocation();
    }


    public void initLocation(){
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();

        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);

        //设置定位回调监听
        mLocationClient.setLocationListener(this);

        mLocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        lat = aMapLocation.getLatitude();//获取纬度
        lon = aMapLocation.getLongitude();//获取经度
        cityName = aMapLocation.getCity();//城市名
    }
}
