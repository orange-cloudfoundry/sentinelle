package com.orange.ops.sentinelle.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Sebastien Bortolussi
 */
public class WindowsCommandFactoryTest {

    private WindowsCommandFactory windowsCommandFactory = new WindowsCommandFactory();

    @Test
    public void create_ping_command() throws Exception {
        Assertions.assertThat(windowsCommandFactory.ping("localhost"))
                .isEqualTo(ImmutableCommand.builder()
                        .name("cmd.exe")
                        .addArgs("/C")
                        .addArgs("ping")
                        .addArgs("-n")
                        .addArgs("4")
                        .addArgs("localhost")
                        .build());
    }

}