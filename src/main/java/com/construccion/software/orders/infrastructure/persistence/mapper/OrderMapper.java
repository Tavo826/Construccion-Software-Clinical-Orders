package com.construccion.software.orders.infrastructure.persistence.mapper;

import com.construccion.software.orders.domain.models.Order;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(Order order) {

        if (order == null) return null;

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName(order.getName());

        return orderEntity;
    }

    public static Order toDomain(OrderEntity entity) {

        if (entity == null) return null;

        Order order = new Order();
        order.setId(entity.getId());
        order.setName(entity.getName());

        return order;
    }
}
