package com.products.service;

import com.products.model.Products;
import com.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Essa anotação já inicializa os mokis automaticamente.
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    // 1. Cria um mock do repositório (falso).
    @Mock
    private ProductRepository productRepository;

    // 2. Injeta o mock dentro do service que vamos testar.
    @InjectMocks
    private ProductService productService;

    // Testa o metodo que lista os produtos.
    @Test
    public void testListAllProducts() {
        // 4. Cria produtos de exemplo.
        Products products1 =  new Products("Lápis", 4.50, "Ponta 0.4mm");
        Products products2 =  new Products("Caneta", 5.50, "Ponta 0.6mm");

        // 5. Define o comportamento do mock: quando findAll() for chamado, retorne os produtos de exemplo.
        when(productRepository.findAll()).thenReturn(Arrays.asList(products1, products2));

        // 6. Executa o metodo que estamos testando.
        List<Products> resultado = productService.listProducts();

        // 7. Verifica se o resultado tem o tamanho esperado e o conteúdo correto.
        assertEquals(2, resultado.size());
        assertEquals("Lápis", resultado.get(0).getName());
        assertEquals("Caneta", resultado.get(1).getName());

        // 8. Verifica se o metodo findAll() do repositório foi chamado exatamente 1 vez.
        verify(productRepository, times(1)).findAll();

        System.out.println("Tamanho = " + resultado.size());
        System.out.println("Resultado = " + resultado);
    }

    // Testa busca por ID.
    @Test
    public void testGetProductById() {

        Products item1 = new Products("Caderno", 25.00,"Capa dura");

        when(productRepository.findById(1L)).thenReturn(Optional.of(item1));

        Products productResult = productService.getProductById(1L);

        assertNotNull(productResult);
        assertEquals("Caderno", productResult.getName());
        assertEquals(25.00, productResult.getPrice());
        assertEquals("Capa dura", productResult.getDescription());

        verify(productRepository, times(1)).findById(1L);

        System.out.println("Resultado = " + productResult);
    }
}
