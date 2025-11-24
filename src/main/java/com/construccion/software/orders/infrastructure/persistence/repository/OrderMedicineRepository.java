package com.construccion.software.orders.infrastructure.persistence.repository;

import com.construccion.software.orders.infrastructure.persistence.entities.OrderMedicineEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderMedicineRepository extends CrudRepository<OrderMedicineEntity, String> {

    List<OrderMedicineEntity> findAllByPatientId(long id);
}
