package com.example.build_du_an_ca_nhan_chien_evotek.service;

import com.example.build_du_an_ca_nhan_chien_evotek.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
}
