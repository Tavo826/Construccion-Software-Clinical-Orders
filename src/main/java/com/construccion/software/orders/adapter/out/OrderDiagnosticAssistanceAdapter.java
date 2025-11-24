package com.construccion.software.orders.adapter.out;

import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.ports.OrderDiagnosticAssistancePort;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderDiagnosticAssistanceEntity;
import com.construccion.software.orders.infrastructure.persistence.mapper.OrderMapper;
import com.construccion.software.orders.infrastructure.persistence.repository.OrderDiagnosticAssistanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDiagnosticAssistanceAdapter implements OrderDiagnosticAssistancePort {

    private final OrderDiagnosticAssistanceRepository orderRepository;

    public OrderDiagnosticAssistanceAdapter(OrderDiagnosticAssistanceRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderDiagnosticAssistance findById(String id) {

        Optional<OrderDiagnosticAssistanceEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderDiagnosticAssistanceEntity orderEntity = orderOptional.get();
            return OrderMapper.toDomain(orderEntity);
        }

        return null;
    }

    @Override
    public List<OrderDiagnosticAssistance> findByPatientId(long id) {

        List<OrderDiagnosticAssistanceEntity> orderList = orderRepository.findAllByPatientId(id);

        return OrderMapper.toDomainOrderDiagnosticAssistance(orderList);
    }

    @Override
    public OrderDiagnosticAssistance save(OrderDiagnosticAssistance order) {

        OrderDiagnosticAssistanceEntity orderEntity = orderRepository.save(OrderMapper.toEntity(order));

        return OrderMapper.toDomain(orderEntity);
    }

    @Override
    public OrderDiagnosticAssistance update(String id, OrderDiagnosticAssistance order) {

        Optional<OrderDiagnosticAssistanceEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderDiagnosticAssistanceEntity orderEntity = orderOptional.get();

            orderEntity.setOrderNumber(order.getOrderNumber());
            orderEntity.setPatientId(order.getPatientId());
            orderEntity.setEmployeeId(order.getEmployeeId());
            orderEntity.setItemNumber(order.getItemNumber());
            orderEntity.setDiagnosticAssistanceName(order.getDiagnosticAssistanceName());
            orderEntity.setQuantity(order.getQuantity());
            orderEntity.setPrice(order.getPrice());

            OrderDiagnosticAssistanceEntity updatedOrder = orderRepository.save(orderEntity);
            return OrderMapper.toDomain(updatedOrder);
        }

        return null;
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
}
