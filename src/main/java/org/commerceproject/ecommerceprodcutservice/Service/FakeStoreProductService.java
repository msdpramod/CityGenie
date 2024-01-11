package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;

import org.commerceproject.ecommerceprodcutservice.ThirdParty.FakeStoreProductDTO;
import org.commerceproject.ecommerceprodcutservice.ThirdParty.FakeStoreProductServiceClient;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;



@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductDTO convertFakeStoreProductIntoGenericProduct(FakeStoreProductDTO fakeStoreProductDto) {

        GenericProductDTO product = new GenericProductDTO();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCateogry());

        return product;
    }
    @Override
    public GenericProductDTO getProductById(Long id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDTO updateProductById(Long id, GenericProductDTO product) {
        return convertFakeStoreProductIntoGenericProduct (fakeStoreProductServiceClient.updateProductById(id, product));
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> genericProductDTOS= new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:fakeStoreProductServiceClient.getAllProducts()){
            genericProductDTOS.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDTO));
        }
        return genericProductDTOS;
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        return convertFakeStoreProductIntoGenericProduct( fakeStoreProductServiceClient.deleteProductById(id));
    }
}
