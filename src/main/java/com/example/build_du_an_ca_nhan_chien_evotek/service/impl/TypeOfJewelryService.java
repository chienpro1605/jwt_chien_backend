package com.example.build_du_an_ca_nhan_chien_evotek.service.impl;

import com.example.build_du_an_ca_nhan_chien_evotek.model.TypeOfJewelry;
import com.example.build_du_an_ca_nhan_chien_evotek.repository.TypeOfJewelryReporitory;
import com.example.build_du_an_ca_nhan_chien_evotek.service.ITypeOfJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeOfJewelryService implements ITypeOfJewelryService {

    @Autowired
    TypeOfJewelryReporitory typeOfJewelryReporitory;
    @Override
    public Iterable<TypeOfJewelry> findAll() {
        return typeOfJewelryReporitory.findAll();
    }

    @Override
    public Optional<TypeOfJewelry> findById(Long id) {
        return typeOfJewelryReporitory.findById(id);
    }

    @Override
    public TypeOfJewelry save(TypeOfJewelry typeOfJewelry) {
        return typeOfJewelryReporitory.save(typeOfJewelry);
    }

    @Override
    public void delete(Long id) {
        typeOfJewelryReporitory.deleteById(id);
    }
}
