package com.nikandr.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    private Person person;
    private HelloWorld helloWorld;

    protected App(Person person) {
        this.person = person;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        App app = context.getBean(App.class);
        app.person.sayHelloVitalik();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfiguration.class);
        ctx.refresh();

        Profile profile = ctx.getBean(Profile.class);
        profile.logProfileInfo();
        profile.shareProfile(new Person(
                "Olex Mazur",
                123123123,
                Arrays.asList("Get info from Nikondr", "sleep")));
        app.helloWorld.printHello();
    }

}
