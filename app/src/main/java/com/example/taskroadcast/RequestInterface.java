package com.example.taskroadcast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("entries")
    Call<JSONResponse> getJSON();
}
