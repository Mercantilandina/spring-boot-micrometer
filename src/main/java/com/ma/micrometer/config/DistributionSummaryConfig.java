package com.ma.micrometer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class DistributionSummaryConfig {

    @Bean("archivosSummary")
    public DistributionSummary getSummary(MeterRegistry meterRegistry) {
        return DistributionSummary
                 .builder("archivos.sizes")
                 .description("Muestra de tamaños de archivos subidos")
                 .baseUnit("kilobytes")
                 .serviceLevelObjectives(10, 50, 90)
                 .register(meterRegistry);
    }
    
}
