package org.commerceproject.ecommerceprodcutservice.Controller;


import org.springframework.web.bind.annotation.*;


@RestController("/products")

public class ProductController {
        @GetMapping()
    public void getAllProducts() {

    }

    @GetMapping("{id}")
    public void getProductById(@PathVariable("id") Long id){

    }
    @PostMapping()
    public void createProduct() {

    }
    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id) {

    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }
}
