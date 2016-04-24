package com.dong.huang.healthapp.component;

import com.dong.huang.healthapp.beans.DrugsSortBean;
import com.dong.huang.healthapp.beans.homebean.ContentInfo;
import com.dong.huang.healthapp.beans.homebean.HotInfo;
import com.dong.huang.healthapp.beans.homebean.NutritionInfo;
import com.dong.huang.healthapp.beans.homebean.OneImageInfo;
import com.dong.huang.healthapp.beans.homebean.SubjectInfo;
import com.dong.huang.healthapp.beans.homebean.SubjectItemInfo;
import com.dong.huang.healthapp.beans.homebean.TruthInfo;
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
    String URL_HOME_SUB = "";

    @GET("json/white/applocal/mediafocus")
    Observable<HotInfo> getHomeInfo(@Query("pageSize") String pageSize, @Query("pageNo") String pageNo);

    @GET("http://dxy.com/app/i/columns/article/list")
    Observable<OneImageInfo> getOneImageInfo(@Query("page_index") String pageIndex, @Query("ac") String ac, @Query("items_per_page") String itemsPerPage, @Query("channel_id") String channelId);

    @GET(URLConfig.URL_HOME_ONE_CONTENT)
    Observable<ContentInfo> getOneContentDetail(@Query("id") int id);

    //http://dxy.com/app/i/columns/special/list?page_index=2&ac=d5424fa6-adff-4b0a-8917-4264daf4a348&items_per_page=10
    @GET("http://dxy.com/app/i/columns/special/list")
    Observable<SubjectInfo> getSubjectInfo(@Query("page_index") String pageIndex, @Query("ac") String ac, @Query("items_per_page") String itemsPerPage);

    //http://dxy.com/app/i/columns/article/list?page_index=1&special_id=231&ac=d5424fa6-adff-4b0a-8917-4264daf4a348&items_per_page=10
    @GET("http://dxy.com/app/i/columns/article/list")
    Observable<SubjectItemInfo> getSubjectItemInfo(@Query("page_index") String pageIndex, @Query("ac") String ac, @Query("items_per_page") String itemsPerPage, @Query("special_id") String specialId);

    //http://dxy.com/app/i/columns/article/list?page_index=2&mc=fffffffff0bdd078ffffffff99d603a9&items_per_page=10&channel_id=6
    @GET("http://dxy.com/app/i/columns/article/list")
    Observable<NutritionInfo> getNutritionInfo(@Query("page_index") String pageIndex, @Query("ac") String ac, @Query("items_per_page") String itemsPerPage, @Query("channel_id") String channelId);

    //http://dxy.com/app/i/columns/truth/article/list?page_index=1&ac=d5424fa6-adff-4b0a-8917-4264daf4a348&items_per_page=10
    @GET("http://dxy.com/app/i/columns/truth/article/list")
    Observable<TruthInfo> getTruthInfo(@Query("page_index") String pageIndex, @Query("ac") String ac, @Query("items_per_page") String itemsPerPage);

    @GET("http://dxy.com/app/i/feed/drug/list")
    Observable<DrugsSortBean> getDrugsSortBean(@Query("ac") String ac);

}
