package org.commerceproject.ecommerceprodcutservice.Controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/products")

public class ProductController {
        @GetMapping()
    public void getAllProducts() {

    }

    @GetMapping("{id}")
    public void getProductById() {

    }

    public void createProduct() {

    }

    public void updateProductById() {

    }
    @DeleteMapping("{id}")
    public void deleteProductById() {

    }
}
