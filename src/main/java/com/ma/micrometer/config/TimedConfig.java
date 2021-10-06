package com.ma.micrometer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
@EnableAspectJAutoProxy
public class TimedConfig {

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return  new TimedAspect(registry);
    }
    
}
