package com.construccion.software.orders.domain.ports;

import com.construccion.software.orders.domain.models.OrderProcedure;

import java.util.List;

public interface OrderProcedurePort {

    OrderProcedure findById(String id);
    List<OrderProcedure> findByPatientId(long id);
    OrderProcedure save(OrderProcedure order);
    OrderProcedure update(String id, OrderProcedure order);
    void delete(String id);
}
