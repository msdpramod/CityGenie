package org.commerceproject.ecommerceprodcutservice.Repository;

import org.commerceproject.ecommerceprodcutservice.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
