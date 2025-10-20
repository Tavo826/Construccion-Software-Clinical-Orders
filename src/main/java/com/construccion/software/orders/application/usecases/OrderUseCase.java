package com.construccion.software.orders.application.usecases;

import com.construccion.software.orders.domain.models.Order;
import com.construccion.software.orders.domain.services.CreateOrder;
import com.construccion.software.orders.domain.services.DeleteOrder;
import com.construccion.software.orders.domain.services.GetOrder;
import com.construccion.software.orders.domain.services.UpdateOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderUseCase {

    private final GetOrder getOrder;
    private final CreateOrder createOrder;
    private final UpdateOrder updateOrder;
    private final DeleteOrder deleteOrder;

    public OrderUseCase(
            GetOrder getOrder,
            CreateOrder createOrder,
            UpdateOrder updateOrder,
            DeleteOrder deleteOrder) {
        this.getOrder = getOrder;
        this.createOrder = createOrder;
        this.updateOrder = updateOrder;
        this.deleteOrder = deleteOrder;
    }

    public Order getOrderById(String id) throws Exception {

        return getOrder.getById(id);
    }

    public Order createOrder(Order order) {

        return createOrder.create(order);
    }

    public Order updateOrder(String id, Order order) throws Exception {

        return updateOrder.update(id, order);
    }

    public void deleteOrder(String id) throws Exception {

        deleteOrder.delete(id);
    }
}
