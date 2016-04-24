package com.dong.huang.healthapp.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.ShareBean;

import java.util.List;

/**
 * Created by dong on 16/3/14.
 */
public class ShareGridViewAdapter extends AutoRVAdapter {

    private List<ShareBean> list;

    public ShareGridViewAdapter(Context context, List<ShareBean> list) {
        super(context, list);
        this.list = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_share_dialog_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getImageView(R.id.share_icon).setImageResource(list.get(position).getImgRes());
        holder.getTextView(R.id.share_name).setText(list.get(position).getName());
    }
}
