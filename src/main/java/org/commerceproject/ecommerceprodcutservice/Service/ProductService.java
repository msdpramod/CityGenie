package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    Product getProductById(Long id);

}
