package com.construccion.software.orders.domain.ports;

import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;

import java.util.List;

public interface OrderDiagnosticAssistancePort {

    OrderDiagnosticAssistance findById(String id);
    List<OrderDiagnosticAssistance> findByPatientId(long id);
    OrderDiagnosticAssistance save(OrderDiagnosticAssistance order);
    OrderDiagnosticAssistance update(String id, OrderDiagnosticAssistance order);
    void delete(String id);
}
