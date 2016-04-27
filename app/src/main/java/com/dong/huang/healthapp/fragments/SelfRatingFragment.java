package com.dong.huang.healthapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.ShareBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/22
 * @time 下午11:25
 * 健康自测页面
 */
public class SelfRatingFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout item1;
    private RelativeLayout item2;
    private RelativeLayout item3;
    private RelativeLayout item4;
    private RelativeLayout item5;
    private RelativeLayout item6;
    private RelativeLayout item7;
    private RelativeLayout item8;
    private RelativeLayout item9;

    private ArrayList<ShareBean> mBeans1;
    private ArrayList<ShareBean> mBeans2;
    private ArrayList<ShareBean> mBeans3;
    private ArrayList<ShareBean> mBeans4;
    private ArrayList<ShareBean> mBeans5;
    private ArrayList<ShareBean> mBeans6;
    private ArrayList<ShareBean> mBeans7;
    private ArrayList<ShareBean> mBeans8;
    private ArrayList<ShareBean> mBeans9;

    private boolean isShow = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selfrating, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        item1 = (RelativeLayout) view.findViewById(R.id.item1);
        item2 = (RelativeLayout) view.findViewById(R.id.item2);
        item3 = (RelativeLayout) view.findViewById(R.id.item3);
        item4 = (RelativeLayout) view.findViewById(R.id.item4);
        item5 = (RelativeLayout) view.findViewById(R.id.item5);
        item6 = (RelativeLayout) view.findViewById(R.id.item6);
        item7 = (RelativeLayout) view.findViewById(R.id.item7);
        item8 = (RelativeLayout) view.findViewById(R.id.item8);
        item9 = (RelativeLayout) view.findViewById(R.id.item9);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);
        item6.setOnClickListener(this);
        item7.setOnClickListener(this);
        item8.setOnClickListener(this);
        item9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item1:
                showFragment("item1", R.id.item_container1, mBeans1);
                break;
            case R.id.item2:
                showFragment("item2", R.id.item_container2, mBeans2);
                break;
            case R.id.item3:
                showFragment("item3", R.id.item_container3, mBeans3);
                break;
            case R.id.item4:
                showFragment("item4", R.id.item_container4, mBeans4);
                break;
            case R.id.item5:
                showFragment("item5", R.id.item_container5, mBeans5);
                break;
            case R.id.item6:
                showFragment("item6", R.id.item_container6, mBeans6);
                break;
            case R.id.item7:
                showFragment("item7", R.id.item_container7, mBeans7);
                break;
            case R.id.item8:
                showFragment("item8", R.id.item_container8, mBeans8);
                break;
            case R.id.item9:
                showFragment("item9", R.id.item_container9, mBeans9);
                break;
            default:
                break;
        }
    }

    private void showFragment(String item, int container, ArrayList<ShareBean> datas){
        hideAll();
        if(getChildFragmentManager().findFragmentByTag(item) != null) {
            Fragment fragment = getChildFragmentManager().findFragmentByTag(item);
            if(isShow) {
                getChildFragmentManager().beginTransaction().hide(fragment).commit();
            } else {
                getChildFragmentManager().beginTransaction().show(fragment).commit();
            }
            isShow = !isShow;
        } else {
            getChildFragmentManager().beginTransaction().add(container, DiseaseFragment.newInstance(datas), item).commit();
            isShow = true;
        }
    }

    private void hideAll(){
        List<Fragment> list = getChildFragmentManager().getFragments();
        if(list == null || list.size() == 0)
            return;
        for(int i = 0; i < list.size();i++){
            getChildFragmentManager().beginTransaction().hide(list.get(i)).commit();
        }
    }

    private void initData(){

        mBeans1 = new ArrayList<>();
        mBeans2 = new ArrayList<>();
        mBeans3 = new ArrayList<>();
        mBeans4 = new ArrayList<>();
        mBeans5 = new ArrayList<>();
        mBeans6 = new ArrayList<>();
        mBeans7 = new ArrayList<>();
        mBeans8 = new ArrayList<>();
        mBeans9 = new ArrayList<>();

        mBeans1.add(new ShareBean("感冒", R.drawable.s_ganmao, 22));
        mBeans1.add(new ShareBean("失眠", R.drawable.s_sm, 724));
        mBeans1.add(new ShareBean("便秘", R.drawable.s_bianmi, 205));
        mBeans1.add(new ShareBean("咳嗽", R.drawable.s_kesou, 742));
        mBeans1.add(new ShareBean("胃肠不适", R.drawable.s_weiyan, 182));
        mBeans1.add(new ShareBean("腹泻", R.drawable.s_fuxie, 165));
        mBeans1.add(new ShareBean("痔疮", R.drawable.jibing469, 469));
        mBeans1.add(new ShareBean("鼻炎", R.drawable.jibing300, 300));
        mBeans1.add(new ShareBean("头痛", R.drawable.jibing381, 381));
        mBeans1.add(new ShareBean("咽炎", R.drawable.jibing298, 298));
        mBeans1.add(new ShareBean("口腔溃疡", R.drawable.jibing372, 372));
        mBeans1.add(new ShareBean("缺铁性贫血", R.drawable.jibing510, 510));
        mBeans1.add(new ShareBean("痤疮", R.drawable.jibing343, 343));
        mBeans1.add(new ShareBean("扁桃体炎", R.drawable.jibing303, 303));
        mBeans1.add(new ShareBean("牙痛", R.drawable.jibing447, 447));

        mBeans2.add(new ShareBean("月经不调", R.drawable.yjbt, 231));
        mBeans2.add(new ShareBean("阴道炎", R.drawable.smbj, 123));
        mBeans2.add(new ShareBean("更年期综合征", R.drawable.gnq, 230));
        mBeans2.add(new ShareBean("痛经", R.drawable.tongj, 725));
        mBeans2.add(new ShareBean("黄褐斑", R.drawable.jibing490, 490));
        mBeans2.add(new ShareBean("宫颈炎", R.drawable.jibing691, 691));
        mBeans2.add(new ShareBean("慢性盆腔炎", R.drawable.jibing701, 701));

        mBeans3.add(new ShareBean("补肾益精", R.drawable.xgnbj, 723));
        mBeans3.add(new ShareBean("前列腺炎", R.drawable.qlxy, 233));
        mBeans3.add(new ShareBean("脱发", R.drawable.tuofa, 242));

        mBeans4.add(new ShareBean("儿童感冒", R.drawable.jibing610, 610));
        mBeans4.add(new ShareBean("儿童厌食", R.drawable.jibing629, 629));
        mBeans4.add(new ShareBean("儿童食积", R.drawable.jibing634, 634));
        mBeans4.add(new ShareBean("儿童咳喘", R.drawable.jibing671, 671));

        mBeans5.add(new ShareBean("慢性胃炎", R.drawable.jibing635, 635));
        mBeans5.add(new ShareBean("胃溃疡", R.drawable.jibing652, 652));

        mBeans6.add(new ShareBean("足癣(脚气)", R.drawable.jibing428, 428));
        mBeans6.add(new ShareBean("皮炎湿疹", R.drawable.jibing421, 421));
        mBeans6.add(new ShareBean("荨麻疹", R.drawable.jibing411, 411));

        mBeans7.add(new ShareBean("腰肌劳损", R.drawable.jibing568, 568));
        mBeans7.add(new ShareBean("肩周炎", R.drawable.jibing588, 588));
        mBeans7.add(new ShareBean("颈椎病", R.drawable.jibing597, 597));

        mBeans8.add(new ShareBean("视疲劳", R.drawable.jibing546, 546));
        mBeans8.add(new ShareBean("急性结膜炎", R.drawable.jibing525, 525));

        mBeans9.add(new ShareBean("尿路感染", R.drawable.jibing660, 660));

        getChildFragmentManager().beginTransaction().add(R.id.item_container1, DiseaseFragment.newInstance(mBeans1), "item1").commit();
  }
}
