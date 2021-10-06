package com.ma.micrometer.web;

import java.util.concurrent.atomic.AtomicReference;

import com.ma.micrometer.service.EcoLento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class MensajeLentoController {

    private final EcoLento ecoLento;
    private final MeterRegistry meterRegistry;

    public MensajeLentoController(final EcoLento ecoLento, final MeterRegistry meterRegistry) {
        this.ecoLento = ecoLento;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/lento")
    public String mensajeLento() {
        return obtenerMensaje();
    }

    private String obtenerMensaje() {
        AtomicReference<String> mensaje = new AtomicReference<>();
        meterRegistry
              .timer("mensaje.lento")
              .record(() -> mensaje.set(ecoLento.repite("Hola")));
        return mensaje.get();
    }
   
    
}
