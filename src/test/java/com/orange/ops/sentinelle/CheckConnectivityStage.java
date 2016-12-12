package com.orange.ops.sentinelle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Sebastien Bortolussi
 */
@JGivenStage
public class CheckConnectivityStage extends Stage<CheckConnectivityStage> {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    public CheckConnectivityStage reachable_destination(String destination) {
        return self();
    }

    public CheckConnectivityStage paas_ops_pings_destination(String destination) {
        response = this.restTemplate.getForEntity("/ping/{destination}", String.class, destination);
        return self();
    }

    public CheckConnectivityStage paas_ops_gets_feedback_showing_destination_is_reachable() {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        return self();
    }

    public CheckConnectivityStage paas_ops_gets_feedback_showing_destination_is_not_reachable() {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        return self();
    }
}
