package com.dong.huang.healthapp.adapters;

import android.content.Context;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.DrugsSortBean;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/24
 * @time 下午5:24
 */

public class RVDrugsSortAdapter extends AutoRVAdapter{
    private List<DrugsSortBean.DataBean.ItemsBean> mBeans;

    public RVDrugsSortAdapter(Context context, List<DrugsSortBean.DataBean.ItemsBean> list) {
        super(context, list);
        mBeans = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_drugs_query_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView(R.id.tv_drugs_sort_title).setText(mBeans.get(position).getTitle());
        holder.getTextView(R.id.tv_drugs_sort_content).setText(mBeans.get(position).getContent());
    }
}
