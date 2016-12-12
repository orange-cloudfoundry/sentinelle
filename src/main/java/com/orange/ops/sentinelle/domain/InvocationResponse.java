package com.orange.ops.sentinelle.domain;

import org.immutables.value.Value;

/**
 * @author Sebastien Bortolussi
 */
@Value.Immutable
public abstract class InvocationResponse {

    public abstract String output();

    public abstract int statusCode();

    @Value.Derived
    public boolean failed() {
        return statusCode() != 0;
    }

    @Value.Derived
    public boolean success() {
        return statusCode() == 0;
    }


}
