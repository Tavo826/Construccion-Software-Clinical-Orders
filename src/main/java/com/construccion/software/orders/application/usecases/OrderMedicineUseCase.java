package com.construccion.software.orders.application.usecases;

import com.construccion.software.orders.domain.models.OrderMedicine;
import com.construccion.software.orders.domain.services.CreateOrder;
import com.construccion.software.orders.domain.services.DeleteOrder;
import com.construccion.software.orders.domain.services.GetOrder;
import com.construccion.software.orders.domain.services.UpdateOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMedicineUseCase {

    private final GetOrder getOrder;
    private final CreateOrder createOrder;
    private final UpdateOrder updateOrder;
    private final DeleteOrder deleteOrder;

    public OrderMedicineUseCase(
            GetOrder getOrder,
            CreateOrder createOrder,
            UpdateOrder updateOrder,
            DeleteOrder deleteOrder) {
        this.getOrder = getOrder;
        this.createOrder = createOrder;
        this.updateOrder = updateOrder;
        this.deleteOrder = deleteOrder;
    }

    public OrderMedicine getOrderById(String id) throws Exception {

        return getOrder.getMedicineById(id);
    }

    public List<OrderMedicine> getOrderMedicineByPatientId(long id) throws Exception {

        return getOrder.getOrderMedicineByPatientId(id);
    }

    public OrderMedicine createOrder(OrderMedicine order) throws Exception {

        return createOrder.create(order);
    }

    public OrderMedicine updateOrder(String id, OrderMedicine order) throws Exception {

        return updateOrder.update(id, order);
    }

    public void deleteOrder(String id) throws Exception {

        deleteOrder.deleteMedicine(id);
    }
}
