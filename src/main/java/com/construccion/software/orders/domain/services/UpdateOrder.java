package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.application.exceptions.OrderNotFoundException;
import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.models.OrderMedicine;
import com.construccion.software.orders.domain.models.OrderProcedure;
import com.construccion.software.orders.domain.ports.OrderDiagnosticAssistancePort;
import com.construccion.software.orders.domain.ports.OrderMedicinePort;
import com.construccion.software.orders.domain.ports.OrderProcedurePort;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrder {

    private final OrderDiagnosticAssistancePort orderDiagnosticAssistancePort;
    private final OrderMedicinePort orderMedicinePort;
    private final OrderProcedurePort orderProcedurePort;

    public UpdateOrder(OrderDiagnosticAssistancePort orderDiagnosticAssistancePort, OrderMedicinePort orderMedicinePort, OrderProcedurePort orderProcedurePort) {
        this.orderDiagnosticAssistancePort = orderDiagnosticAssistancePort;
        this.orderMedicinePort = orderMedicinePort;
        this.orderProcedurePort = orderProcedurePort;
    }

    public OrderDiagnosticAssistance update(String id, OrderDiagnosticAssistance order) throws Exception {

        OrderDiagnosticAssistance updatedOrder = orderDiagnosticAssistancePort.update(id, order);
        if (updatedOrder == null) {
            throw new OrderNotFoundException("no existe una orden con ese id");
        }

        return updatedOrder;
    }

    public OrderMedicine update(String id, OrderMedicine order) throws Exception {

        OrderMedicine updatedOrder = orderMedicinePort.update(id, order);
        if (updatedOrder == null) {
            throw new OrderNotFoundException("no existe una orden con ese id");
        }

        return updatedOrder;
    }

    public OrderProcedure update(String id, OrderProcedure order) throws Exception {

        OrderProcedure updatedOrder = orderProcedurePort.update(id, order);
        if (updatedOrder == null) {
            throw new OrderNotFoundException("no existe una orden con ese id");
        }

        return updatedOrder;
    }
}
