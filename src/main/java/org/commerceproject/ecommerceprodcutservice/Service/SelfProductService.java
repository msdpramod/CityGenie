package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDTO getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return null;
    }

    @Override
    public GenericProductDTO updateProductById(Long id, GenericProductDTO product) {
        return null;
    }
    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        return null;
    }
}
