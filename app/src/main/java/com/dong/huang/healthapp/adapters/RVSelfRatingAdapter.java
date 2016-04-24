package com.dong.huang.healthapp.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.MenuBean;
import com.dong.huang.healthapp.beans.ShareBean;
import com.dong.huang.healthapp.beans.homebean.DiseaseBean;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/22
 * @time 下午11:25
 */

public class RVSelfRatingAdapter extends AutoRVAdapter{
    private List<DiseaseBean> list;
    private RecyclerView mRecyclerView;
    private ShareGridViewAdapter mAdapter;
    private Context mContext;
    private List<ShareBean> mBeans;

    public RVSelfRatingAdapter(Context context, List<DiseaseBean> list, List<ShareBean> datas) {
        super(context, list);
        this.list = list;
        mContext = context;
        mBeans = datas;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_selfrating_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getImageView(R.id.iv_selfrating_item_icon).setImageResource(list.get(position).getImgRes());
        holder.getImageView(R.id.iv_selfrating_item_arrow).setImageResource(list.get(position).getArrows());
        holder.getTextView(R.id.tv_selfrating_item_title).setText(list.get(position).getTitle());
        if(list.get(position).isFlag()) {
            mRecyclerView = holder.get(R.id.rv_selfrating_disease);
            mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
            mAdapter = new ShareGridViewAdapter(mContext, mBeans);
            mRecyclerView.setAdapter(mAdapter);
        }
    }


}
