package org.commerceproject.ecommerceprodcutservice.Controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ProductController {
    @GetMapping("/products")
    public void getAllProducts() {

    }

    @GetMapping("/products/{id}")
    public void getProductById() {

    }

    public void createProduct() {

    }

    public void updateProductById() {

    }
    @DeleteMapping("/products/{id}")
    public void deleteProductById() {

    }
}
