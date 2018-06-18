package com.example.lenovo.l_app2.net;

import com.example.lenovo.l_app2.bean.News;
import com.example.lenovo.l_app2.bean.Video;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {
    //填写代码
    @GET("getNews.php")
    Call<HttpResult<List<News>>> getNews();

    @GET("getideo.php")
    Call<HttpResult<List<Video>>> getVideo();
}
