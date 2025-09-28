package com.irene.mercadona.service;

import com.irene.mercadona.model.Asignacion;
import com.irene.mercadona.dto.InformeResponseDTO;
import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.model.Tienda;
import com.irene.mercadona.repository.TiendaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio correspondiente a los informes
 */
@Service
@RequiredArgsConstructor
public class InformeService {

    private final TiendaRepository tiendaRepository;

    // Informe 1: Estado de la tienda
    @Transactional
    public List<Tienda> obtenerEstadoTienda() {
        // Cargar tiendas con secciones y trabajadores
        List<Tienda> tiendas = tiendaRepository.findAll();
        // Las relaciones @OneToMany lazy se pueden inicializar aquí si es necesario
        tiendas.forEach(tienda -> tienda.getSecciones().forEach(
                seccion -> seccion.getAsignaciones().size()
        ));
        return tiendas;
    }

    // Informe 2: Secciones con horas no cubiertas
    @Transactional
    public List<InformeResponseDTO> obtenerSeccionesIncompletas() {
        List<InformeResponseDTO> resultado = new ArrayList<>();
        List<Tienda> tiendas = tiendaRepository.findAll();
        for (Tienda tienda : tiendas) {
            for (Seccion seccion : tienda.getSecciones()) {
                int totalHorasAsignadas = seccion.getAsignaciones().stream()
                        .mapToInt(Asignacion::getHorasAsignadas)
                        .sum();
                if (totalHorasAsignadas < seccion.getHorasNecesarias()) {
                    resultado.add(new InformeResponseDTO(
                            tienda.getNombre(),
                            seccion.getNombre(),
                            seccion.getHorasNecesarias() - totalHorasAsignadas
                    ));
                }
            }
        }
        return resultado;
    }
}

