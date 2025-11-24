package com.construccion.software.orders.adapter.in.builder;

import com.construccion.software.orders.adapter.in.rest.request.OrderDiagnosticAssistanceRequest;
import com.construccion.software.orders.adapter.in.validators.OrderValidator;
import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import org.springframework.stereotype.Component;

@Component
public class OrderDiagnosticAssistanceBuilder {

    private final OrderValidator orderValidator;

    public OrderDiagnosticAssistanceBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public OrderDiagnosticAssistance build(OrderDiagnosticAssistanceRequest request) throws Exception {

        OrderDiagnosticAssistance order = new OrderDiagnosticAssistance();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setItemNumber(orderValidator.itemNumberValidator(request.getItemNumber()));
        order.setDiagnosticAssistanceName(orderValidator.diagnosticAssistanceNameValidator(request.getDiagnosticAssistanceName()));
        order.setQuantity(orderValidator.quantityValidator(request.getQuantity()));
        order.setPrice(orderValidator.priceValidator(request.getPrice()));

        return order;
    }

    public long getPatientId(String id) throws Exception {
        return orderValidator.employeeIdValidator(id);
    }
}
