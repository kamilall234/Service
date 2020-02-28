package com.kamil.serwis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.kamil.serwis.service"})
public class AppConfig {
}
