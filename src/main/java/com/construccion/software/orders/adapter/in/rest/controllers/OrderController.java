package com.construccion.software.orders.adapter.in.rest.controllers;

import com.construccion.software.orders.adapter.in.builder.OrderBuilder;
import com.construccion.software.orders.adapter.in.rest.request.OrderRequest;
import com.construccion.software.orders.application.usecases.OrderUseCase;
import com.construccion.software.orders.domain.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderBuilder orderBuilder;
    private final OrderUseCase orderUseCase;

    public OrderController(OrderBuilder orderBuilder, OrderUseCase orderUseCase) {
        this.orderBuilder = orderBuilder;
        this.orderUseCase = orderUseCase;
    }

    @GetMapping("/Orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) throws Exception {

        Order order = orderUseCase.getOrderById(orderBuilder.getId(id));

        return ResponseEntity.ok(order);

    }

    @PostMapping("/Orders")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) throws Exception {

        Order order = orderBuilder.build(
                request.getName()
        );

        Order createdOrder = orderUseCase.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdOrder);
    }

    @PatchMapping("/Orders/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable String id, @RequestBody OrderRequest request) throws Exception {

        Order order = orderBuilder.build(
                request.getName()
        );

        Order updatedOrder = orderUseCase.updateOrder(orderBuilder.getId(id), order);

        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("Orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) throws Exception {

        orderUseCase.deleteOrder(orderBuilder.getId(id));

        return ResponseEntity.noContent().build();

    }
}
