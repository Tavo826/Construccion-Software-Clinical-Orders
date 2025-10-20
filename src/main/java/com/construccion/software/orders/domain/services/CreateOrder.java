package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.domain.models.Order;
import com.construccion.software.orders.domain.ports.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class CreateOrder {

    private final OrderPort orderPort;

    public CreateOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public Order create(Order order) {

        return orderPort.save(order);
    }
}
