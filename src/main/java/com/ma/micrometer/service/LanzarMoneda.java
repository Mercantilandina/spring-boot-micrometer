package com.ma.micrometer.service;

import java.util.Random;

import com.ma.micrometer.core.Moneda;

import org.springframework.stereotype.Service;

@Service
public class LanzarMoneda {

    private final Random random;

    public LanzarMoneda() {
        random = new Random();
    }

    public Moneda siguiente() {
        return random.nextInt(2) == 0 ? Moneda.CARA : Moneda.CRUZ;        
    }

}
