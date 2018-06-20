package com.example.lenovo.l_app2.net;

import com.example.lenovo.l_app2.bean.News;
import com.example.lenovo.l_app2.bean.Video;
import com.example.lenovo.l_app2.util.Const;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class RetrofitUtil {
    public static void getNews(Callback<HttpResult<List<News>>> callback) {
        //填写下列代码
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<HttpResult<List<News>>> call = apiService.getNews();
        call.enqueue(callback);
    }

    public static void getVideo(Callback<HttpResult<List<Video>>> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<HttpResult<List<Video>>> call = apiService.getVideo();
        call.enqueue(callback);
    }
}
