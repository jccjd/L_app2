package com.example.lenovo.l_app2.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.l_app2.R;
import com.example.lenovo.l_app2.bean.Video;

import java.util.List;

public class VideoAdapter extends BaseQuickAdapter<Video,BaseViewHolder> {
    public VideoAdapter(int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {

        helper.setText(R.id.recycler_view,item.getName());
        Glide.with(mContext).load(item.getVideoThumbUrl()).into((ImageView)helper.getView(R.id.video_item));
    }



}
