package com.construccion.software.orders.infrastructure.persistence.mapper;


import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.models.OrderMedicine;
import com.construccion.software.orders.domain.models.OrderProcedure;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderDiagnosticAssistanceEntity;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderMedicineEntity;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderProcedureEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<OrderDiagnosticAssistance> toDomainOrderDiagnosticAssistance(List<OrderDiagnosticAssistanceEntity> entity) {

        if (entity == null) {
            return null;
        }

        List<OrderDiagnosticAssistance> orderList = new ArrayList<OrderDiagnosticAssistance>();
        for (OrderDiagnosticAssistanceEntity orderEntity : entity) {
            orderList.add(toDomain(orderEntity));
        }

        return orderList;
    }

    public static List<OrderMedicine> toDomainOrderMedicine(List<OrderMedicineEntity> entity) {

        if (entity == null) {
            return null;
        }

        List<OrderMedicine> orderList = new ArrayList<OrderMedicine>();
        for (OrderMedicineEntity orderEntity : entity) {
            orderList.add(toDomain(orderEntity));
        }

        return orderList;
    }

    public static List<OrderProcedure> toDomainOrderProcedure(List<OrderProcedureEntity> entity) {

        if (entity == null) {
            return null;
        }

        List<OrderProcedure> orderList = new ArrayList<OrderProcedure>();
        for (OrderProcedureEntity orderEntity : entity) {
            orderList.add(toDomain(orderEntity));
        }

        return orderList;
    }

    public static OrderDiagnosticAssistance toDomain(OrderDiagnosticAssistanceEntity entity) {

        if (entity == null) return null;

        OrderDiagnosticAssistance order = new OrderDiagnosticAssistance();
        order.setId(entity.getId());
        order.setOrderNumber(entity.getOrderNumber());
        order.setPatientId(entity.getPatientId());
        order.setEmployeeId(entity.getEmployeeId());
        order.setItemNumber(entity.getItemNumber());
        order.setCreationDate(entity.getCreationDate());
        order.setDiagnosticAssistanceName(entity.getDiagnosticAssistanceName());
        order.setQuantity(entity.getQuantity());
        order.setPrice(entity.getPrice());
        order.setRequiresSpecialistAssistance(entity.isRequiresSpecialistAssistance());
        order.setSpecialistId(entity.getSpecialistId());

        return order;
    }

    public static OrderMedicine toDomain(OrderMedicineEntity entity) {

        if (entity == null) return null;

        OrderMedicine order = new OrderMedicine();
        order.setId(entity.getId());
        order.setOrderNumber(entity.getOrderNumber());
        order.setPatientId(entity.getPatientId());
        order.setEmployeeId(entity.getEmployeeId());
        order.setItemNumber(entity.getItemNumber());
        order.setCreationDate(entity.getCreationDate());
        order.setMedicineName(entity.getMedicineName());
        order.setDose(entity.getDose());
        order.setTreatmentDuration(entity.getTreatmentDuration());
        order.setPrice(entity.getPrice());

        return order;
    }

    public static OrderProcedure toDomain(OrderProcedureEntity entity) {

        if (entity == null) return null;

        OrderProcedure order = new OrderProcedure();
        order.setId(entity.getId());
        order.setOrderNumber(entity.getOrderNumber());
        order.setPatientId(entity.getPatientId());
        order.setEmployeeId(entity.getEmployeeId());
        order.setItemNumber(entity.getItemNumber());
        order.setCreationDate(entity.getCreationDate());
        order.setProcedureName(entity.getProcedureName());
        order.setRepetitionNumber(entity.getRepetitionNumber());
        order.setRepetitionFrequency(entity.getRepetitionFrequency());
        order.setPrice(entity.getPrice());
        order.setRequiresSpecialistAssistance(entity.isRequiresSpecialistAssistance());
        order.setSpecialistId(entity.getSpecialistId());
        order.setBloodPressure(entity.getBloodPressure());
        order.setTemperature(entity.getTemperature());
        order.setPulse(entity.getPulse());
        order.setBloodOxygenLevel(entity.getBloodOxygenLevel());

        return order;
    }

    public static OrderDiagnosticAssistanceEntity toEntity(OrderDiagnosticAssistance order) {

        if (order == null) return null;

        OrderDiagnosticAssistanceEntity entity = new OrderDiagnosticAssistanceEntity();
        entity.setId(order.getId());
        entity.setOrderNumber(order.getOrderNumber());
        entity.setPatientId(order.getPatientId());
        entity.setEmployeeId(order.getEmployeeId());
        entity.setItemNumber(order.getItemNumber());
        entity.setCreationDate(order.getCreationDate());
        entity.setDiagnosticAssistanceName(order.getDiagnosticAssistanceName());
        entity.setQuantity(order.getQuantity());
        entity.setPrice(order.getPrice());
        entity.setRequiresSpecialistAssistance(order.isRequiresSpecialistAssistance());
        entity.setSpecialistId(order.getSpecialistId());

        return entity;
    }

    public static OrderMedicineEntity toEntity(OrderMedicine order) {

        if (order == null) return null;

        OrderMedicineEntity entity = new OrderMedicineEntity();
        entity.setId(order.getId());
        entity.setOrderNumber(order.getOrderNumber());
        entity.setPatientId(order.getPatientId());
        entity.setEmployeeId(order.getEmployeeId());
        entity.setItemNumber(order.getItemNumber());
        entity.setCreationDate(order.getCreationDate());
        entity.setMedicineName(order.getMedicineName());
        entity.setDose(order.getDose());
        entity.setTreatmentDuration(order.getTreatmentDuration());
        entity.setPrice(order.getPrice());

        return entity;
    }

    public static OrderProcedureEntity toEntity(OrderProcedure order) {

        if (order == null) return null;

        OrderProcedureEntity entity = new OrderProcedureEntity();
        entity.setId(order.getId());
        entity.setOrderNumber(order.getOrderNumber());
        entity.setPatientId(order.getPatientId());
        entity.setEmployeeId(order.getEmployeeId());
        entity.setItemNumber(order.getItemNumber());
        entity.setCreationDate(order.getCreationDate());
        entity.setProcedureName(order.getProcedureName());
        entity.setRepetitionNumber(order.getRepetitionNumber());
        entity.setRepetitionFrequency(order.getRepetitionFrequency());
        entity.setPrice(order.getPrice());
        entity.setRequiresSpecialistAssistance(order.isRequiresSpecialistAssistance());
        entity.setSpecialistId(order.getSpecialistId());

        return entity;
    }
}
