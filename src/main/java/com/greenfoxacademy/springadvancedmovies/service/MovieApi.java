package com.greenfoxacademy.springadvancedmovies.service;

import com.greenfoxacademy.springadvancedmovies.dto.MovieListDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MovieApi {
    @GET("/3/discover/movie")
    Call<MovieListDto> getMovies(
            @Header("Authorization") String AUTH_TOKEN,
            @Header("Content-Type") String CONTENT_TYPE
    );

    

}
