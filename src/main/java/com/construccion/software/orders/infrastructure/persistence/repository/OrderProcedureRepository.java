package com.construccion.software.orders.infrastructure.persistence.repository;

import com.construccion.software.orders.infrastructure.persistence.entities.OrderProcedureEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProcedureRepository extends CrudRepository<OrderProcedureEntity, String> {

    List<OrderProcedureEntity> findAllByPatientId(long id);
}
