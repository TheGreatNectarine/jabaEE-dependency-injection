package com.nikandr.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Vitaliy vitaliy;
    private HelloWorld helloWorld;

    protected App(Vitaliy vitaliy) {
        this.vitaliy = vitaliy;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        App app = context.getBean(App.class);
        app.vitaliy.sayHelloVitalik();
        app.helloWorld.printHello();

    }

}
