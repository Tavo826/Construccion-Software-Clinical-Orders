package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.application.exceptions.OrderNotFoundException;
import com.construccion.software.orders.domain.models.Order;
import com.construccion.software.orders.domain.ports.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrder {

    private final OrderPort orderPort;

    public UpdateOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public Order update(String id, Order order) throws Exception {

        Order updatedOrder = orderPort.update(id, order);
        if (updatedOrder == null) {
            throw new OrderNotFoundException("no existe una orden con ese id");
        }

        return updatedOrder;
    }
}
