package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.CascadeType;
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
    @Column
    private String name;
    @OneToMany(mappedBy = "cateogry",cascade = {CascadeType.PERSIST})
    private List<Product> products;
}
