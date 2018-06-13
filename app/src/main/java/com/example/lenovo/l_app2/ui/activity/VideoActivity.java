package com.example.lenovo.l_app2.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.l_app2.R;
import com.example.lenovo.l_app2.bean.Video;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private JZVideoPlayerStandard mJZVideoPlayerStandard;
    private Video mVideo;
    private ImageView mFavoriteImageView;
    public void onEventBusReceiver(Video video){
        mVideo=video;
        mJZVideoPlayerStandard.setUp(mVideo.getUrl()
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, mVideo.getName());

        Glide.with(this)
                .load(video.getVideoThumbUrl())
                .into(mJZVideoPlayerStandard.thumbImageView);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initView();
        init();
    }

    private void init() {
        mFavoriteImageView.setOnClickListener(this);
    }

    private void initView() {
        mJZVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.player_video);
        mFavoriteImageView=(ImageView)findViewById(R.id.iv_favorite);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.iv_favorite:
//                DBUtil.getInstance(this).insert(mVideo);
//                mFavoriteImageView.setImageResource(R.drawable.ico_favorite_selected);
//                break;
//        }
    }

}
