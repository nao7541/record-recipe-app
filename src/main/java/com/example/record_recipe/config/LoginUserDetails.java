package com.example.record_recipe.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.record_recipe.entity.UserEntity;

import java.util.Collection;
import java.util.Arrays;

import groovy.transform.EqualsAndHashCode;

@EqualsAndHashCode
public class LoginUserDetails implements UserDetails {
    private final String email;
    private final String password;
    private final String name;
    private final Collection <? extends GrantedAuthority> authorities;

    public LoginUserDetails(UserEntity user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(role -> new SimpleGrantedAuthority(role))
                .toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
