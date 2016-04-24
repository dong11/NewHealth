package com.dong.huang.healthapp.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.amap.api.services.core.PoiItem;
import com.dong.huang.healthapp.R;

import java.util.List;

/**
 * Created by dong on 16/4/18.
 */
public class RecyclerMapAdapter extends AutoRVAdapter {
    private List<PoiItem> list;
    private Context mContext;

    public RecyclerMapAdapter(Context context, List<PoiItem> list) {
        super(context, list);
        this.list = list;
        mContext = context;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_store_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.getTextView(R.id.map_item_text).setText(String.valueOf(position + 1));
        holder.getTextView(R.id.map_item_tv_title).setText(list.get(position).getTitle());
        holder.getTextView(R.id.map_item_tv_mils).setText(list.get(position).getDistance() + "m");
        holder.getTextView(R.id.map_item_tv_adr).setText(list.get(position).getSnippet());
        holder.getTextView(R.id.map_item_tv_tel).setText(list.get(position).getTel());

        if (TextUtils.isEmpty(list.get(position).getTel())) {
            holder.getImageView(R.id.map_item_iv_call).setVisibility(View.INVISIBLE);
        } else {
            holder.getImageView(R.id.map_item_iv_call).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strMobile = list.get(position).getTel().split(";")[0];
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + strMobile));
                    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
