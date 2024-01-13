package org.commerceproject.ecommerceprodcutservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter @Entity
public class Price extends BaseModel{
    private int price;
    private String currency;
}
