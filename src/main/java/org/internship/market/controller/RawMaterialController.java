package org.internship.market.controller;

import org.internship.market.dto.RawMaterialDTO;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawMaterialController {


    public  final RawMaterialServices rawMaterialServices;

    @Autowired
    public RawMaterialController(RawMaterialServices rawMaterialServices) {
        this.rawMaterialServices = rawMaterialServices;
    }

    // IN PROGRESS
    @PostMapping(path = "/insertRawMaterials")
    public ResponseEntity insertRawMaterials(@RequestBody RawMaterialDTO rawMaterialDTO){
        if(rawMaterialServices.findRawMaterialsByName(rawMaterialDTO.getName()) != null){
            rawMaterialServices.updateRawMaterialsPrice(rawMaterialDTO.getPrice(),rawMaterialDTO.getName());
            return ResponseEntity.ok("The material already exits, quantity updated");
        }
        return null;
    }
}
