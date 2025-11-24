package com.construccion.software.orders.domain.services;

import com.construccion.software.orders.domain.ports.OrderDiagnosticAssistancePort;
import com.construccion.software.orders.domain.ports.OrderMedicinePort;
import com.construccion.software.orders.domain.ports.OrderProcedurePort;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrder {

    private final OrderDiagnosticAssistancePort orderDiagnosticAssistancePort;
    private final OrderMedicinePort orderMedicinePort;
    private final OrderProcedurePort orderProcedurePort;

    public DeleteOrder(OrderDiagnosticAssistancePort orderDiagnosticAssistancePort, OrderMedicinePort orderMedicinePort, OrderProcedurePort orderProcedurePort) {
        this.orderDiagnosticAssistancePort = orderDiagnosticAssistancePort;
        this.orderMedicinePort = orderMedicinePort;
        this.orderProcedurePort = orderProcedurePort;
    }

    public void deleteDiagnosticAssistance(String id) throws Exception {

        orderDiagnosticAssistancePort.delete(id);
    }

    public void deleteMedicine(String id) throws Exception {

        orderMedicinePort.delete(id);
    }

    public void deleteProcedure(String id) throws Exception {

        orderProcedurePort.delete(id);
    }
}
