package com.construccion.software.orders.adapter.out;

import com.construccion.software.orders.domain.models.OrderMedicine;
import com.construccion.software.orders.domain.ports.OrderMedicinePort;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderMedicineEntity;
import com.construccion.software.orders.infrastructure.persistence.mapper.OrderMapper;
import com.construccion.software.orders.infrastructure.persistence.repository.OrderMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMedicineAdapter implements OrderMedicinePort {

    private final OrderMedicineRepository orderRepository;

    public OrderMedicineAdapter(OrderMedicineRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderMedicine findById(String id) {

        Optional<OrderMedicineEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderMedicineEntity orderEntity = orderOptional.get();
            return OrderMapper.toDomain(orderEntity);
        }

        return null;
    }

    @Override
    public List<OrderMedicine> findByPatientId(long id) {

        List<OrderMedicineEntity> orderList = orderRepository.findAllByPatientId(id);

        return OrderMapper.toDomainOrderMedicine(orderList);
    }

    @Override
    public OrderMedicine save(OrderMedicine order) {

        OrderMedicineEntity orderEntity = orderRepository.save(OrderMapper.toEntity(order));

        return OrderMapper.toDomain(orderEntity);
    }

    @Override
    public OrderMedicine update(String id, OrderMedicine order) {

        Optional<OrderMedicineEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderMedicineEntity orderEntity = orderOptional.get();

            orderEntity.setOrderNumber(order.getOrderNumber());
            orderEntity.setPatientId(order.getPatientId());
            orderEntity.setEmployeeId(order.getEmployeeId());
            orderEntity.setItemNumber(order.getItemNumber());
            orderEntity.setMedicineName(order.getMedicineName());
            orderEntity.setDose(order.getDose());
            orderEntity.setTreatmentDuration(order.getTreatmentDuration());
            orderEntity.setPrice(order.getPrice());

            OrderMedicineEntity updatedOrder = orderRepository.save(orderEntity);
            return OrderMapper.toDomain(updatedOrder);
        }

        return null;
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
}
