package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Entity @AllArgsConstructor @NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    //@ManyToOne
    @JoinColumn(name = "cateogry")
    private Cateogry cateogry;

    @OneToOne(cascade = {CascadeType.PERSIST})
    //@OneToOne
    private  Price price;


}
