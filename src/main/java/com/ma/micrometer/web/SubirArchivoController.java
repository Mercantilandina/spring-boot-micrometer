package com.ma.micrometer.web;

import com.ma.micrometer.service.ObtenerNumeroAleatorio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.DistributionSummary;

@RestController
public class SubirArchivoController {

    private final ObtenerNumeroAleatorio obtenerNumeroAleatorio;
    private final DistributionSummary distributionSummary;

    public SubirArchivoController(
            ObtenerNumeroAleatorio obtenerNumeroAleatorio,
            @Qualifier("archivosSummary") 
            DistributionSummary distributionSummary) {
        this.obtenerNumeroAleatorio = obtenerNumeroAleatorio;
        this.distributionSummary = distributionSummary;
    }

    @GetMapping("/archivos")
    public String subirArchivo() {
        return String.format("Se ha subido un archivo de %d Kb" , getSize());
    }

    public Integer getSize() {
        Integer size = obtenerNumeroAleatorio.siguienteEntero();
        distributionSummary.record(size);        
        return size;
    }

}
