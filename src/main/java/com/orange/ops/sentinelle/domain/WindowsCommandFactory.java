package com.orange.ops.sentinelle.domain;

import com.orange.ops.sentinelle.config.WindowsEnvironmentCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @author Sebastien Bortolussi
 */
@Service
@Conditional(WindowsEnvironmentCondition.class)
public class WindowsCommandFactory implements CommandFactory {

    @Override
    public Command ping(String destination) {
        return ImmutableCommand.builder()
                .name("cmd.exe")
                .addArgs("/C")
                .addArgs("ping")
                .addArgs("-n")
                .addArgs("4")
                .addArgs(destination)
                .build();
    }

}
