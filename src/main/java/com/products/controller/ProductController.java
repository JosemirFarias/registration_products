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

    @GetMapping
    public ResponseEntity<List<Products>> listProducts() {
        return ResponseEntity.ok(productService.listProducts());
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDto product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Produto adicionado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDto newProduct) {
        return productService.updateProduct(id, newProduct)
                .map(products -> ResponseEntity.ok("Pessoa alterada com sucesso!"))
                .orElseGet(() -> ResponseEntity.status(404).body("Pessoa não encontrada!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
