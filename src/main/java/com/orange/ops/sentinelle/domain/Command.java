package com.orange.ops.sentinelle.domain;

import org.immutables.value.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastien Bortolussi
 */
@Value.Immutable
public abstract class Command {

    public abstract String name();

    public abstract List<String> args();

    /*
    @return a string array containing the command and its arguments
     */
    public List<String> full() {
        List<String> full = new ArrayList<>();
        full.add(name());
        full.addAll(args());
        return full;
    }

}
