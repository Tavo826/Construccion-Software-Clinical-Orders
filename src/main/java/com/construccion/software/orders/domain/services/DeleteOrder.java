package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.application.exceptions.BusinessException;
import com.construccion.software.orders.domain.ports.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrder {

    private final OrderPort orderPort;

    public DeleteOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void delete(String id) throws Exception {

        if (orderPort.findById(id) == null) {
            throw new BusinessException("No existe una orden con id: " + id);
        }
        orderPort.delete(id);
    }
}
