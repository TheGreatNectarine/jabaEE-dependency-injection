package com.nikandr.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

public class App {
    private Person person;

    protected App(Person person) {
        this.person = person;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfiguration.class);
        context.refresh();

        App app = context.getBean(App.class);
        app.person.sayHelloVitalik();
        Profile profile = context.getBean(Profile.class);
        profile.logProfileInfo();
        profile.shareProfile(new Person(
                "Olex Mazur",
                123123123,
                Arrays.asList("Get info from Nikondr", "sleep")));
    }

}
