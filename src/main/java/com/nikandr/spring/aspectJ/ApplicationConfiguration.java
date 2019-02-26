package com.nikandr.spring.aspectJ;

import com.nikandr.spring.aspectJ.annotations.InterestingPerformer;
import com.nikandr.spring.aspectJ.annotations.NotInterestingPerformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.nikandr.spring.aspectJ.annotations")
public class ApplicationConfiguration {

    @Bean
    public InterestingPerformer interestingPerformer() {
        return new InterestingPerformer();
    }

    @Bean public NotInterestingPerformer notInterestingPerformer() {
        return new NotInterestingPerformer();
    }
}
