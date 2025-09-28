package com.irene.mercadona.controller;

import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.service.TrabajadorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Gestion de los trabajadores
 */
@RestController
@RequestMapping("/trabajadores")
@RequiredArgsConstructor
@Validated
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @GetMapping("/consultarTodos")
    public List<Trabajador> consultarTrabajadores(){
        return trabajadorService.consultarTrabajadores();
    }

    @GetMapping("/consultarPorDni/{dni}")
    public ResponseEntity<Trabajador> consultarTrabajadoresPorDni(@PathVariable
                                                                      @Size(min = 9, max = 9, message = "{error.dni.tamanio}")
                                                                      @Pattern(regexp = "[0-9]{8}[A-Z]", message = "{error.dni.invalido}")
                                                                      String dni){

        return trabajadorService.consultarTrabajadorPorDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value ="/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Trabajador crearTrabajador(@Valid @RequestBody Trabajador trabajador){

        return trabajadorService.crearTrabajador(trabajador);
    }

    @PutMapping(value ="/editarPorDni/{dni}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trabajador> editarTrabajador(@PathVariable
                                                           @Size(min = 9, max = 9, message = "{error.dni.tamanio}")
                                                           @Pattern(regexp = "[0-9]{8}[A-Z]", message = "{error.dni.invalido}")
                                                           String dni, @Valid @RequestBody Trabajador t) {

        return trabajadorService.editarTrabajador(dni, t)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminarPorDni/{dni}")
    public ResponseEntity<Void> eliminarTrabajadorPorDni(@PathVariable
                                                             @Size(min = 9, max = 9, message = "{error.dni.tamanio}")
                                                             @Pattern(regexp = "[0-9]{8}[A-Z]", message = "{error.dni.invalido}")
                                                             String dni) {

        if(trabajadorService.eliminarTrabajadorPorDni(dni)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
