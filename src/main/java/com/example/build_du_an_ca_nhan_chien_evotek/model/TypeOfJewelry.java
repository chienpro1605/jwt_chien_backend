package com.example.build_du_an_ca_nhan_chien_evotek.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "typeofjewlry")
public class TypeOfJewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 6,max = 48)
    private String name;

    public TypeOfJewelry() {
    }

    public TypeOfJewelry(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
