package org.commerceproject.ecommerceprodcutservice.Controller;


import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.commerceproject.ecommerceprodcutservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;



@RestController()
@RequestMapping("/products")

public class ProductController {
    private  final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public void getAllProducts() {
        
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);

    }
    @PostMapping()
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product) {
       return productService.createProduct(product);

    }
    @PutMapping("{id}")
    public GenericProductDTO updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDTO product) {
        return productService.updateProductById(id, product);

    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }
}
