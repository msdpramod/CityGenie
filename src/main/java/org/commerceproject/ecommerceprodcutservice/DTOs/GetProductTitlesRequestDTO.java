package org.commerceproject.ecommerceprodcutservice.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GetProductTitlesRequestDTO {
    private List<String> uuids;
}
