package com.orange.ops.sentinelle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Sebastien Bortolussi
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

    /*
    When using @PathVariable on a Spring Boot controller, if a value contains a dot (‘.’)
    the value after the dot will be truncated. This happens since Spring MVC considers
    anything after the last dot as a file extension by default.
    In order to avoid to get truncated values (such as truncated IP address), such a feature can be disabled by
    setting to false the useSuffixPatternMatch option.
    @see <a href="https://github.com/spring-projects/spring-boot/issues/401">https://github.com/spring-projects/spring-boot/issues/401</a>
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
        handlerMapping.setUseSuffixPatternMatch(false);
        return handlerMapping;
    }
}
