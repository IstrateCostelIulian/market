package org.internship.market.controller;


import lombok.extern.slf4j.Slf4j;
import org.internship.market.dto.ProductDTO;
import org.internship.market.services.ProductServices;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/product")
@Slf4j
public class ProductController {

    private final ProductServices productServices;

    private final RawMaterialServices rawMaterialServices;

    @Autowired
    public ProductController(ProductServices productServices, RawMaterialServices rawMaterialServices) {
        this.productServices = productServices;
        this.rawMaterialServices = rawMaterialServices;
    }

    //IN PROGRESS
    @PostMapping
    public ResponseEntity insertProduct(@RequestBody ProductDTO productDTO) {
        boolean isProductAvailableInStock = productServices.checkAvailableStock(productDTO);

        if (!isProductAvailableInStock) {
            return ResponseEntity.ok("No rawMaterials available !");
        } else {

            ProductDTO productByName = productServices.findProductByName(productDTO.getName());
            if (productByName == null) {
                productServices.insertProduct(productDTO);
                return ResponseEntity.ok("Product " + productDTO.getName() + " created !!");
            } else {
                productServices.updateStock(productDTO);
                return ResponseEntity.ok("The product " + productDTO.getName() + " stock is updated");
            }
        }
    }

    @GetMapping(path = "/{name}")
    public ProductDTO getByName(@PathVariable String name) {
        return productServices.findProductByName(name);
    }

    @GetMapping()
    public List<ProductDTO> getAllProducts() {
        return productServices.getAllProducts();
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity delete(@PathVariable String name) {
        if (productServices.findProductByName(name) == null) {
            return ResponseEntity.ok("The product " + name + " doesn't exist !");
        } else {
            productServices.deleteProductByName(name);
            return ResponseEntity.ok("The Product " + name + " was deleted !");
        }
    }

    @PutMapping
    public ResponseEntity updatePrice(@RequestParam String name, @RequestParam double price) {
        if (productServices.findProductByName(name) == null) {
            return ResponseEntity.ok("The product " + name + " doesn't exist !");
        } else {
            productServices.updatePrice(price, name);
            return ResponseEntity.ok("Price for " + name + " was updated !");
        }
    }


}
