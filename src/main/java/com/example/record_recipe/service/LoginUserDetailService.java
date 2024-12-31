package com.example.record_recipe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.record_recipe.repository.UserRepository;
import com.example.record_recipe.entity.UserEntity;
import com.example.record_recipe.config.LoginUserDetails;

@Service
public class LoginUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public LoginUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> _user = userRepository.findByEmail(email);
        return _user.map(user -> new LoginUserDetails(user))
            .orElseThrow(() -> new UsernameNotFoundException("not found email=" + email));
    }
}
