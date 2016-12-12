package com.orange.ops.sentinelle.domain;

/**
 * @author Sebastien Bortolussi
 */
public interface CommandFactory {
    String PING_COUNT = "4";

    Command ping(String destination);
}
