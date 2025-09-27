package com.irene.mercadona.controller;

import com.irene.mercadona.model.Tienda;
import com.irene.mercadona.service.TiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendas")
@RequiredArgsConstructor
public class TiendaController {

    private final TiendaService tiendaService;

    // Listar todas las tiendas
    @GetMapping
    public List<Tienda> consultarTodasTiendas() {
        return tiendaService.buscarTiendas();
    }

    // Obtener tienda por código
    @GetMapping("/{codigo}")
    public Tienda consultarTiendaPorCodigo(@PathVariable Long codigo) {
        return tiendaService.consultarTiendaPorCodigo(codigo);
    }

    // Crear nueva tienda
    @PostMapping
    public Tienda crearTienda(@RequestBody Tienda tienda) {
        return tiendaService.crearTienda(tienda);
    }

    // Actualizar tienda
    @PutMapping("/{codigo}")
    public Tienda editarTienda(@PathVariable Long codigo, @RequestBody Tienda t) {
        return tiendaService.editarTienda(codigo, t);
    }

    // Eliminar tienda
    @DeleteMapping("/{codigo}")
    public void eliminarTienda(@PathVariable Long codigo) {
        tiendaService.eliminarTienda(codigo);

    }
}
