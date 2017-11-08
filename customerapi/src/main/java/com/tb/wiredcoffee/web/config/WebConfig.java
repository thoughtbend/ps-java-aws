package com.tb.wiredcoffee.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@ComponentScan("com.tb.wiredcoffee.web.api")
@EnableWebFlux
public class WebConfig {

}
