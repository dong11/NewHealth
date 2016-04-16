package com.dong.huang.healthapp.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.base.BaseActivity;
import com.dong.huang.healthapp.beans.homebean.ContentInfo;
import com.dong.huang.healthapp.component.RetrofitSingleton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OneImageActivity extends BaseActivity {

    private TextView mTitle;
    private Toolbar mToolbar;
    private WebView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_image);
        setStatusBarColor(R.color.color_title_bar);

        mContent = (WebView) findViewById(R.id.wv_one_image_content);
        WebSettings webSettings = mContent.getSettings();
        webSettings.setAppCacheEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);


        mTitle = (TextView) findViewById(R.id.tv_one_image_title);
        mToolbar = (Toolbar) findViewById(R.id.content_toolBar);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        String title = getIntent().getStringExtra("title");
        int id = getIntent().getIntExtra("id", 0);
        initData(id, title);
    }

    //http://dxy.com/app/i/columns/article/single?id=5575
    private void initData(int id, final String title){
        RetrofitSingleton.getApiService(this, "http://dxy.com")
                .getOneContentDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ContentInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(ContentInfo contentInfo) {
                        mTitle.setText(title);
                        String content = contentInfo.getData().getItems().get(0).getContent();

                        Document doc_Dis = Jsoup.parse(content);
                        Elements ele_Img = doc_Dis.getElementsByTag("img");
                        if (ele_Img.size() != 0){
                            for (Element e_Img : ele_Img) {
                                e_Img.attr("style", "width:100%");
                            }
                        }
                        String newHtmlContent=doc_Dis.toString();

                        mContent.clearFormData();

                        mContent.loadDataWithBaseURL("", newHtmlContent, "text/html", "utf-8", "");
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if(mContent != null){
            mContent.destroy();
            mContent = null;
        }
        super.onDestroy();
    }
}
