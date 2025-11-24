package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.models.OrderMedicine;
import com.construccion.software.orders.domain.models.OrderProcedure;
import com.construccion.software.orders.domain.ports.OrderDiagnosticAssistancePort;
import com.construccion.software.orders.domain.ports.OrderMedicinePort;
import com.construccion.software.orders.domain.ports.OrderProcedurePort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateOrder {

    private final OrderDiagnosticAssistancePort orderDiagnosticAssistancePort;
    private final OrderMedicinePort orderMedicinePort;
    private final OrderProcedurePort orderProcedurePort;

    public CreateOrder(OrderDiagnosticAssistancePort orderDiagnosticAssistancePort, OrderMedicinePort orderMedicinePort, OrderProcedurePort orderProcedurePort) {
        this.orderDiagnosticAssistancePort = orderDiagnosticAssistancePort;
        this.orderMedicinePort = orderMedicinePort;
        this.orderProcedurePort = orderProcedurePort;
    }

    public OrderDiagnosticAssistance create(OrderDiagnosticAssistance order) {

        order.setCreationDate(LocalDate.now());
        return orderDiagnosticAssistancePort.save(order);
    }

    public OrderMedicine create(OrderMedicine order) {

        order.setCreationDate(LocalDate.now());
        return orderMedicinePort.save(order);
    }

    public OrderProcedure create(OrderProcedure order) {

        order.setCreationDate(LocalDate.now());
        return orderProcedurePort.save(order);
    }
}
