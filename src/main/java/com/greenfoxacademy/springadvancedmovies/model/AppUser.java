package com.greenfoxacademy.springadvancedmovies.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AppUser {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
}
