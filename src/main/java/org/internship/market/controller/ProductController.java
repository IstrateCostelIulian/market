package org.internship.market.controller;


import org.internship.market.dto.ProductDTO;
import org.internship.market.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @PostMapping("/product")
    public ResponseEntity insertProduct(@RequestBody ProductDTO productDTO){
        if(productServices.findProductByName(productDTO.getName()) == null){
            productServices.insertProduct(productDTO);
            return ResponseEntity.ok("Product " + productDTO.getName() + " created !!");
        }else{
            return ResponseEntity.ok("The product " + productDTO.getName() + " already exists");
        }
    }
    
    @GetMapping(path = "/getAllProducts")
    public List<ProductDTO> getAllProducts(){
        return productServices.getAllProducts();
    }
    
}
