package com.epam.spring.homework1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "com.epam.spring.homework1.other")
@Import(PetConfig.class)
@Configuration
public class OtherConfig {
}
