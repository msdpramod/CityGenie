package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    @Override
    public GenericProductDTO getProductById(Long id) {
        return null;
    }
}
