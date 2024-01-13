package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter @Entity @NoArgsConstructor @AllArgsConstructor
public class Price extends BaseModel{
    private int price;
    private String currency;
}
