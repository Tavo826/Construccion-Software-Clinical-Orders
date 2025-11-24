package com.construccion.software.orders.application.usecases;

import com.construccion.software.orders.domain.models.OrderProcedure;
import com.construccion.software.orders.domain.services.CreateOrder;
import com.construccion.software.orders.domain.services.DeleteOrder;
import com.construccion.software.orders.domain.services.GetOrder;
import com.construccion.software.orders.domain.services.UpdateOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProcedureUseCase {

    private final GetOrder getOrder;
    private final CreateOrder createOrder;
    private final UpdateOrder updateOrder;
    private final DeleteOrder deleteOrder;

    public OrderProcedureUseCase(
            GetOrder getOrder,
            CreateOrder createOrder,
            UpdateOrder updateOrder,
            DeleteOrder deleteOrder) {
        this.getOrder = getOrder;
        this.createOrder = createOrder;
        this.updateOrder = updateOrder;
        this.deleteOrder = deleteOrder;
    }

    public OrderProcedure getOrderById(String id) throws Exception {

        return getOrder.getProcedureById(id);
    }

    public List<OrderProcedure> getOrderProcedureByPatientId(long id) throws Exception {

        return getOrder.getOrderProcedureByPatientId(id);
    }

    public OrderProcedure createOrder(OrderProcedure order) throws Exception {

        return createOrder.create(order);
    }

    public OrderProcedure updateOrder(String id, OrderProcedure order) throws Exception {

        return updateOrder.update(id, order);
    }

    public void deleteOrder(String id) throws Exception {

        deleteOrder.deleteProcedure(id);
    }
}
