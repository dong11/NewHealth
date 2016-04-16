package com.dong.huang.healthapp.adapters;

import android.content.Context;
import android.net.Uri;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.homebean.HotData;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by dong on 16/4/6.
 */
public class RecyclerHotAdapter extends AutoRVAdapter {

    private List<HotData> list;

    public RecyclerHotAdapter(Context context, List<HotData> list) {
        super(context, list);
        this.list = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_home_hot_list;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView(R.id.tv_title_hot_list).setText(list.get(position).getTitle());
        holder.getTextView(R.id.tv_summary_hot_list).setText(list.get(position).getSummary());
        ((SimpleDraweeView)holder.get(R.id.iv_hot_list)).setImageURI(Uri.parse(list.get(position).getH5Img()));
    }
}
