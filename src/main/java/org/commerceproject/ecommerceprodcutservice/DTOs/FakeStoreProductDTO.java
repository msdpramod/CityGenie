package org.commerceproject.ecommerceprodcutservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
@Getter @Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private int price;
    private Cateogry cateogry;
}
