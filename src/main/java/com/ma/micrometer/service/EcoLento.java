package com.ma.micrometer.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class EcoLento {

    private final Random random;

    public EcoLento() {
        random = new Random();
    }

    public String repite(String mensaje) {
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (Exception e) {
            return "error!";
        }
        return mensaje;
    }
    
}
