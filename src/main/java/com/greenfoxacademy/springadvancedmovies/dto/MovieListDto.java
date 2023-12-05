package com.greenfoxacademy.springadvancedmovies.dto;

import com.greenfoxacademy.springadvancedmovies.model.Movie;

import java.util.List;

public record MovieListDto(List<Movie> results) {
}
