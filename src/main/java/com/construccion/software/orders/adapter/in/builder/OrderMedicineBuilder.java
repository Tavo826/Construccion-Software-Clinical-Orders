package com.construccion.software.orders.adapter.in.builder;

import com.construccion.software.orders.adapter.in.rest.request.OrderMedicineRequest;
import com.construccion.software.orders.adapter.in.validators.OrderValidator;
import com.construccion.software.orders.domain.models.OrderMedicine;
import org.springframework.stereotype.Component;

@Component
public class OrderMedicineBuilder {

    private final OrderValidator orderValidator;

    public OrderMedicineBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public OrderMedicine build(OrderMedicineRequest request) throws Exception {

        OrderMedicine order = new OrderMedicine();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setItemNumber(orderValidator.itemNumberValidator(request.getItemNumber()));
        order.setMedicineName(orderValidator.medicineNameValidator(request.getMedicineName()));
        order.setDose(orderValidator.doseValidator(request.getDose()));
        order.setTreatmentDuration(orderValidator.treatmentDurationValidator(request.getTreatmentDuration()));
        order.setPrice(orderValidator.priceValidator(request.getPrice()));

        return order;
    }

    public long getEmployeeId(String employeeId) throws Exception {
        return orderValidator.employeeIdValidator(employeeId);
    }
}
