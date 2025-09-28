package com.irene.mercadona.controller;

import com.irene.mercadona.dto.InformeResponseDTO;
import com.irene.mercadona.model.Tienda;
import com.irene.mercadona.service.InformeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Gestion de los informes
 */
@RestController
@RequestMapping("/informes")
@RequiredArgsConstructor
@Validated
public class InformeController {

    private final InformeService informeService;

    @GetMapping("/estado-tienda")
    public List<Tienda> getEstadoTienda() {
        return informeService.obtenerEstadoTienda();
    }

    @GetMapping("/secciones-incompletas")
    public List<InformeResponseDTO> getSeccionesIncompletas() {
        return informeService.obtenerSeccionesIncompletas();
    }

}
