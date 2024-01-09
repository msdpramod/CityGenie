package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.FakeStoreProductDTO;
import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private  RestTemplateBuilder restTemplateBuilder;
    private final String ProductRequestURL="https://fakestoreapi.com/products/{id}";
    private final String creatRequestURL="https://fakestoreapi.com/products";
    private  final String updateRequestURL="https://fakestoreapi.com/products/{id}";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity=
                restTemplate.getForEntity(ProductRequestURL, FakeStoreProductDTO.class,id);
        FakeStoreProductDTO fakeStoreProductDTO=responseEntity.getBody();
        // Product product=new Product();
        GenericProductDTO product= new GenericProductDTO();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCategory(fakeStoreProductDTO.getCateogry());
        return product;
    }


    public  GenericProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> responseEntity=
                restTemplate.postForEntity(creatRequestURL, product, GenericProductDTO.class);
        return  responseEntity.getBody();
    }

    @Override
    public GenericProductDTO updateProductById(Long id, GenericProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> responseEntity=
                restTemplate.postForEntity(updateRequestURL, product, GenericProductDTO.class,id);
        return  responseEntity.getBody();
    }
}
