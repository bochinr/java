package com.javaee.ex08.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
