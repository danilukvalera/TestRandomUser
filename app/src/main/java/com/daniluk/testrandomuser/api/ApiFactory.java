package com.daniluk.testrandomuser.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private String BASE_URL = "https://randomuser.me/";
    private Retrofit retrofit;
    private static ApiService apiService = null;

    ApiFactory(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static ApiService createApiService(){
        if(apiService == null){
            apiService = new ApiFactory().retrofit.create(ApiService.class);
        }
        return apiService;
    }

    public static void createLog(String message){
        Log.d("RANDOMUSER", message);
    }
}
