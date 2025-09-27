package com.irene.mercadona.controller;

import com.irene.mercadona.model.Asignacion;
import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.service.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
@RequiredArgsConstructor
public class AsignacionController {

    private final AsignacionService asignacionService;

    @GetMapping
    public List<Asignacion> consultarAsignaciones() {
        return asignacionService.consultarAsignaciones();
    }

    @GetMapping("/{codAsignacion}")
    public Asignacion consultarAsignacionPorCodigo(@PathVariable Long codAsignacion) {
        return asignacionService.consultarPorCodigo(codAsignacion);
    }

    // Asignar horas a un trabajador en una sección
    @PostMapping
    public Asignacion crearAsignacion(@RequestBody String dni, @RequestBody Long codSeccion, @RequestBody int horas) {

        return asignacionService.crearAsignacion(dni,codSeccion,horas);

    }

    @PutMapping("/{codigo}")
    public Asignacion editarAsignacion(@RequestBody Long codigo, @RequestBody String nuevoTrabajadorDni, @RequestBody Long nuevaSeccionCod, @RequestBody int nuevasHoras) {
        return asignacionService.editarAsignacion(codigo,nuevoTrabajadorDni,nuevaSeccionCod,nuevasHoras);
    }

    @DeleteMapping("/{codigo}")
    public void eliminarAsignacion(@PathVariable Long codigo) {
        asignacionService.eliminarAsignacion(codigo);
    }
}
