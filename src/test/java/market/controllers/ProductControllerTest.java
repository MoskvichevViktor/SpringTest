package market.controllers;

import market.entities.Product;
import market.services.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.List;

class ProductControllerTest {

    @Test
    void shouldRetrieveProducts_whenHttpRequestComing_andThereAreExistingRecords() {
        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.findAll()).thenReturn(List.of(new Product()));
        ProductController productController = new ProductController(productService);
        Assertions.assertThat(productController.findAll()).isNotEmpty();
    }
}