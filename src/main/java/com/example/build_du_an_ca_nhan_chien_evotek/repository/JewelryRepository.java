package com.example.build_du_an_ca_nhan_chien_evotek.repository;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
}
