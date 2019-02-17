package com.nikandr.spring;

import java.beans.JavaBean;
import java.util.List;

public class Person {

    private String name;
    private int number;
    private List<String> toDoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Person(String name, int number, List<String> toDoList) {
        this.name = name;
        this.number = number;
        this.toDoList = toDoList;
    }

    void sayHelloVitalik() {
        System.out.println("Привіт я " + name + ", і мій number – " + number);
        System.out.println("Я маю зробити діла: ");
        toDoList.forEach(System.out::println);
    }

}
