package com.greenfoxacademy.springadvancedmovies;


import com.greenfoxacademy.springadvancedmovies.dto.MovieListDto;
import com.greenfoxacademy.springadvancedmovies.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public MovieListDto test() {
        return movieService.getMovies();
    }

    @GetMapping("/search")
    public MovieListDto search(String title) {
        return movieService.getMovieByName(title);
    }
}
