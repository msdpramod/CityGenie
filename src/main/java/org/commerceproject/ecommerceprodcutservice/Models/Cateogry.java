package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @Entity @AllArgsConstructor @NoArgsConstructor
public class Cateogry extends BaseModel{
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "cateogry")
    private List<Product> products;
}
