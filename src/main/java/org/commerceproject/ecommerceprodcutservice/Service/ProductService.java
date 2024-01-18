package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.commerceproject.ecommerceprodcutservice.Exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDTO getProductById(Long id) throws NotFoundException;
    GenericProductDTO createProduct(GenericProductDTO product);
    GenericProductDTO updateProductById(Long id, GenericProductDTO product);

    List<GenericProductDTO> getAllProducts();
    GenericProductDTO deleteProductById(Long id);


}
