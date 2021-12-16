package com.example.build_du_an_ca_nhan_chien_evotek.service.impl;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Role;
import com.example.build_du_an_ca_nhan_chien_evotek.model.RoleName;
import com.example.build_du_an_ca_nhan_chien_evotek.repository.RoleRepository;
import com.example.build_du_an_ca_nhan_chien_evotek.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
