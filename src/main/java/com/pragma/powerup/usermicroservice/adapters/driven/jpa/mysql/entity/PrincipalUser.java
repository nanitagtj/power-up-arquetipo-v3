package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalUser implements UserDetails {
    private String mail;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String mail, String password, Collection<? extends GrantedAuthority> authorities) {
        this.mail = mail;
        this.password = password;
        this.authorities = authorities;
    }

    public static PrincipalUser build(UserEntity user, List<RoleEntity> roles) {
        List<GrantedAuthority> authorities = roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
        return new PrincipalUser(user.getMail(),
                user.getPassword(), authorities);
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
        return getMail();
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

    public String getMail() {
        return mail;
    }
}

