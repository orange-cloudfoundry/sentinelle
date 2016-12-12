package com.orange.ops.sentinelle.domain;

/**
 * @author Sebastien Bortolussi
 */
public interface InvocationService {
    InvocationResponse run(Command command);
}
