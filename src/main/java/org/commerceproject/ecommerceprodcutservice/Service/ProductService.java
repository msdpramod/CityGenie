package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.DTOs.GenericProductDTO;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    GenericProductDTO getProductById(Long id);

}
