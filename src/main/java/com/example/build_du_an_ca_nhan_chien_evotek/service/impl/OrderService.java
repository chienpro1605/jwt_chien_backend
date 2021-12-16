package com.example.build_du_an_ca_nhan_chien_evotek.service.impl;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Order;
import com.example.build_du_an_ca_nhan_chien_evotek.repository.OrderRepository;
import com.example.build_du_an_ca_nhan_chien_evotek.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
