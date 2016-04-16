package com.dong.huang.healthapp.fragments;


import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.adapters.ShareGridViewAdapter;
import com.dong.huang.healthapp.beans.ShareBean;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;
import java.util.List;


public class ShareDialogFragment extends DialogFragment {

    private ShareGridViewAdapter adapter;
    private RecyclerView gridView;
    private List<ShareBean> list;

    private String mTitle;
    private String mUrl;
    private String mImage;

    public ShareDialogFragment() {
    }

    public static ShareDialogFragment newInstance(String title, String url, String image) {
        ShareDialogFragment fragment = new ShareDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("url", url);
        bundle.putString("image", image);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString("title");
        mUrl = getArguments().getString("url");
        mImage = getArguments().getString("image");
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity(), R.style.CustomShareDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
        dialog.setContentView(R.layout.fragment_share_dialog);
        dialog.setCanceledOnTouchOutside(true);

        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
        return dialog;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = (RecyclerView) view.findViewById(R.id.share_gridview);
        gridView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));

        list = new ArrayList<>();
        list.add(new ShareBean("QQ好友", R.drawable.install_qq));
        list.add(new ShareBean("新浪微博", R.drawable.install_sina));
        list.add(new ShareBean("微信好友", R.drawable.install_weixin));
        list.add(new ShareBean("朋友圈", R.drawable.install_pengyouquan));
        adapter = new ShareGridViewAdapter(getActivity(), list);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (list.get(position).getImgRes()) {
                    case R.drawable.install_qq:
                        Toast.makeText(getActivity(), "QQ分享", Toast.LENGTH_SHORT).show();
                        break;
                    case R.drawable.install_sina:
                        new ShareAction(getActivity())
                                .setPlatform(SHARE_MEDIA.SINA)
                                .setCallback(umShareListener)
                                .withText(mTitle)
                                .withMedia(new UMImage(getActivity(), mImage))
                                .withTargetUrl(mUrl)
                                .share();
                        break;
                    case R.drawable.install_weixin:

                        new ShareAction(getActivity())
                                .setPlatform(SHARE_MEDIA.WEIXIN)
                                .setCallback(umShareListener)
//                                .withText("hello umeng video")
                                .withText(mTitle)
                                .withMedia(new UMImage(getActivity(), mImage))
                                .withTargetUrl(mUrl)
                                .share();
                        break;
                    case R.drawable.install_pengyouquan:
                        new ShareAction(getActivity())
                                .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                                .setCallback(umShareListener)
                                .withText("hello umeng video")
                                .withTargetUrl("http://www.baidu.com")
                                .share();
                        break;
                    default:
                        break;

                }
            }
        });

        gridView.setAdapter(adapter);
    }


    UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            dismiss();
            Toast.makeText(getActivity(), platform + "分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            dismiss();
            Toast.makeText(getActivity(), platform + "分享失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(), platform + "分享取消", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }
}
