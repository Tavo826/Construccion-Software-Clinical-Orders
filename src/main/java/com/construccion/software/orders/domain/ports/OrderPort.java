package com.construccion.software.orders.domain.ports;

import com.construccion.software.orders.domain.models.Order;

public interface OrderPort {

    public Order findById(String id);
    public Order save(Order order);
    public Order update(String id, Order order);
    public void delete(String id);
}
