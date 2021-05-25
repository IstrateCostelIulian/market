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
        if (rawMaterialServices.findRawMaterialsByName(rawMaterialDTO.getName()) == null) {
            rawMaterialServices.insertRawMaterials(rawMaterialDTO);
            return ResponseEntity.ok("Material created !");
        } else {
            rawMaterialServices.updateRawMaterialStock(rawMaterialDTO.getQuantity(), rawMaterialDTO.getName());
            double costToAdd = rawMaterialDTO.getQuantity() * rawMaterialDTO.getPrice();
            rawMaterialServices.updateCostFromPrice(costToAdd);
            return ResponseEntity.ok("The material already exits, quantity updated !");
        }
    }

    @GetMapping
    public List<RawMaterialDTO> getAll() {
        return rawMaterialServices.getAllMaterials();
    }

    @GetMapping(path = "/{name}")
    public RawMaterialDTO getMaterialByName(@PathVariable String name) {
        return rawMaterialServices.findRawMaterialsByName(name);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity delete(@PathVariable String name) {
        if (rawMaterialServices.findRawMaterialsByName(name) == null) {
            return ResponseEntity.ok("Material  doesn't exist");
        } else {
            rawMaterialServices.deleteRawMaterialsByName(name);
            return ResponseEntity.ok("Material deleted");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        if (rawMaterialServices.getAllMaterials() == null) {
            return ResponseEntity.ok("No materials to be deleted");
        } else {
            rawMaterialServices.deleteAllProducts();
            return ResponseEntity.ok("All materials have been deleted!");
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestParam double price, @RequestParam String name) {
        if (rawMaterialServices.findRawMaterialsByName(name) == null) {
            return ResponseEntity.ok("Material not found !");
        } else {
            rawMaterialServices.updateRawMaterialsPrice(price, name);
            return ResponseEntity.ok("Price updated");
        }
    }
}
