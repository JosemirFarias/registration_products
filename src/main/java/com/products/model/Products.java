package com.products.model;

import com.products.dto.ProductDto;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description; // Corrigir! valor enviado ao banco foi null.

    public Products() {
    }

    public Products(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //Construtor DTO
    public Products(ProductDto dto) {
        this.name = dto.name();
        this.price = dto.price();
        this.description = dto.description();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
