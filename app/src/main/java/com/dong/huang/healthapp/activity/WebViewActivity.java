package com.dong.huang.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.base.BaseActivity;
import com.dong.huang.healthapp.fragments.ShareDialogFragment;
import com.dong.huang.healthapp.utils.URLConfig;

public class WebViewActivity extends BaseActivity {

    private WebView webView;
    private String title;
    private int id;
    private String image;

    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.webView_toolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_share){
                    ShareDialogFragment.newInstance(title, URLConfig.URL_HOME_HOT_ITEM + id, image).show(getSupportFragmentManager(), "share");                }
                return false;
            }
        });

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        id = intent.getIntExtra("id", 0);
        image = intent.getStringExtra("image");

        webView = (WebView) findViewById(R.id.webView);
        mTitle = (TextView) findViewById(R.id.webView_title);
        mTitle.setText(title);

        webView.setWebViewClient(webViewClient);

        webView.loadUrl(URLConfig.URL_HOME_HOT_ITEM + id);

        setStatusBarColor(R.color.color_title_bar);
    }

    WebViewClient webViewClient = new WebViewClient(){

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        if(webView != null){
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
