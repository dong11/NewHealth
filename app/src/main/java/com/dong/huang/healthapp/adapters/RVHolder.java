package com.dong.huang.healthapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dong on 16/4/6.
 */
public class RVHolder  extends RecyclerView.ViewHolder {
    private ViewHolder viewHolder;
    public RVHolder(View itemView) {
        super(itemView);
        viewHolder = ViewHolder.getViewHolder(itemView);
    }
    public ViewHolder getViewHolder() {
        return viewHolder;
    }
}
