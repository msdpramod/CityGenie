package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.commerceproject.ecommerceprodcutservice.Repository.CateogryRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductIntImp implements ProductInitalization{
    private final CateogryRepository cateogryRepository;
    private final ProductRepository productRepository;

    public ProductIntImp(CateogryRepository cateogryRepository, ProductRepository productRepository) {
        this.cateogryRepository = cateogryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void initProducts() {
        Cateogry cateogry = new Cateogry();
        cateogry.setName("Electronics");
        Cateogry c = cateogryRepository.save(cateogry);

        Product product = new Product();
        product.setTitle("Iphone 13");
        product.setDescription("Iphone 13 256GB");
        product.setImage("https://www.google.com/");
        product.setPrice(2000);

        product.setCateogry(c);
        productRepository.save(product);
    }
}
