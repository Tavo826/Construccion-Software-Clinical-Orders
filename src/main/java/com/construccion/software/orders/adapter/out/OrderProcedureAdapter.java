package com.construccion.software.orders.adapter.out;

import com.construccion.software.orders.domain.models.OrderProcedure;
import com.construccion.software.orders.domain.ports.OrderProcedurePort;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderProcedureEntity;
import com.construccion.software.orders.infrastructure.persistence.mapper.OrderMapper;
import com.construccion.software.orders.infrastructure.persistence.repository.OrderProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProcedureAdapter implements OrderProcedurePort {

    private final OrderProcedureRepository orderRepository;

    public OrderProcedureAdapter(OrderProcedureRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderProcedure findById(String id) {

        Optional<OrderProcedureEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderProcedureEntity orderEntity = orderOptional.get();
            return OrderMapper.toDomain(orderEntity);
        }

        return null;
    }

    @Override
    public List<OrderProcedure> findByPatientId(long id) {

        List<OrderProcedureEntity> orderList = orderRepository.findAllByPatientId(id);

        return OrderMapper.toDomainOrderProcedure(orderList);
    }

    @Override
    public OrderProcedure save(OrderProcedure order) {

        OrderProcedureEntity orderEntity = orderRepository.save(OrderMapper.toEntity(order));

        return OrderMapper.toDomain(orderEntity);
    }

    @Override
    public OrderProcedure update(String id, OrderProcedure order) {

        Optional<OrderProcedureEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderProcedureEntity orderEntity = orderOptional.get();

            orderEntity.setOrderNumber(order.getOrderNumber());
            orderEntity.setPatientId(order.getPatientId());
            orderEntity.setEmployeeId(order.getEmployeeId());
            orderEntity.setItemNumber(order.getItemNumber());
            orderEntity.setProcedureName(order.getProcedureName());
            orderEntity.setRepetitionNumber(order.getRepetitionNumber());
            orderEntity.setRepetitionFrequency(order.getRepetitionFrequency());
            orderEntity.setPrice(order.getPrice());
            orderEntity.setRequiresSpecialistAssistance(order.isRequiresSpecialistAssistance());
            orderEntity.setSpecialistId(order.getSpecialistId());

            OrderProcedureEntity updatedOrder = orderRepository.save(orderEntity);
            return OrderMapper.toDomain(updatedOrder);
        }

        return null;
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
}
