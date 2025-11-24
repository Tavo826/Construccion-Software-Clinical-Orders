package com.construccion.software.orders.domain.ports;

import com.construccion.software.orders.domain.models.OrderMedicine;

import java.util.List;

public interface OrderMedicinePort {

    OrderMedicine findById(String id);
    List<OrderMedicine> findByPatientId(long id);
    OrderMedicine save(OrderMedicine order);
    OrderMedicine update(String id, OrderMedicine order);
    void delete(String id);
}
