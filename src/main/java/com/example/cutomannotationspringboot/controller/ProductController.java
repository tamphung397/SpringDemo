package com.example.cutomannotationspringboot.controller;

import com.example.cutomannotationspringboot.annotation.TamValidateRequest;
import com.example.cutomannotationspringboot.bean.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    @PostMapping("/create")
    @TamValidateRequest
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(product);
    }
}
