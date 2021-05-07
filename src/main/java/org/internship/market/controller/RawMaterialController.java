package org.internship.market.controller;

import lombok.extern.slf4j.Slf4j;
import org.internship.market.dto.RawMaterialDTO;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/raw-materials")
@Slf4j
public class RawMaterialController {


    public final RawMaterialServices rawMaterialServices;

    @Autowired
    public RawMaterialController(RawMaterialServices rawMaterialServices) {
        this.rawMaterialServices = rawMaterialServices;
    }


    @PostMapping
    public ResponseEntity insert(@RequestBody RawMaterialDTO rawMaterialDTO) {
        if (rawMaterialServices.findRawMaterialsByName(rawMaterialDTO.getName()) != null) {
            rawMaterialServices.updateRawMaterialStock(rawMaterialDTO.getQuantity(),rawMaterialDTO.getName());
            return ResponseEntity.ok("The material already exits, quantity updated !");
        }
        rawMaterialServices.insertRawMaterials(rawMaterialDTO);
        return ResponseEntity.ok("Material created !");
    }

    @GetMapping
    public List<RawMaterialDTO> geAll(){
        return rawMaterialServices.returnListOfMaterials();
    }
}
