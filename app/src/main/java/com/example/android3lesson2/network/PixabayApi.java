package com.example.android3lesson2.network;

import com.example.android3lesson2.network.model.PixabayResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    @GET("/api")
    Call<PixabayResponce> getImages(@Query("key") String key, @Query("q") String englishWord);
}
