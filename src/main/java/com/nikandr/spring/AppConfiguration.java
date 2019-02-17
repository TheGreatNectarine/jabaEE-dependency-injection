package com.nikandr.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:SpringBeans.xml")
public class AppConfiguration {
    @Autowired
    private Person person;

    @Bean
    public Profile personsProfile() {
        return new Profile(person);
    }
}
