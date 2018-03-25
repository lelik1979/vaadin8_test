package com.home;

import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableVaadin
@ComponentScan(basePackages = "com.home")
public class SpringConfiguration {
}
