package com.construccion.software.orders.adapter.in.builder;

import com.construccion.software.orders.adapter.in.validators.OrderValidator;
import org.springframework.stereotype.Component;

@Component
public class OrderBuilder {

    private final OrderValidator orderValidator;

    public OrderBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public String getId(String id) throws Exception {
        return orderValidator.idValidator(id);
    }
}
