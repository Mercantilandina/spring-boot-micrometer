package com.ma.micrometer.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ObtenerNumeroAleatorio {
    
    public static final Integer MAX_DEFAULT = 100;

    private final Random random;

    public ObtenerNumeroAleatorio() {
        random = new Random();
    }

    public Integer siguienteEntero(Integer max) {
        return random.nextInt(max) + 1;                
    }

    public Integer siguienteEntero() {
        return siguienteEntero(MAX_DEFAULT);
    }

}
