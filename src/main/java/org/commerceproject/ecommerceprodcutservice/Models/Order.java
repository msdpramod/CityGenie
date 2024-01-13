package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity(name= "orders") @Getter @Setter
public class Order extends BaseModel{
    private String OrderName;
    @ManyToMany
    private List<Product> products;

}
