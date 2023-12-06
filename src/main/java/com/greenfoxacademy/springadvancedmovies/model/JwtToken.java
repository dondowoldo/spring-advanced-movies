package com.greenfoxacademy.springadvancedmovies.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class JwtToken {
    private boolean success;
    private String expires_at;
    private String request_token;
}
