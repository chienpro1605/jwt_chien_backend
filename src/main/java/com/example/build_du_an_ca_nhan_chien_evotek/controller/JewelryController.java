package com.example.build_du_an_ca_nhan_chien_evotek.controller;


import com.example.build_du_an_ca_nhan_chien_evotek.model.Jewelry;
import com.example.build_du_an_ca_nhan_chien_evotek.service.impl.JewelryService;
import com.example.build_du_an_ca_nhan_chien_evotek.service.impl.TypeOfJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jewelrys")
public class JewelryController {
    @Autowired
    JewelryService jewelryService;

    @Autowired
    TypeOfJewelryService typeOfJewelryService;

//    hiển thị tất cả đồ trang sức
    @GetMapping("")
    public ResponseEntity<Iterable<Jewelry>> findAllJewelry() {
        return new  ResponseEntity<>(jewelryService.findAll(), HttpStatus.OK);
    }
// thêm mới dồ trang sức
    @PostMapping("")
    public ResponseEntity<Jewelry> saveJewelry(@RequestBody Jewelry jewelry) {
        jewelryService.save(jewelry);
        return new ResponseEntity<>(jewelryService.save(jewelry), HttpStatus.CREATED);
    }
// tìm theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Jewelry>> findById(@PathVariable Long id) {
        Optional<Jewelry> jewelryOptional = jewelryService.findById(id);
        if (jewelryOptional.isPresent()) {
            return new ResponseEntity<>(jewelryOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
// edit thông tin đồ trang sức
    @PutMapping("/{id}")
    public ResponseEntity<Jewelry> editById(@PathVariable Long id, @RequestBody Jewelry jewelry) {
        Optional<Jewelry> jewelryOptional = jewelryService.findById(id);
        if (!jewelryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        jewelry.setId(jewelryOptional.get().getId());
        jewelryService.save(jewelry);
        return new ResponseEntity<>(HttpStatus.OK);
    }
// xóa đồ trang sức theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Jewelry> deleteById(@PathVariable Long id) {
        Optional<Jewelry> jewelryOptional = jewelryService.findById(id);
        if (!jewelryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        jewelryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
