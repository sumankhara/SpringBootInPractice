package com.manning.sbip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DBConfiguration {

    @Autowired
    private Environment environment;

    public String toString() {
        return "Username: " + environment.getProperty("user") + ", Password: " + environment.getProperty("password");
    }
}
