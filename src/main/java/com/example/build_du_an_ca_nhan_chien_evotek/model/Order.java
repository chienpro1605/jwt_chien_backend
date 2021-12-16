package com.example.build_du_an_ca_nhan_chien_evotek.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dayOrder;
    private boolean statusOrder;
    private Long amount;
    private Long totalPrice;

    @ManyToOne
    private User user;

    @ManyToOne
    private Jewelry jewelry;

    public Order() {
    }

    public Order(Long id, Date dayOrder, boolean statusOrder, Long amount, Long totalPrice, User user, Jewelry jewelry) {
        this.id = id;
        this.dayOrder = dayOrder;
        this.statusOrder = statusOrder;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.user = user;
        this.jewelry = jewelry;
    }

    public Long countTotalPrice(Long amount) {
        this.totalPrice = amount*(this.jewelry.getPrice());
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
