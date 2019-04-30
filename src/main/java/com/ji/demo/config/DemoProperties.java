package com.ji.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="com.ji.demo")
@Data
public class DemoProperties {
    private String className;
    private String description;
}