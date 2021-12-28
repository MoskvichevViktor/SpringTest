package market.controllers;

import market.entities.Product;
import market.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc
//@webMvcTest
public class ProductControllerIntegrationTest {

    //@Autowired
    //private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductService productService;


    @Test
    void shouldDo() {
        BDDMockito.given(productService.findAll())
                .willReturn(List.of(new Product(1L, "Product #1")));
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("/products", List.class);
        Assertions.assertThat(responseEntity.getStatusCode().isEqualTo(HttpStatus.OK));
        Assertions.assertThat(responseEntity.getBody().isNotEmpty());
    }
}
