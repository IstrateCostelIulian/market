package org.internship.market.controller;

import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RawMaterialController {

    @GetMapping("/ping")
    public String allMaterials() {
        return "hello";
    }
/*
    final private RawMaterialServices services;

    @Autowired
    public RawMaterialController(RawMaterialServices services) {
        this.services = services;
    }

    @GetMapping("/materials")
    public List<RawMaterialEntity> allMaterials() {
        System.out.println("allMaterials");
        return services.listOfMaterials();
    }
*/
}
