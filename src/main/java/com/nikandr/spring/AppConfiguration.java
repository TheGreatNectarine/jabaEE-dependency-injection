package com.nikandr.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppConfiguration {
    @Autowired
    private Person person;

    @Bean
    public Person getPerson() {
        return new Person("Nikondr", 123123412, Arrays.asList("Піти в магазин",
                "Купити пефка",
                "Попити пефка",
                "Всьо)"));
    }

    @Bean
    public Profile personsProfile() {
        return new Profile(person);
    }

    @Bean
    public App getApp() {
        return new App(person);
    }
}
