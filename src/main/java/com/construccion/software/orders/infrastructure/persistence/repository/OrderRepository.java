package com.construccion.software.orders.infrastructure.persistence.repository;

import com.construccion.software.orders.infrastructure.persistence.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, String> {
}
