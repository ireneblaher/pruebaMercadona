package com.irene.mercadona.controller;

import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.service.SeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secciones")
@RequiredArgsConstructor
public class SeccionController {

    private final SeccionService seccionService;

    @GetMapping
    public List<Seccion> consultarSecciones(){
        return seccionService.consultarSecciones();
    }

    @GetMapping("/{codigo}")
    public Seccion consultarSeccionPorCod(@PathVariable Long codigo){
        return seccionService.consultarSeccionPorCod(codigo);
    }

    @PostMapping
    public Seccion crearSeccion(@RequestBody Seccion seccion){
        return seccionService.crearSeccion(seccion);
    }

    @PutMapping("/{codigo}")
    public Seccion editarSeccion(@PathVariable Long codigo, @RequestBody Seccion s) {
        return seccionService.editarSeccion(codigo, s);
    }

    @DeleteMapping("/{codigo}")
    public void eliminarSeccion(@PathVariable Long codigo) {
        seccionService.eliminarSeccion(codigo);
    }
}