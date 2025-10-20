package com.construccion.software.orders.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderValidator extends SimpleValidator {

    public String idValidator(String value) throws Exception {
        return stringValidator("id de la orden", value);
    }

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre", value);
    }
}
