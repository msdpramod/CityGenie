package org.commerceproject.ecommerceprodcutservice.Models;


import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import java.util.UUID;


@MappedSuperclass @Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

}


