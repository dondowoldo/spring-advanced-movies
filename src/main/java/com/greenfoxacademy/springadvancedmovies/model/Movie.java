package com.greenfoxacademy.springadvancedmovies.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Movie {
    private Long id;
    private boolean adult;
    private String overview;
    private String title;
    private String release_date;
}
