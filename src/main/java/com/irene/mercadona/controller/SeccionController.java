package com.irene.mercadona.controller;

import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.service.SeccionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Gestion de las secciones
 */
@RestController
@RequestMapping("/secciones")
@RequiredArgsConstructor
@Validated
public class SeccionController {

    private final SeccionService seccionService;

    @GetMapping("/consultarTodas")
    public List<Seccion> consultarSecciones(){
        return seccionService.consultarSecciones();
    }

    @GetMapping("/consultarPorCod/{codigo}")
    public ResponseEntity<Seccion> consultarSeccionPorCod(@PathVariable
                                                              @Min(value = 1, message = "{error.cod.positivo}")
                                                              Long codigo){

        return seccionService.consultarSeccionPorCod(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Seccion crearSeccion(@Valid @RequestBody Seccion seccion){
        return seccionService.crearSeccion(seccion);
    }

    @PutMapping("/editarPorCod/{codigo}")
    public ResponseEntity<Seccion> editarSeccion(@PathVariable
                                                     @Min(value = 1, message = "{error.cod.positivo}")
                                                     Long codigo, @Valid @RequestBody Seccion s) {

        return seccionService.editarSeccion(codigo, s)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminarPorCod/{codigo}")
    public ResponseEntity<Void> eliminarSeccion(@PathVariable
                                                    @Min(value = 1, message = "{error.cod.positivo}")
                                                    Long codigo) {

        if(seccionService.eliminarSeccion(codigo)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}