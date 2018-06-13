package com.example.lenovo.l_app2.adapter;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.l_app2.R;
import com.example.lenovo.l_app2.bean.Video;
import wseemann.media.FFmpegMediaMetadataRetriever;

import java.util.List;

public class VideoAdapter extends BaseQuickAdapter<Video,BaseViewHolder> {
    public VideoAdapter(int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {

        helper.setText(R.id.recycler_view,item.getName());


    }
    private Bitmap getVideoThumb(String url){
        FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
        mmr.setDataSource(url);
        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST);
        Bitmap b = mmr.getFrameAtTime();
        mmr.release();
        return  b;
    }
}
