package com.example.build_du_an_ca_nhan_chien_evotek.controller;


import com.example.build_du_an_ca_nhan_chien_evotek.model.Jewelry;
import com.example.build_du_an_ca_nhan_chien_evotek.model.TypeOfJewelry;
import com.example.build_du_an_ca_nhan_chien_evotek.service.impl.TypeOfJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/typeofjewelries")
public class TypeOfJewelryController {

    @Autowired
    TypeOfJewelryService typeOfJewelryService;


    // hiển thị tất cả đồ trang sức
    @GetMapping("")
    public ResponseEntity<Iterable<TypeOfJewelry>> findAllTypeOfJewelry() {
        return new  ResponseEntity<>(typeOfJewelryService.findAll(), HttpStatus.OK);
    }

    // thêm mới loại dồ trang sức
    @PostMapping("")
    public ResponseEntity<TypeOfJewelry> saveTypeOfJewelry(@RequestBody TypeOfJewelry typeOfJewelry) {
        typeOfJewelryService.save(typeOfJewelry);
        return new ResponseEntity<>(typeOfJewelryService.save(typeOfJewelry), HttpStatus.CREATED);
    }

    // tìm theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TypeOfJewelry>> findById(@PathVariable Long id) {
        Optional<TypeOfJewelry> typeOfJewelry = typeOfJewelryService.findById(id);
        if (typeOfJewelry.isPresent()) {
            return new ResponseEntity<>(typeOfJewelry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // edit thông tin loại đồ trang sức theo id;
    @PutMapping("/{id}")
    public ResponseEntity<TypeOfJewelry> editById(@PathVariable Long id, @RequestBody TypeOfJewelry typeOfJewelry) {
        Optional<TypeOfJewelry> typeOfJewelryOptional = typeOfJewelryService.findById(id);
        if (!typeOfJewelryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        typeOfJewelry.setId(typeOfJewelryOptional.get().getId());
        typeOfJewelryService.save(typeOfJewelry);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // xóa loại đồ trang sức theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeOfJewelry> deleteById(@PathVariable Long id) {
        Optional<TypeOfJewelry> typeOfJewelryOptional = typeOfJewelryService.findById(id);
        if (!typeOfJewelryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        typeOfJewelryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
