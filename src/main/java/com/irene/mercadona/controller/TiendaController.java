package com.irene.mercadona.controller;

import com.irene.mercadona.model.Tienda;
import com.irene.mercadona.service.TiendaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Gestion de las tiendas
 */
@RestController
@RequestMapping("/tiendas")
@RequiredArgsConstructor
@Validated
public class TiendaController {

    private final TiendaService tiendaService;

    // Listar todas las tiendas
    @GetMapping
    public List<Tienda> consultarTodasTiendas() {
        return tiendaService.buscarTiendas();
    }

    // Obtener tienda por código
    @GetMapping("/{codigo}")
    public ResponseEntity<Tienda> consultarTiendaPorCodigo(@PathVariable
                                                               @Min(value = 1, message = "{error.cod.positivo}")
                                                               Long codigo) {

        return tiendaService.consultarTiendaPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva tienda
    @PostMapping("/consultarTodas")
    public Tienda crearTienda(@Valid @RequestBody Tienda tienda) {
        return tiendaService.crearTienda(tienda);
    }

    // Actualizar tienda
    @PutMapping("/editarPorCod/{codigo}")
    public ResponseEntity<Tienda> editarTienda(@PathVariable
                                                   @Min(value = 1, message = "{error.cod.positivo}")
                                                   Long codigo, @Valid @RequestBody Tienda t) {

        return tiendaService.editarTienda(codigo, t)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar tienda
    @DeleteMapping("/eliminarPorCod/{codigo}")
    public ResponseEntity<Void> eliminarTienda(@PathVariable
                                                   @Min(value = 1, message = "{error.cod.positivo}")
                                                   Long codigo) {

        if(tiendaService.eliminarTienda(codigo)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
