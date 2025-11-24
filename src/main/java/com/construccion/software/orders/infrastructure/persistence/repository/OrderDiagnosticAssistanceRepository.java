package com.construccion.software.orders.infrastructure.persistence.repository;

import com.construccion.software.orders.infrastructure.persistence.entities.OrderDiagnosticAssistanceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDiagnosticAssistanceRepository extends CrudRepository<OrderDiagnosticAssistanceEntity, String> {

    List<OrderDiagnosticAssistanceEntity> findAllByPatientId(long id);
}
