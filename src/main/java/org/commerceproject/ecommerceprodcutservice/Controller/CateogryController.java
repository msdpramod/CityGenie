package org.commerceproject.ecommerceprodcutservice.Controller;

import jdk.jfr.Category;
import org.commerceproject.ecommerceprodcutservice.DTOs.GetProductTitlesRequestDTO;
import org.commerceproject.ecommerceprodcutservice.DTOs.ProductDTO;
import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
import org.commerceproject.ecommerceprodcutservice.Models.Product;
import org.commerceproject.ecommerceprodcutservice.Repository.CateogryRepository;
import org.commerceproject.ecommerceprodcutservice.Service.CateogryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("cateogries")
public class CateogryController {
    private CateogryService categoryService;

    public CateogryController(CateogryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public List<ProductDTO> getCategory(@PathVariable("uuid") String uuid) {
        List<Product> products = categoryService.getCategory(uuid).getProducts();

        List<ProductDTO> productDtos = new ArrayList<>();

        for (Product product: products) {
            ProductDTO productDto = new ProductDTO();
            productDto.setDescription(product.getDescription());
            productDto.setTitle(product.getTitle());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
//            productDto.se
        }

        return productDtos;
    }

    @GetMapping("/titles/")
    public List<String> getProductTitles(@RequestBody GetProductTitlesRequestDTO requestDto) {

        List<String> uuids = requestDto.getUuids();

        return categoryService.getProductTitles(uuids);
    }
}