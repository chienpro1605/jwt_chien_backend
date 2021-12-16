package com.example.build_du_an_ca_nhan_chien_evotek.repository;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Role;
import com.example.build_du_an_ca_nhan_chien_evotek.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
