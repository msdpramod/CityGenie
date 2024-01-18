package org.commerceproject.ecommerceprodcutservice.Service;

import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;

import java.util.List;


public interface CateogryService {
    Cateogry getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);
}
