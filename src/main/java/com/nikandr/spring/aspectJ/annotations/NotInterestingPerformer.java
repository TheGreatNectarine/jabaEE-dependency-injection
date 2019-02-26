package com.nikandr.spring.aspectJ.annotations;

import com.nikandr.spring.aspectJ.annotations.exceptions.NotInterestingPerformanceException;

public class NotInterestingPerformer implements Performer {
    @Override
    public void perform() throws NotInterestingPerformanceException {
        System.out.println("Performs boring stuff…");
        throw new NotInterestingPerformanceException();
    }
}
