package com.irene.mercadona.controller;

import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @GetMapping("/consultarTrabajadores")
    public List<Trabajador> consultarTrabajadores(){
        return trabajadorService.consultarTrabajadores();
    }

    @GetMapping("/consultarTrabajador/{dni}")
    public Trabajador consultarTrabajadoresPorDni(@PathVariable String dni){
        return trabajadorService.consultarTrabajadorPorDni(dni);
    }

    @PostMapping("/crearTrabajador")
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador){
        return trabajadorService.crearTrabajador(trabajador);
    }

    @PutMapping("/editarTrabajador/{dni}")
    public Trabajador editarTrabajador(@PathVariable String dni, @RequestBody Trabajador t) {
        return trabajadorService.editarTrabajador(dni, t);
    }

    @DeleteMapping("/eliminarTrabajador/{dni}")
    public void eliminarTrabajadorPorDni(@PathVariable String dni) {
        trabajadorService.eliminarTrabajadorPorDni(dni);
    }
}
