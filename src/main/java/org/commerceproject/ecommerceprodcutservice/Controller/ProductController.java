package org.commerceproject.ecommerceprodcutservice.Controller;


import org.commerceproject.ecommerceprodcutservice.DTOs.FakeStoreProductDTO;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.commerceproject.ecommerceprodcutservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController()
@RequestMapping("/products")

public class ProductController {
    private  final ProductService productService;
    private final RestTemplateBuilder restTemplateBuilder;
    private final String ProductRequestURL="https://fakestoreapi.com/products/{id}";
    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService, RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productService = productService;
    }

    @GetMapping()
    public void getAllProducts() {
        
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity=restTemplate.getForEntity(ProductRequestURL, FakeStoreProductDTO.class,id);
        FakeStoreProductDTO fakeStoreProductDTO=responseEntity.getBody();
        Product product=new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCateogry(fakeStoreProductDTO.getCateogry());

        return product;
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
