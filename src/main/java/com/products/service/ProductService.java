package com.products.service;

import com.products.dto.ProductDto;
import com.products.model.Products;
import com.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Métodos para listar todos os produtos ou buscar por id
    public List<Products> listProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    //Metodo para adicionar os produtos no banco de dados
    public Products addProduct(ProductDto dto) {
        Products product = new Products(dto);
        return productRepository.save(product);
    }

    //Metodo para atualizar produto buscando por ID
}
