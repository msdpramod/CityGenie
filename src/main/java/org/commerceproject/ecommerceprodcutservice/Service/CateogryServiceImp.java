package org.commerceproject.ecommerceprodcutservice.Service;


import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.commerceproject.ecommerceprodcutservice.Repository.CateogryRepository;
import org.commerceproject.ecommerceprodcutservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CateogryServiceImp implements CateogryService {
    private final CateogryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CateogryServiceImp(CateogryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cateogry getCategory(String uuid) {
        Optional<Cateogry> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Cateogry c = categoryOptional.get();

        return c;
    }

    public List<String> getProductTitles(List<String> categoryUUIDs) {
        List<UUID> uuids = new ArrayList<>();

        for (String uuid: categoryUUIDs) {
            uuids.add(UUID.fromString(uuid));
        }
//
//        List<Category> categories = categoryRepository.findAllById(uuids);
//
//
//        List<String> titles = new ArrayList<>();
//
//        categories.forEach(
//                category -> {
//                    category.getProducts().forEach(
//                            product -> {
//                                titles.add(product.getTitle());
//                            }
//                    );
//                }
//        );
//
//
//        return titles;

        List<Cateogry> categories = categoryRepository.findAllById(uuids);

        List<Product> products = productRepository.findAllByCategoryIn(categories);

        List<String> titles = new ArrayList<>();

        for (Product p: products) {
            titles.add(p.getTitle());
        }

        return titles;
    }
}