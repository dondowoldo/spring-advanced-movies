package com.greenfoxacademy.springadvancedmovies.repository;

import com.greenfoxacademy.springadvancedmovies.model.AppUser;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
