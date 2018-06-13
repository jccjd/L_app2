package com.example.lenovo.l_app2.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lenovo.l_app2.R;
import com.example.lenovo.l_app2.adapter.VideoAdapter;
import com.example.lenovo.l_app2.net.HttpResult;
import com.example.lenovo.l_app2.net.RetrofitUtil;
import com.example.lenovo.l_app2.bean.Video;
import com.example.lenovo.l_app2.ui.activity.VideoActivity;
import com.youth.banner.Banner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener {
    public static final String TAG = "VideoFragment";
    private View mView;
    private RecyclerView mRecyclerView;
    private List<Video> mVideos;
    private VideoAdapter mVideoAdapter;
    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_video, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mVideos = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mVideoAdapter);
        mVideoAdapter.setOnItemClickListener(this);
        RetrofitUtil.getVideo(new Callback<HttpResult<List<Video>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Video>>> call, Response<HttpResult<List<Video>>> response) {

            /*    List<Video> videoList = response.body().getData();
                for (Video video : videoList) {
                    Log.i(TAG,video.toString());
                }*/
                mVideoAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<Video>>> call, Throwable t) {

            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(getActivity(), VideoActivity.class);
        startActivity(intent);
    }
}
