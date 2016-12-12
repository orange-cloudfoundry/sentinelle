package com.orange.ops.sentinelle.domain;

import com.orange.ops.sentinelle.config.LinuxEnvironmentCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @author Sebastien Bortolussi
 */
@Service
@Conditional(LinuxEnvironmentCondition.class)
public class LinuxCommandFactory implements CommandFactory {

    @Override
    public Command ping(String destination) {
        return ImmutableCommand.builder()
                .name("ping")
                .addArgs("-c")
                .addArgs(PING_COUNT)
                .addArgs(destination)
                .build();
    }

}
