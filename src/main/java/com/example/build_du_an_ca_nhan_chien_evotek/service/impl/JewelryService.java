package com.example.build_du_an_ca_nhan_chien_evotek.service.impl;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Jewelry;
import com.example.build_du_an_ca_nhan_chien_evotek.repository.JewelryRepository;
import com.example.build_du_an_ca_nhan_chien_evotek.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JewelryService implements IJewelryService {

    @Autowired
    JewelryRepository jewelryRepository;
    @Override
    public Iterable<Jewelry> findAll() {
        return jewelryRepository.findAll();
    }

    @Override
    public Optional<Jewelry> findById(Long id) {
        return jewelryRepository.findById(id);
    }

    @Override
    public Jewelry save(Jewelry jewelry) {
        return jewelryRepository.save(jewelry);
    }

    @Override
    public void delete(Long id) {
        jewelryRepository.deleteById(id);
    }
}
