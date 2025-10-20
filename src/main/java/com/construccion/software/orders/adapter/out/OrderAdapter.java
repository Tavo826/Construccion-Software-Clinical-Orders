package com.construccion.software.orders.adapter.out;

import com.construccion.software.orders.domain.models.Order;
import com.construccion.software.orders.domain.ports.OrderPort;
import com.construccion.software.orders.infrastructure.persistence.entities.OrderEntity;
import com.construccion.software.orders.infrastructure.persistence.mapper.OrderMapper;
import com.construccion.software.orders.infrastructure.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;

    public OrderAdapter(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(String id) {

        Optional<OrderEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderEntity orderEntity = orderOptional.get();
            return OrderMapper.toDomain(orderEntity);
        }

        return null;
    }

    @Override
    public Order save(Order order) {

        OrderEntity orderEntity = orderRepository.save(OrderMapper.toEntity(order));

        return OrderMapper.toDomain(orderEntity);
    }

    @Override
    public Order update(String id, Order order) {

        Optional<OrderEntity> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            OrderEntity orderEntity = orderOptional.get();

            orderEntity.setName(order.getName());

            OrderEntity updatedOrder = orderRepository.save(orderEntity);
            return OrderMapper.toDomain(updatedOrder);
        }

        return null;
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
}
