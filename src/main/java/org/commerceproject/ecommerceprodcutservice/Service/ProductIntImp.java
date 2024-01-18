package org.commerceproject.ecommerceprodcutservice.Service;

import jakarta.transaction.Transactional;
import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;

import org.commerceproject.ecommerceprodcutservice.Models.Price;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.commerceproject.ecommerceprodcutservice.Repository.CateogryRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.PriceRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductIntImp implements ProductInitalization{
    private final CateogryRepository cateogryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductIntImp(CateogryRepository cateogryRepository,
                         ProductRepository productRepository, PriceRepository priceRepository) {
        this.cateogryRepository = cateogryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;

    }

    @Override @Transactional
    public void initProducts() {
        Price price = new Price();
        price.setPrice(2000);
        price.setCurrency("USD");
        Price savePrice = priceRepository.save(price);

        Cateogry cateogry = new Cateogry();
        cateogry.setName("Electronics");
        Cateogry c = cateogryRepository.save(cateogry);

        Product product = new Product();
        product.setCategory(c);
        product.setDescription("Iphone 13 256GB");
        product.setImage("https://www.google.com/");
        product.setPrice(savePrice);
        product.setTitle("Iphone 13");
        productRepository.save(product);
        //productRepository.deleteById(UUID.fromString("95672ed6-3127-4248-ae33-97a261c0a6f4"));
    }
}
