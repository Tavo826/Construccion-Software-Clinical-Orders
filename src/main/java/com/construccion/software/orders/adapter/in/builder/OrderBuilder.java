package com.construccion.software.orders.adapter.in.builder;

import com.construccion.software.orders.adapter.in.validators.OrderValidator;
import com.construccion.software.orders.domain.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderBuilder {

    private final OrderValidator orderValidator;

    public OrderBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public Order build(String name) throws Exception {
        Order order = new Order();
        order.setName(orderValidator.nameValidator(name));

        return order;
    }

    public String getId(String id) throws Exception {

        return orderValidator.idValidator(id);
    }
}
