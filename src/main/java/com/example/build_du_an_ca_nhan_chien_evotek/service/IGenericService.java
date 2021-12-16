package com.example.build_du_an_ca_nhan_chien_evotek.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save (T t);
    void delete(Long id);
}
