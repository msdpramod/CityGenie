package org.commerceproject.ecommerceprodcutservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.commerceproject.ecommerceprodcutservice.Models.Price;
@Getter @Setter
public class ProductDTO {
    private String title;

    private String description;

    private String image;
    //            P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans:    m : 1
    private Price price;
}
