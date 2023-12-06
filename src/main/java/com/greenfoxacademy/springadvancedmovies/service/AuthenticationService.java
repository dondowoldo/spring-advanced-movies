package com.greenfoxacademy.springadvancedmovies.service;

import com.greenfoxacademy.springadvancedmovies.dto.MovieListDto;
import com.greenfoxacademy.springadvancedmovies.model.JwtToken;
import com.greenfoxacademy.springadvancedmovies.model.Movie;
import com.greenfoxacademy.springadvancedmovies.util.RetrofitUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Service
public class AuthenticationService {
    @Value("${AUTH_TOKEN}")
    private String AUTH_TOKEN;
    @Value("${CONTENT_TYPE}")
    private String CONTENT_TYPE;
    private AuthApi authApi;
    private Retrofit retrofit;

    public AuthenticationService(@Value("${BASE_URL}")String baseUrl) {
        retrofit = RetrofitUtil.getRetrofitInstance(baseUrl);
        authApi = retrofit.create(AuthApi.class);
    }


    public JwtToken requestToken() {
        Call<JwtToken> reqTokenCall = authApi.requestToken(AUTH_TOKEN, CONTENT_TYPE);
        try {
            Response<JwtToken> response = reqTokenCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            }
        } catch (IOException e) {
            System.err.println("JWT Token request failed. " + e.getMessage());;
        }
        return null;
    }
}
