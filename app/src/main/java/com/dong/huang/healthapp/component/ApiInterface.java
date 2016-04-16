package com.dong.huang.healthapp.component;

import com.dong.huang.healthapp.beans.homebean.ContentInfo;
import com.dong.huang.healthapp.beans.homebean.HotInfo;
import com.dong.huang.healthapp.beans.homebean.OneImageInfo;
import com.dong.huang.healthapp.utils.URLConfig;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by dong on 16/4/3.
 */
public interface ApiInterface {

    String URL_HOME_HOT = "http://app.wy.guahao.com";
    String URL_HOME_IMAGE= "http://dxy.com/app/i/columns";

    @GET("json/white/applocal/mediafocus")
    Observable<HotInfo> getHomeInfo(@Query("pageSize") String pageSize, @Query("pageNo") String pageNo);

    @GET("http://dxy.com/app/i/columns/article/list")
    Observable<OneImageInfo> getOneImageInfo(@Query("page_index") String pageIndex, @Query("ac") String ac, @Query("items_per_page") String itemsPerPage, @Query("channel_id") String channelId);

    @GET(URLConfig.URL_HOME_ONE_CONTENT)
    Observable<ContentInfo> getOneContentDetail(@Query("id") int id);
}
