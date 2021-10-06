package com.ma.micrometer.infra;

import java.util.Random;

import com.ma.micrometer.core.ImagenRepository;

import org.springframework.stereotype.Repository;

import io.micrometer.core.annotation.Timed;

@Repository
public class ImagenRepositoryMemory implements ImagenRepository {

    private final Random random;

    public ImagenRepositoryMemory() {
        random = new Random();
    }

    @Timed("imagen.convertir")
    @Override
    public boolean convertirImagen() {
        try {
            Thread.sleep(random.nextInt(5000));

        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
