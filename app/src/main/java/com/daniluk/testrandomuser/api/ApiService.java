package com.daniluk.testrandomuser.api;

import androidx.lifecycle.LiveData;

import com.daniluk.testrandomuser.pojo.ListUsersData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //получить список Users
    @GET("api")
    //public Call<ListUsersData> listUsersData(
    public Call<ListUsersData> listUsersData(
            @Query("results") int results
    );
}
