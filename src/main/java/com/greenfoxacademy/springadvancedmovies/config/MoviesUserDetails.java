package com.greenfoxacademy.springadvancedmovies.config;

import com.greenfoxacademy.springadvancedmovies.model.AppUser;
import com.greenfoxacademy.springadvancedmovies.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesUserDetails implements UserDetailsService {

    private UserRepository userRepository;

    public MoviesUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> optUser = userRepository.findByEmail(email);
        String username;
        String password;
        List<GrantedAuthority> authorities = new ArrayList<>();

            if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user: " + email);
        } else {
            AppUser user = optUser.get();
            username = user.getEmail();
            password = user.getPassword();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return new User(username, password, authorities);
    }
}
