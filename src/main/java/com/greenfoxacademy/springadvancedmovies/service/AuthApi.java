package com.greenfoxacademy.springadvancedmovies.service;

import com.greenfoxacademy.springadvancedmovies.model.JwtToken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AuthApi {

    @GET("3/authentication/token/new")
    Call<JwtToken> requestToken(
            @Header("Authorization") String AUTH_TOKEN,
            @Header("Content-Type") String CONTENT_TYPE
    );
}
