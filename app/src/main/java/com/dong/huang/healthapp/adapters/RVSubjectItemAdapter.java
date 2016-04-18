package com.dong.huang.healthapp.adapters;

import android.content.Context;
import android.net.Uri;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.homebean.SubjectItemInfo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by dong on 16/4/18.
 */
public class RVSubjectItemAdapter extends AutoRVAdapter{

    private List<SubjectItemInfo.DataBean.ItemsBean> list;

    public RVSubjectItemAdapter(Context context, List<SubjectItemInfo.DataBean.ItemsBean> list) {
        super(context, list);
        this.list = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_home_one_list;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView(R.id.tv_one_title).setText(list.get(position).getTitle());
        ((SimpleDraweeView)holder.get(R.id.iv_one_list)).setImageURI(Uri.parse(list.get(position).getCover_small()));
    }
}
