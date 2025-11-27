package com.construccion.software.orders.adapter.in.rest.controllers;

import com.construccion.software.orders.adapter.in.builder.OrderBuilder;
import com.construccion.software.orders.adapter.in.builder.OrderDiagnosticAssistanceBuilder;
import com.construccion.software.orders.adapter.in.builder.OrderProcedureBuilder;
import com.construccion.software.orders.adapter.in.rest.request.OrderProcedureRequest;
import com.construccion.software.orders.application.usecases.OrderProcedureUseCase;
import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.models.OrderProcedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders/procedure")
public class OrderProcedureController {

    private final OrderBuilder orderBuilder;
    private final OrderProcedureUseCase useCase;
    private final OrderDiagnosticAssistanceBuilder orderDiagnosticAssistanceBuilder;
    private final OrderProcedureBuilder orderProcedureBuilder;

    public OrderProcedureController(OrderBuilder orderBuilder, OrderProcedureUseCase useCase, OrderDiagnosticAssistanceBuilder orderDiagnosticAssistanceBuilder, OrderProcedureBuilder orderProcedureBuilder) {
        this.orderBuilder = orderBuilder;
        this.useCase = useCase;
        this.orderDiagnosticAssistanceBuilder = orderDiagnosticAssistanceBuilder;
        this.orderProcedureBuilder = orderProcedureBuilder;
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) throws Exception {

        List<OrderProcedure> order = useCase.getOrderProcedureByPatientId(orderProcedureBuilder.getPatientId(id));

        return ResponseEntity.ok(order);

    }

    @GetMapping("/orderNumber/{orderNumber}")
    public ResponseEntity<?> getOrderByOrderPatientId(@PathVariable String id) throws Exception {

        List<OrderProcedure> orderList = useCase.getOrderProcedureByPatientId(orderDiagnosticAssistanceBuilder.getPatientId(id));

        return ResponseEntity.ok(orderList);
    }

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody OrderProcedureRequest request) throws Exception {

        OrderProcedure order = orderProcedureBuilder.build(request);

        OrderProcedure createdOrder = useCase.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdOrder);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable String id, @RequestBody OrderProcedureRequest request) throws Exception {

        OrderProcedure order = orderProcedureBuilder.build(request);

        OrderProcedure updatedOrder = useCase.updateOrder(orderBuilder.getId(id), order);

        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) throws Exception {

        useCase.deleteOrder(orderBuilder.getId(id));

        return ResponseEntity.noContent().build();
    }
}
