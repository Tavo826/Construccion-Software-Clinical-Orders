package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.application.exceptions.OrderNotFoundException;
import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.models.OrderMedicine;
import com.construccion.software.orders.domain.models.OrderProcedure;
import com.construccion.software.orders.domain.ports.OrderDiagnosticAssistancePort;
import com.construccion.software.orders.domain.ports.OrderMedicinePort;
import com.construccion.software.orders.domain.ports.OrderProcedurePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrder {

    private final OrderDiagnosticAssistancePort orderDiagnosticAssistancePort;
    private final OrderMedicinePort orderMedicinePort;
    private final OrderProcedurePort orderProcedurePort;

    public GetOrder(OrderDiagnosticAssistancePort orderDiagnosticAssistancePort, OrderMedicinePort orderMedicinePort, OrderProcedurePort orderProcedurePort) {
        this.orderDiagnosticAssistancePort = orderDiagnosticAssistancePort;
        this.orderMedicinePort = orderMedicinePort;
        this.orderProcedurePort = orderProcedurePort;
    }

    public List<OrderProcedure> getOrderProcedureByPatientId(long id) {

        return orderProcedurePort.findByPatientId(id);
    }

    public List<OrderMedicine> getOrderMedicineByPatientId(long id) {

        return orderMedicinePort.findByPatientId(id);
    }

    public List<OrderDiagnosticAssistance> getOrderDiagnosticAssistanceByPatientId(long id) {

        return orderDiagnosticAssistancePort.findByPatientId(id);
    }

    public OrderDiagnosticAssistance getDiagnosticAssistanceById(String id) throws Exception {

        return orderDiagnosticAssistancePort.findById(id);
    }

    public OrderMedicine getMedicineById(String id) throws Exception {

        return orderMedicinePort.findById(id);
    }

    public OrderProcedure getProcedureById(String id) throws Exception {

        return orderProcedurePort.findById(id);
    }
}
