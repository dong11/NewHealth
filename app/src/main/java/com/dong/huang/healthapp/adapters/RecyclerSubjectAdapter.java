package com.dong.huang.healthapp.adapters;

import android.content.Context;
import android.net.Uri;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.homebean.SubjectInfo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by dong on 16/4/18.
 */
public class RecyclerSubjectAdapter extends AutoRVAdapter{

    private List<SubjectInfo.DataBean.ItemsBean> list;
    private Context context;

    public RecyclerSubjectAdapter(Context context, List<SubjectInfo.DataBean.ItemsBean> list) {
        super(context, list);
        this.list = list;
        this.context = context;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_subject_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView(R.id.tv_subject).setText(list.get(position).getName());
        SimpleDraweeView simpleDraweeView = holder.get(R.id.sdv_subject);
//        simpleDraweeView.setLayoutParams(new FrameLayout.MarginLayoutParams(ScreenUtils.getScreenWidth(context), 160));
        simpleDraweeView.setImageURI(Uri.parse(list.get(position).getCover()));
    }
}
