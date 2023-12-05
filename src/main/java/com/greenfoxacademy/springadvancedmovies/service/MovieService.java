package com.greenfoxacademy.springadvancedmovies.service;

import com.greenfoxacademy.springadvancedmovies.dto.MovieListDto;
import org.springframework.stereotype.Service;


@Service
public interface MovieService {

    public MovieListDto getMovies();

    public MovieListDto getMovieByName(String title);
}
