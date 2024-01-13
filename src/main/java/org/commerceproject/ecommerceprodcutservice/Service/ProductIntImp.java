package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
import org.commerceproject.ecommerceprodcutservice.Models.Order;
import org.commerceproject.ecommerceprodcutservice.Models.Price;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.commerceproject.ecommerceprodcutservice.Repository.CateogryRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.OrderRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.PriceRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductIntImp implements ProductInitalization{
    private final CateogryRepository cateogryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    private final OrderRepository orderRepository;

    public ProductIntImp(CateogryRepository cateogryRepository,
                         ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository) {
        this.cateogryRepository = cateogryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void initProducts() {


        Cateogry cateogry = new Cateogry();
        cateogry.setName("Electronics");
        Cateogry c = cateogryRepository.save(cateogry);
        Price price =  new Price();
        price.setPrice(2000);
        price.setCurrency("USD");
        Price savePrice = priceRepository.save(price);
        Product product = new Product();
        product.setTitle("Iphone 13");
        product.setDescription("Iphone 13 256GB");
        product.setImage("https://www.google.com/");
        product.setPrice(savePrice);


        product.setCateogry(c);
        productRepository.save(product);
    }
}
