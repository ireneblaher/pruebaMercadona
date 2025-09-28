package com.irene.mercadona.controller;

import com.irene.mercadona.dto.AsignacionRequestDTO;
import com.irene.mercadona.model.Asignacion;
import com.irene.mercadona.service.AsignacionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gestion de las asignaciones trabajador-seccion
 */
@RestController
@RequestMapping("/asignaciones")
@RequiredArgsConstructor
@Validated
public class AsignacionController {

    private final AsignacionService asignacionService;

    @GetMapping("/consultarTodas")
    public List<Asignacion> consultarAsignaciones() {
        return asignacionService.consultarAsignaciones();
    }

    @GetMapping("/consultarPorCod/{codigo}")
    public ResponseEntity<Asignacion> consultarAsignacionPorCodigo(@PathVariable
                                                                       @Min(value = 1, message = "{error.cod.positivo}")
                                                                       Long codigo) {

        return asignacionService.consultarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Asignar horas a un trabajador en una sección
    @PostMapping("/crear")
    public ResponseEntity<Asignacion> crearAsignacion(@Valid @RequestBody AsignacionRequestDTO asignacionRequestDTO) {
        try{

            return  ResponseEntity.ok(asignacionService.crearAsignacion(asignacionRequestDTO));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("eliminarPorCod/{codigo}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable
                                                       @Min(value = 1, message = "{error.cod.positivo}")
                                                       Long codigo) {

        if(asignacionService.eliminarAsignacion(codigo)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
