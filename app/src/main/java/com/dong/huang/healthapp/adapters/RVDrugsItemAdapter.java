package com.dong.huang.healthapp.adapters;

import android.content.Context;

import com.dong.huang.healthapp.R;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/28
 * @time 下午10:27
 */

public class RVDrugsItemAdapter extends AutoRVAdapter {
    private List<String> mList;

    public RVDrugsItemAdapter(Context context, List<String> list) {
        super(context, list);
        mList = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.activity_query_drugs_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView(R.id.tv_drugs_item_title).setText(mList.get(position));
    }
}
