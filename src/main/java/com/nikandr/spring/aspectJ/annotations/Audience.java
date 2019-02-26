package com.nikandr.spring.aspectJ.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Pointcut("execution(* com.nikandr.spring.aspectJ.annotations.Performer.perform(..)))")
    public void performance() {
    }

    //    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    //    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones.");
    }

    //    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP");
    }

    //    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Booo! We want our money back!");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinpoint) {
        try {
            takeSeats();
            turnOffCellPhones();
            long start = System.currentTimeMillis();

            joinpoint.proceed();

            long end = System.currentTimeMillis();
            applaud();
            System.out.println("The performance took " + (end - start) + " milliseconds.");
        } catch (Throwable t) {
            demandRefund();
        }
    }

}
