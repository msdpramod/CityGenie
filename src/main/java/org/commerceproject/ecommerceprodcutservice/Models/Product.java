package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Entity @AllArgsConstructor @NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    @ManyToOne
    private Cateogry cateogry;

    @OneToOne
    private  Price price;


}
