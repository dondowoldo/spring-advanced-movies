package com.greenfoxacademy.springadvancedmovies.service;

import com.greenfoxacademy.springadvancedmovies.dto.MovieListDto;
import com.greenfoxacademy.springadvancedmovies.util.RetrofitUtil;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class MovieServiceImpl implements MovieService {

    @Value("${AUTH_TOKEN}")
    private String AUTH_TOKEN;
    @Value("${CONTENT_TYPE}")
    private String CONTENT_TYPE;
    private Retrofit retrofit;
    private MovieApi movieApi;

    public MovieServiceImpl(@Value("${BASE_URL}") String baseUrl) {
        retrofit = RetrofitUtil.getRetrofitInstance(baseUrl);
        movieApi = retrofit.create(MovieApi.class);
    }


    @Override
    public MovieListDto getMovies() {
        Call<MovieListDto> allMoviesCall = movieApi.getMovies(AUTH_TOKEN, CONTENT_TYPE);
        return getMovieListDto(allMoviesCall);
    }

    @Override
    public MovieListDto getMovieByName(String title) {
        Call<MovieListDto> moviesByNameCall = movieApi.getMovieByName(AUTH_TOKEN, CONTENT_TYPE, title);
        return getMovieListDto(moviesByNameCall);
    }


    @Nullable
    private MovieListDto getMovieListDto(Call<MovieListDto> moviesCall) {
        MovieListDto movieResponse = null;
        try {
            Response<MovieListDto> response = moviesCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                movieResponse = response.body();
            }
        } catch (IOException e) {
            System.err.println("Unable to fetch movies.\n" + e.getMessage());;
        }
        return movieResponse;
    }
}
