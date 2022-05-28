package com.example.paginationandsortingwithspringdatajpa.controller;

import com.example.paginationandsortingwithspringdatajpa.entity.Product;
import com.example.paginationandsortingwithspringdatajpa.payload.ApiResponse;
import com.example.paginationandsortingwithspringdatajpa.payload.ProductDto;
import com.example.paginationandsortingwithspringdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProduct(){
        List<Product> product = productService.getProduct();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        ApiResponse apiResponse = productService.addProduct(productDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }

    @GetMapping("/{field}")
    public ResponseEntity<?> productWithSorting(@PathVariable String field){
        List<Product> products = productService.productWithSorting(field);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<?> productWithSorting(@PathVariable int offset,@PathVariable int pageSize){
        Page<Product> products = productService.productWIthPagination(offset, pageSize);
        return ResponseEntity.ok(products);
    }

}
