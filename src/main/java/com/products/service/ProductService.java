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
    public void addProduct(ProductDto dto) {
        Products product = new Products(dto);
        productRepository.save(product);
    }

    //Metodo para atualizar produto buscando por ID
    public Optional<Products> updateProduct(Long id, ProductDto newProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(newProduct.name());
            product.setPrice(newProduct.price());
            product.setDescription(newProduct.description());
            return productRepository.save(product);
        });
    }

    //Metodo para deletar produto por ID
    public String deleteProduct(Long id) {
        Optional<Products> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return "Produto deletado com sucesso!";
        } else {
            return "Produto não encontrado!";
        }
    }
}
