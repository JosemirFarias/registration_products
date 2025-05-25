package com.products.controller;

import com.products.dto.ProductDto;
import com.products.model.Products;
import com.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Products>> listProducts() {
        return ResponseEntity.ok(productService.listProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDto product) {
       productService.addProduct(product);
       return ResponseEntity.ok("Produto adicionado com sucesso");
    }
}
