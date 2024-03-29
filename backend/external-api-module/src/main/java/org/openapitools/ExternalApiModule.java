package org.openapitools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"org.openapitools", "org.openapitools.api" , "org.openapitools.configuration"})
public class ExternalApiModule {

    public static void main(String[] args) {
        SpringApplication.run(ExternalApiModule.class, args);
    }


}