package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Entity @AllArgsConstructor @NoArgsConstructor
public class Cateogry extends BaseModel{
    @Column
    private String Name;

    @OneToMany(mappedBy = "category")
    @Fetch(FetchMode.SELECT)
    private List<Product> Products = new ArrayList<>();
}
