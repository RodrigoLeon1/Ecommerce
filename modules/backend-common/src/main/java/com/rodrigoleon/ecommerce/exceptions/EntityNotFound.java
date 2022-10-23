package com.rodrigoleon.ecommerce.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFound extends RuntimeException {
    public EntityNotFound(String errMsg) {
        super(errMsg);
    }
}
