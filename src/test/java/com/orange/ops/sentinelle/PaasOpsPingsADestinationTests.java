package com.orange.ops.sentinelle;

import com.tngtech.jgiven.integration.spring.EnableJGiven;
import com.tngtech.jgiven.integration.spring.SimpleSpringScenarioTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJGiven
public class PaasOpsPingsADestinationTests extends SimpleSpringScenarioTest<CheckConnectivityStage> {

    @Test
    public void paas_ops_pings_reachable_ip_destination() {
        String destination = "127.0.0.1";

        given().reachable_destination(destination);
        when().paas_ops_pings_destination(destination);
        then().paas_ops_gets_feedback_showing_destination_is_reachable();
    }

    @Test
    public void paas_ops_pings_reachable_host_destination() {
        String destination = "localhost";

        given().reachable_destination(destination);
        when().paas_ops_pings_destination(destination);
        then().paas_ops_gets_feedback_showing_destination_is_reachable();
    }

    @Test
    public void paas_ops_pings_unreachable_destination() {
        String destination = "dummy";

        given().reachable_destination(destination);
        when().paas_ops_pings_destination(destination);
        then().paas_ops_gets_feedback_showing_destination_is_not_reachable();
    }

    @TestConfiguration
    static class Config {

        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder()
                    .basicAuthorization("user", "changeit");
        }

    }


}
