package org.commerceproject.ecommerceprodcutservice.ThirdParty;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.commerceproject.ecommerceprodcutservice.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceClient {
    private final RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.url}")
    private  String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;
    private final String specificProductRequestUrl ;
    private final String productRequestsBaseUrl;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl  = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";

    }




    public FakeStoreProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity=
                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDTO.class,id);
        FakeStoreProductDTO fakeStoreProductDTO=responseEntity.getBody();
        if (fakeStoreProductDTO==null){
            throw new NotFoundException(" product not found with id "+id);
        }
        return fakeStoreProductDTO;
    }


    public FakeStoreProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity=
                restTemplate.postForEntity(productRequestsBaseUrl, product, FakeStoreProductDTO.class);
        return  responseEntity.getBody();
    }


    public FakeStoreProductDTO updateProductById(Long id, GenericProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        // HttpEntity<GenericProductDTO> request= restTemplate.patchForObject(specificProductRequestUrl, product, HttpEntity.class);
        HttpEntity<GenericProductDTO> request =
                new HttpEntity<>(product);


        ResponseEntity<GenericProductDTO> productCreateResponse =
                restTemplate
                        .exchange(specificProductRequestUrl,
                                HttpMethod.PUT,
                                request,
                                GenericProductDTO.class,id);
        FakeStoreProductDTO updatedProduct = new FakeStoreProductDTO();
        updatedProduct.setId(productCreateResponse.getBody().getId());
        updatedProduct.setTitle(productCreateResponse.getBody().getTitle());
        updatedProduct.setDescription(productCreateResponse.getBody().getDescription());
        updatedProduct.setImage(productCreateResponse.getBody().getImage());
        updatedProduct.setPrice((int) productCreateResponse.getBody().getPrice());
        updatedProduct.setCateogry(productCreateResponse.getBody().getCategory());
        return updatedProduct;

    }



    public List<FakeStoreProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        List<FakeStoreProductDTO> prd
                = restTemplate.getForObject(specificProductRequestUrl, List.class);
        return prd;
    }


    public FakeStoreProductDTO deleteProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(
                productRequestsBaseUrl,
                HttpMethod.DELETE,
                null,
                FakeStoreProductDTO.class,
                id);
//          you can use this code instead of the above code
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
//        ResponseEntity<FakeStoreProductDTO> response =restTemplate.execute(deleteRequestURL, HttpMethod.DELETE, requestCallback, responseExtractor, id);
//        FakeStoreProductDTO fakeStoreProductDTO=response.getBody();
//        // Product product=new Product();
//        GenericProductDTO product= new GenericProductDTO();
//        product.setId(fakeStoreProductDTO.getId());
//        product.setTitle(fakeStoreProductDTO.getTitle());
//        product.setDescription(fakeStoreProductDTO.getDescription());
//        product.setImage(fakeStoreProductDTO.getImage());
//        product.setPrice(fakeStoreProductDTO.getPrice());
//        product.setCategory(fakeStoreProductDTO.getCateogry());
//        return product;

        return response.getBody();

    }
}
