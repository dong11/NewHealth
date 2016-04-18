package com.dong.huang.healthapp.adapters;

import android.content.Context;
import com.dong.huang.healthapp.R;

import java.util.List;

/**
 * Created by dong on 16/4/18.
 */
public class RecyclerMapAdapter extends AutoRVAdapter{
    private List<String> list;

    public RecyclerMapAdapter(Context context, List<String> list) {
        super(context, list);
        this.list = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_store_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView(R.id.map_item_text).setText(list.get(position));
    }
}
