package com.orange.ops.sentinelle.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Sebastien Bortolussi
 */
public class LinuxCommandFactoryTest {

    private LinuxCommandFactory linuxCommandFactory = new LinuxCommandFactory();

    @Test
    public void create_ping_command() throws Exception {
        Assertions.assertThat(linuxCommandFactory.ping("localhost"))
                .isEqualTo(ImmutableCommand.builder()
                        .name("ping")
                        .addArgs("-c")
                        .addArgs("4")
                        .addArgs("localhost")
                        .build());
    }

}