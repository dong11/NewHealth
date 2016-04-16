package com.dong.huang.healthapp.base;

import android.app.Application;

import com.dong.huang.healthapp.utils.LiteOrmDBUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by dong on 16/4/5.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        LiteOrmDBUtil.createDb(getApplicationContext(), "heath.db");
        PlatformConfig.setWeixin("wxcb98a56f7265f375", "444e6ff310d0a28a0af3c277dc5e03f1");
        PlatformConfig.setSinaWeibo("990358814", "3b764734e2882790a468d30c62e16038");
    }
}
