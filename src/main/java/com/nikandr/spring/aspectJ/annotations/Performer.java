package com.nikandr.spring.aspectJ.annotations;

import com.nikandr.spring.aspectJ.annotations.exceptions.NotInterestingPerformanceException;

public interface Performer {
    default void perform() throws NotInterestingPerformanceException {
        System.out.println("Performing basic stuff");
    }
}
