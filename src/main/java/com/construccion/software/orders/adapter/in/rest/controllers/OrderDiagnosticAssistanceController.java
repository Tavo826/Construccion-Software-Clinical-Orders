package com.construccion.software.orders.adapter.in.rest.controllers;

import com.construccion.software.orders.adapter.in.builder.OrderBuilder;
import com.construccion.software.orders.adapter.in.builder.OrderDiagnosticAssistanceBuilder;
import com.construccion.software.orders.adapter.in.rest.request.OrderDiagnosticAssistanceRequest;
import com.construccion.software.orders.application.usecases.OrderDiagnosticAssistanceUseCase;
import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders/diagnosis")
public class OrderDiagnosticAssistanceController {

    private final OrderBuilder orderBuilder;
    private final OrderDiagnosticAssistanceBuilder builder;
    private final OrderDiagnosticAssistanceUseCase useCase;
    private final OrderDiagnosticAssistanceBuilder orderDiagnosticAssistanceBuilder;

    public OrderDiagnosticAssistanceController(
            OrderBuilder orderBuilder,
            OrderDiagnosticAssistanceBuilder builder,
            OrderDiagnosticAssistanceUseCase useCase, OrderDiagnosticAssistanceUseCase orderDiagnosticAssistanceUseCase, OrderDiagnosticAssistanceBuilder orderDiagnosticAssistanceBuilder) {
        this.orderBuilder = orderBuilder;
        this.builder = builder;
        this.useCase = useCase;
        this.orderDiagnosticAssistanceBuilder = orderDiagnosticAssistanceBuilder;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) throws Exception {

        OrderDiagnosticAssistance order = useCase.getOrderById(orderBuilder.getId(id));

        return ResponseEntity.ok(order);

    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<?> getOrderByPatientId(@PathVariable String id) throws Exception {

        List<OrderDiagnosticAssistance> orderList = useCase.getOrderDiagnosticAssistanceByPatientId(orderDiagnosticAssistanceBuilder.getPatientId(id));

        return ResponseEntity.ok(orderList);
    }

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody OrderDiagnosticAssistanceRequest request) throws Exception {

        OrderDiagnosticAssistance order = builder.build(request);

        OrderDiagnosticAssistance createdOrder = useCase.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdOrder);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable String id, @RequestBody OrderDiagnosticAssistanceRequest request) throws Exception {

        OrderDiagnosticAssistance order = builder.build(request);

        OrderDiagnosticAssistance updatedOrder = useCase.updateOrder(orderBuilder.getId(id), order);

        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) throws Exception {

        useCase.deleteOrder(orderBuilder.getId(id));

        return ResponseEntity.noContent().build();
    }
}
