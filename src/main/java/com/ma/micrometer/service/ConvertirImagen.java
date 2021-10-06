package com.ma.micrometer.service;

import com.ma.micrometer.core.ImagenRepository;

import org.springframework.stereotype.Service;

@Service
public class ConvertirImagen {

    private final ImagenRepository imagenRepository;

    public ConvertirImagen(final ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public void convertir() {
        imagenRepository.convertirImagen();
    }
    
}
