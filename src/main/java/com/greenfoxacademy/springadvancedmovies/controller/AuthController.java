package com.greenfoxacademy.springadvancedmovies.controller;

import com.greenfoxacademy.springadvancedmovies.service.AuthenticationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    private AuthenticationService authService;

    public AuthController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> requestToken() {
        String token = authService.requestToken().getRequest_token();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                "https://www.themoviedb.org/authenticate/" + token + "?redirect_to=http://localhost:8080/success");
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/success")
    public String test() {

        return "session_id goes here";
    }
}
