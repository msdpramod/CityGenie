package org.commerceproject.ecommerceprodcutservice.DTOs;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private int price;
    private String cateogry;
}
