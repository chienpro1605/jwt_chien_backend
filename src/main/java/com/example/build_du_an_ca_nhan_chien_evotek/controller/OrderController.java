package com.example.build_du_an_ca_nhan_chien_evotek.controller;

import com.example.build_du_an_ca_nhan_chien_evotek.model.Order;
import com.example.build_du_an_ca_nhan_chien_evotek.service.impl.EmailService;
import com.example.build_du_an_ca_nhan_chien_evotek.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    EmailService emailService;
    @Autowired
    OrderService orderService;

    //    hiển thị tất cả các order
    @GetMapping("")
    public ResponseEntity<Iterable<Order>> findAllOrder() {
        return new  ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    // đặt hàng
    @PostMapping("")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        order.setTotalPrice(order.countTotalPrice(order.getAmount()));
        orderService.save(order);
        String userEmail = order.getUser().getEmail();
        emailService.sendSimpleMessage(userEmail, "leducchien468@gmail.com", "Confirm order",
                "order successful! ");
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    // tìm đơn đặt hàng theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()) {
            return new ResponseEntity<>(orderOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // edit đơn đặt hàng

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id,@RequestBody Order order) {
        Optional<Order> optionalOrder = orderService.findById(id);
        if(!optionalOrder.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.setTotalPrice(order.countTotalPrice(order.getAmount()));
        order.setId(optionalOrder.get().getId());
        order.setUser(optionalOrder.get().getUser());
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // xóa đơn hàng theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable Long id) {
        Optional<Order> orders = orderService.findById(id);
        if (!orders.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
