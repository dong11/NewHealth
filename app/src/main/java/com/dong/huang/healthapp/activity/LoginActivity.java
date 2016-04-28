package com.dong.huang.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import dym.unique.com.springinglayoutlibrary.handler.SpringTouchRippleHandler;
import dym.unique.com.springinglayoutlibrary.handler.SpringingAlphaShowHandler;
import dym.unique.com.springinglayoutlibrary.handler.SpringingNotificationJumpHandler;
import dym.unique.com.springinglayoutlibrary.handler.SpringingNotificationRotateHandler;
import dym.unique.com.springinglayoutlibrary.handler.SpringingTouchDragHandler;
import dym.unique.com.springinglayoutlibrary.handler.SpringingTouchScaleHandler;
import dym.unique.com.springinglayoutlibrary.handler.SpringingTranslationShowHandler;
import dym.unique.com.springinglayoutlibrary.view.SpringingEditText;
import dym.unique.com.springinglayoutlibrary.view.SpringingImageView;
import dym.unique.com.springinglayoutlibrary.view.SpringingTextView;
import dym.unique.com.springinglayoutlibrary.viewgroup.SpringingLinearLayout;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private SpringingLinearLayout sll_mainContainer = null;
    private SpringingImageView simg_avatarMan = null;
    private SpringingEditText sedt_account = null;
    private SpringingEditText sedt_password = null;
    private SpringingTextView stv_regist = null;
    private SpringingTextView stv_login = null;

    private Toolbar mToolbar;

    UMShareAPI mShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();
        initSpringLayout();
        initEvent();
        showViews();
        setStatusBarColor(R.color.color_title_bar);
    }

    private void findView() {
        mToolbar = (Toolbar) findViewById(R.id.login_toolBar);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sll_mainContainer = (SpringingLinearLayout) findViewById(R.id.sll_mainContainer);
        simg_avatarMan = ((SpringingImageView) findViewById(R.id.simg_avatarMan)).setIsCircleImage(true);
        sedt_account = (SpringingEditText) findViewById(R.id.sedt_account);
        sedt_password = (SpringingEditText) findViewById(R.id.sedt_password);
        stv_regist = (SpringingTextView) findViewById(R.id.stv_regist);
        stv_login = (SpringingTextView) findViewById(R.id.stv_login);
    }

    private void initSpringLayout() {
        sll_mainContainer.getSpringingHandlerController().addSpringingHandler(new SpringingTouchDragHandler(this, sll_mainContainer).setBackInterpolator(new OvershootInterpolator()).setBackDuration(SpringingTouchDragHandler.DURATION_LONG).setDirection(SpringingTouchDragHandler.DIRECTOR_BOTTOM | SpringingTouchDragHandler.DIRECTOR_TOP).setMinDistance(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics())));
        sll_mainContainer.getSpringingHandlerController().addSpringingHandler(new SpringTouchRippleHandler(this, sll_mainContainer).setOnlyOnChildren(true, sedt_account, sedt_password));
        simg_avatarMan.getSpringingHandlerController().addSpringingHandler(new SpringingTouchScaleHandler(this, simg_avatarMan));
        stv_regist.getSpringingHandlerController().addSpringingHandler(new SpringTouchRippleHandler(this, stv_regist));
        stv_login.getSpringingHandlerController().addSpringingHandler(new SpringTouchRippleHandler(this, stv_login));
    }

    private void initEvent() {
        stv_regist.setOnClickListener(this);
        stv_login.setOnClickListener(this);
    }

    private void showViews() {
        new SpringingAlphaShowHandler(this, sll_mainContainer).showChildrenSequence(500, 100);
        new SpringingTranslationShowHandler(this, sll_mainContainer).showChildrenSequence(500, 100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stv_regist: {
                if (sedt_account.getText().toString().equals("")) {
                    new SpringingNotificationJumpHandler(this, sedt_account).start(1);
                    return;
                }
                if (sedt_password.getText().toString().equals("")) {
                    new SpringingNotificationJumpHandler(this, sedt_password).start(1);
                    return;
                }
                new SpringingNotificationRotateHandler(this, simg_avatarMan).start(1);
                Toast.makeText(LoginActivity.this, "还未开放,敬请等待！", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.stv_login: {
                Toast.makeText(LoginActivity.this, "还未开放,敬请等待！", Toast.LENGTH_SHORT).show();
//                login();
            }
            break;
            case R.id.simg_avatarMan: {
                Toast.makeText(this, "设置头像", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }

    private void login(){
        mShareAPI = UMShareAPI.get(this);
        SHARE_MEDIA platform = SHARE_MEDIA.SINA;
        mShareAPI.doOauthVerify(this, platform, new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
