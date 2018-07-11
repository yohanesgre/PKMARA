package com.example.pkmara.models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String BASE_URL = "http://localhost";
    @GET("menulist")
    Call<MenuObject> getMenuList();
}
