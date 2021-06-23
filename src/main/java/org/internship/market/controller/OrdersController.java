package org.internship.market.controller;

import lombok.extern.slf4j.Slf4j;
import org.internship.market.dto.OrdersDTO;
import org.internship.market.dto.ProductDTO;
import org.internship.market.services.OrdersServices;
import org.internship.market.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/orders")
@Slf4j
public class OrdersController {

    private final OrdersServices ordersServices;
    private  final ProductServices productServices;

    @Autowired
    public OrdersController(OrdersServices ordersServices, ProductServices productServices) {
        this.ordersServices = ordersServices;
        this.productServices = productServices;
    }

    @PostMapping
    public ResponseEntity insertOrder(@RequestBody OrdersDTO ordersDTO){
        ProductDTO productDTO = productServices.findProductByName(ordersDTO.getProductName());
        if(productDTO.getStock() == 0 || productDTO.getStock() < ordersDTO.getQuantity()){
            return ResponseEntity.ok("Insufficient stock! \n Only " + productDTO.getStock() + " available!");
        }else{
            ordersServices.insertOrder(ordersDTO);
            return ResponseEntity.ok("Order registered!");
        }
    }

    @GetMapping
    public List<OrdersDTO> getAll(){
        return ordersServices.getAll();
    }

    @DeleteMapping
    public ResponseEntity deleteAll(){
        if(ordersServices.getAll().isEmpty()){
            return ResponseEntity.ok("No orders found!!");
        }else {
            ordersServices.deleteAllOrders();
            return ResponseEntity.ok("All orders deleted!!");
        }
    }

    @GetMapping(path = "/{orderNumber}")
    public OrdersDTO getOrderByNumber(@RequestParam long orderNumber){
        if(ordersServices.findOrderByNumber(orderNumber) == null) {
            ResponseEntity.ok("Order not found !");
            return null;
        }else {
            return ordersServices.findOrderByNumber(orderNumber);
        }
    }
}
