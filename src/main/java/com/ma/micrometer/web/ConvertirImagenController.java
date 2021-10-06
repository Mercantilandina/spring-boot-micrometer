package com.ma.micrometer.web;

import com.ma.micrometer.service.ConvertirImagen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertirImagenController {

    private final ConvertirImagen convertirImagen;

    public ConvertirImagenController(final ConvertirImagen convertirImagen) {
        this.convertirImagen = convertirImagen;
    }
    
    @GetMapping("/convertir")
    public String convertir() {
        convertirImagen.convertir();
        return "Se ha convertido la imagen";
    }
    
}
