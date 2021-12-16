package com.example.build_du_an_ca_nhan_chien_evotek.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "jewelrys")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 6,max = 48)
    private String name;
    @Size(min = 6,max = 48)
    private String brand;
    private Long price;
    private String image;
    @Size(min = 6,max = 100)
    private String description;
    @ManyToOne
    private TypeOfJewelry typeOfJewelry;

    public Jewelry() {
    }

    public Jewelry(Long id, String name, String brand, String image, String description, TypeOfJewelry typeOfJewelry) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.image = image;
        this.description = description;
        this.typeOfJewelry = typeOfJewelry;
    }
}
