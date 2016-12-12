package com.orange.ops.sentinelle.infrastructure;

import com.orange.ops.sentinelle.domain.Command;
import com.orange.ops.sentinelle.domain.ImmutableInvocationResponse;
import com.orange.ops.sentinelle.domain.InvocationResponse;
import com.orange.ops.sentinelle.domain.InvocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.SequenceInputStream;
import java.nio.charset.Charset;

/**
 * @author Sebastien Bortolussi
 */
@Service
public class InvocationServiceDefault implements InvocationService {

    private final Logger logger = LoggerFactory.getLogger(InvocationServiceDefault.class);

    public InvocationResponse run(Command command) {
        try {
            ProcessBuilder pb = new ProcessBuilder(command.full());
            logger.debug(String.format("Running %s", command.full()));
            Process process = pb.start();
            SequenceInputStream combined = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            int errCode = process.waitFor();
            final String out = StreamUtils.copyToString(combined, Charset.forName("UTF-8"));
            return ImmutableInvocationResponse.builder()
                    .output(out)
                    .statusCode(errCode)
                    .build();
        } catch (Exception e) {
            logger.error(String.format("Error while running %s", command.full()), e);
            return ImmutableInvocationResponse.builder()
                    .output(e.getMessage())
                    .statusCode(1)
                    .build();
        }
    }
}
