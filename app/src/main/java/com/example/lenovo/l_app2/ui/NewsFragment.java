package com.example.lenovo.l_app2.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.l_app2.R;
import com.example.lenovo.l_app2.adapter.NewsAdapter;
import com.example.lenovo.l_app2.net.HttpResult;
import com.example.lenovo.l_app2.bean.News;
import com.example.lenovo.l_app2.net.RetrofitUtil;
import com.example.lenovo.l_app2.util.Const;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    public static final String TAG = "NewsFragment";
    private RecyclerView mRecyclerView;
    private View mView;
    private NewsAdapter mNewsAdapter;
    private List<News> mNews;
    private List<String> mBannerImages;
    private Banner banner;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_news, container, false);
        initview();
        init();
        return mView;

    }

    private void init() {
        //放图片地址的集合
        mBannerImages = new ArrayList<>();
        for (int i = 0; i < Const.BANNER_IMAGE_URL.length; i++) {
            mBannerImages.add(Const.BANNER_IMAGE_URL[i]);
        }
        //设置要加载的图片集合图片加载器
        banner.setImages(mBannerImages)
                .setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String)path).into(imageView);
            }
        }).start();

        //新闻加载
        mNewsAdapter = new NewsAdapter(R.layout.item_view_news, mNews);
        mNews = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mNewsAdapter);
        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List<News>>> response) {
                mNewsAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });
    }


    private void initview() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
        banner = (Banner) mView.findViewById(R.id.banner);
    }

}
