package com.construccion.software.orders.adapter.in.validators;

import com.construccion.software.orders.application.exceptions.InputsException;

import java.math.BigDecimal;

public abstract class SimpleValidator {

    public String stringValidator(String element, String value) throws Exception {
        if (value == null || value.equals("")) {
            throw new InputsException(element + " no puede tener un valor vacío o nulo");
        }
        return value;
    }

    public Integer integerValidator(String element, String value) throws Exception {

        stringValidator(element, value);
        try {
            int integer = Integer.parseInt(value);
            if (integer < 0) {
                throw new InputsException(element + " no puede ser negativo");
            }
            return integer;
        } catch (NumberFormatException e) {
            throw new InputsException(element + "debe ser un número");
        }
    }

    public long longValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }

    public BigDecimal bigDecimalValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }
}
