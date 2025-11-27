package com.construccion.software.orders.adapter.in.builder;

import com.construccion.software.orders.adapter.in.rest.request.OrderProcedureRequest;
import com.construccion.software.orders.adapter.in.validators.OrderValidator;
import com.construccion.software.orders.domain.models.OrderProcedure;
import org.springframework.stereotype.Component;

@Component
public class OrderProcedureBuilder {

    private final OrderValidator orderValidator;

    public OrderProcedureBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public OrderProcedure build(OrderProcedureRequest request) throws Exception {

        OrderProcedure order = new OrderProcedure();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setItemNumber(orderValidator.itemNumberValidator(request.getItemNumber()));
        order.setProcedureName(orderValidator.procedureNameValidator(request.getProcedureName()));
        order.setRepetitionNumber(orderValidator.repetitionNumberValidator(request.getRepetitionNumber()));
        order.setRepetitionFrequency(orderValidator.repetitionFrequencyValidator(request.getRepetitionFrequency()));
        order.setPrice(orderValidator.priceValidator(request.getPrice()));
        order.setRequiresSpecialistAssistance(request.isRequiresSpecialistAssistance());
        order.setSpecialistId(orderValidator.employeeIdValidator(request.getSpecialistId()));
        order.setBloodPressure(orderValidator.bloodPressureValidator(request.getBloodPressure()));
        order.setTemperature(orderValidator.temperatureValidator(request.getTemperature()));
        order.setPulse(orderValidator.pulseValidator(request.getPulse()));
        order.setBloodOxygenLevel(orderValidator.bloodOxygenValidator(request.getBloodOxygenLevel()));

        return order;
    }

    public long getPatientId(String id) throws Exception {
        return orderValidator.patientIdValidator(id);
    }
}
