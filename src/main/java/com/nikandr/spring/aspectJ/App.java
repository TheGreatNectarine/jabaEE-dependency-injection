package com.nikandr.spring.aspectJ;

import com.nikandr.spring.aspectJ.annotations.Performer;
import com.nikandr.spring.aspectJ.annotations.exceptions.NotInterestingPerformanceException;
import com.nikandr.spring.aspectJ.xml.Magician;
import com.nikandr.spring.aspectJ.xml.Thinker;
import com.nikandr.spring.aspectJ.xml.exceptions.WrongInterceptionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("aspectJ.xml");
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.register(ApplicationConfiguration.class);
        annotationContext.refresh();

        Performer performer = (Performer) annotationContext.getBean("interestingPerformer");
        Performer anotherPerformer = (Performer) annotationContext.getBean("notInterestingPerformer");
        try {
            performer.perform();
            anotherPerformer.perform();
        } catch (NotInterestingPerformanceException ignored) {

        }

        Thinker volunteer = (Thinker) xmlContext.getBean("volunteer");
        Magician magician = (Magician) xmlContext.getBean("magician");
        volunteer.thinkOfSomething("I am THINKING ...");
        try {
            magician.getThoughts();
        } catch (WrongInterceptionException ignored) {

        }
    }
}
