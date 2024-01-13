package org.commerceproject.ecommerceprodcutservice.Repository;

import org.commerceproject.ecommerceprodcutservice.Models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}
