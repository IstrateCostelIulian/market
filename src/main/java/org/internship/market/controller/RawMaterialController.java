package org.internship.market.controller;

import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RawMaterialController {

    final private RawMaterialServices services;

    @Autowired
    public RawMaterialController(RawMaterialServices services) {
        this.services = services;
    }

    @GetMapping(value = "/raw/ping")
    public @ResponseBody
    String ping() {
        return "hello";
    }

    @GetMapping(value = "/raw")
    public List<RawMaterialEntity> allMaterials() {
        System.out.println("allMaterials");
        return services.listOfMaterials();
    }
/*
    @GetMapping(value = "{id}")
    public RawMaterialEntity findById(@RequestParam String id){
        return services.get
    }
*/
}
