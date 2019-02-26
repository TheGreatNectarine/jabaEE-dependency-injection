package com.nikandr.spring.aspectJ.xml;

import com.nikandr.spring.aspectJ.xml.exceptions.WrongInterceptionException;

import java.util.Random;

public class Magician implements MindReader {

    private String thoughts;

    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteers's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public void getThoughts() throws WrongInterceptionException {
        boolean guess = new Random().nextBoolean();
        if (guess) {
            System.out.printf("I am feeling their thoughts... They are: \"%s\"", thoughts);
        } else {
            System.out.println("The Mind reader was wrong!");
            throw new WrongInterceptionException();
        }
    }

    @Override
    public void apologize() {
        System.out.println("I am sorry, I was wrong");
    }
}
