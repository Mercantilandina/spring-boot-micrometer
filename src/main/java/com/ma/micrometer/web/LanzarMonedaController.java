package com.ma.micrometer.web;

import com.ma.micrometer.core.Moneda;
import com.ma.micrometer.service.LanzarMoneda;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class LanzarMonedaController {

    private final LanzarMoneda lanzarMoneda;
    private final MeterRegistry meterRegistry;

    public LanzarMonedaController(LanzarMoneda lanzarMoneda, 
                                  MeterRegistry meterRegistry) {
        this.lanzarMoneda = lanzarMoneda;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping(value = "/moneda")
    public Moneda siguienteMoneda() {
        return obtenerMoneda();
    }

    private Moneda obtenerMoneda() {
        Moneda moneda = lanzarMoneda.siguiente();
        if (moneda == Moneda.CARA) {
            meterRegistry.counter("moneda.cara").increment();
        } else {
            meterRegistry.counter("moneda.cruz").increment();
        }
        return moneda;
    }

}
