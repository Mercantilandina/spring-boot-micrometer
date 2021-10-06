package com.ma.micrometer.config;

import com.ma.micrometer.service.ObtenerNumeroAleatorio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class GaugeConfig {

    private final ObtenerNumeroAleatorio numeroAleatorio;
    private final MeterRegistry meterRegistry;

    public GaugeConfig(ObtenerNumeroAleatorio numeroAleatorio, 
                       MeterRegistry meterRegistry) {
        this.numeroAleatorio = numeroAleatorio;
        this.meterRegistry = meterRegistry;
    }

    @Bean
    public Gauge randomGauge() {
        return Gauge
                 .builder("numero.random", numeroAleatorio, 
                          ObtenerNumeroAleatorio::siguienteEntero)
                 .register(meterRegistry);

    }
    
}
