package com.javaee.ex04.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.javaee.ex04.service")
@Configuration
public class AppConfig {
}
