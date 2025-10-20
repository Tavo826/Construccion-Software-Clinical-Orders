package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.application.exceptions.OrderNotFoundException;
import com.construccion.software.orders.domain.models.Order;
import com.construccion.software.orders.domain.ports.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class GetOrder {

    private final OrderPort orderPort;

    public GetOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public Order getById(String id) throws Exception {

        Order order = orderPort.findById(id);
        if (order == null) {
            throw new OrderNotFoundException("no existe una orden con ese id");
        }

        return order;
    }
}
