package com.example.build_du_an_ca_nhan_chien_evotek.service;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Role;
import com.example.build_du_an_ca_nhan_chien_evotek.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
