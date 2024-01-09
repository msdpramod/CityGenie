package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;

import java.util.List;


public interface ProductService {
    GenericProductDTO getProductById(Long id);
    GenericProductDTO createProduct(GenericProductDTO product);
    GenericProductDTO updateProductById(Long id, GenericProductDTO product);

    List<GenericProductDTO> getAllProducts();
    GenericProductDTO deleteProductById(Long id);
}
