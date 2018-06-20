package com.example.lenovo.l_app2.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.l_app2.R;
import com.example.lenovo.l_app2.bean.Video;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;


public class VideoActivity extends AppCompatActivity  {
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initView();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String videoName = intent.getStringExtra("video_name");
        String videoUrl = intent.getStringExtra("video_url");
        jzVideoPlayerStandard.setUp(videoUrl,JZVideoPlayer.SCREEN_WINDOW_NORMAL,videoName);
    }

    private void initView() {
        jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.player_video);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
