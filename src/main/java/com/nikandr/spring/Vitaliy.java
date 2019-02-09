package com.nikandr.spring;

import java.util.List;

public class Vitaliy {

    private String name;
    private int i4len_length;
    private List<String> spisokDel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getI4len_length() {
        return i4len_length;
    }

    public void setI4len_length(int i4len_length) {
        this.i4len_length = i4len_length;
    }

    private Vitaliy(String name, int i4len_length, List<String> spisokDel) {
        this.name = name;
        this.i4len_length = i4len_length;
        this.spisokDel = spisokDel;
    }

    public void sayHelloVitalik() {
        System.out.println("Привіт я " + name + ", і мій 4len – " + i4len_length);
        System.out.println("Я маю зробити діла: ");
        spisokDel.forEach(System.out::println);
    }

}
