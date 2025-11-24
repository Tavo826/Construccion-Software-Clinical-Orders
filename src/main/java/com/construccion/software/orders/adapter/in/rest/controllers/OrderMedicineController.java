package com.construccion.software.orders.adapter.in.rest.controllers;

import com.construccion.software.orders.adapter.in.builder.OrderBuilder;
import com.construccion.software.orders.adapter.in.builder.OrderMedicineBuilder;
import com.construccion.software.orders.adapter.in.rest.request.OrderMedicineRequest;
import com.construccion.software.orders.application.usecases.OrderMedicineUseCase;
import com.construccion.software.orders.domain.models.OrderDiagnosticAssistance;
import com.construccion.software.orders.domain.models.OrderMedicine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders/medicine")
public class OrderMedicineController {

    private final OrderBuilder orderBuilder;
    private final OrderMedicineBuilder builder;
    private final OrderMedicineUseCase useCase;
    private final OrderMedicineBuilder orderMedicineBuilder;

    public OrderMedicineController(
            OrderBuilder orderBuilder,
            OrderMedicineBuilder builder,
            OrderMedicineUseCase useCase, OrderMedicineBuilder orderMedicineBuilder) {
        this.orderBuilder = orderBuilder;
        this.builder = builder;
        this.useCase = useCase;
        this.orderMedicineBuilder = orderMedicineBuilder;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) throws Exception {

        OrderMedicine order = useCase.getOrderById(orderBuilder.getId(id));

        return ResponseEntity.ok(order);

    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<?> getOrderByPatientId(@PathVariable String id) throws Exception {

        List<OrderMedicine> orderList = useCase.getOrderMedicineByPatientId(orderMedicineBuilder.getEmployeeId(id));

        return ResponseEntity.ok(orderList);
    }

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody OrderMedicineRequest request) throws Exception {

        OrderMedicine order = builder.build(request);

        OrderMedicine createdOrder = useCase.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdOrder);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable String id, @RequestBody OrderMedicineRequest request) throws Exception {

        OrderMedicine order = builder.build(request);

        OrderMedicine updatedOrder = useCase.updateOrder(orderBuilder.getId(id), order);

        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) throws Exception {

        useCase.deleteOrder(orderBuilder.getId(id));

        return ResponseEntity.noContent().build();
    }
}
