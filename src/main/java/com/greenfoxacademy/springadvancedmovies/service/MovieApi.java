package com.greenfoxacademy.springadvancedmovies.service;

import com.greenfoxacademy.springadvancedmovies.dto.MovieListDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("/3/discover/movie")
    Call<MovieListDto> getMovies(
            @Header("Authorization") String AUTH_TOKEN,
            @Header("Content-Type") String CONTENT_TYPE
    );

    @GET("/3/search/movie")
    Call<MovieListDto> getMovieByName(
            @Header("Authorization") String AUTH_TOKEN,
            @Header("Content-Type") String CONTENT_TYPE,
            @Query("query") String title
    );


}
