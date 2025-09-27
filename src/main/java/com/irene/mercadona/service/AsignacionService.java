package com.irene.mercadona.service;

import com.irene.mercadona.model.Asignacion;
import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.repository.AsignacionRepository;
import com.irene.mercadona.repository.SeccionRepository;
import com.irene.mercadona.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionService {
    private final AsignacionRepository asignacionRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final SeccionRepository seccionRepository;

    public List<Asignacion> consultarAsignaciones() {
        return asignacionRepository.findAll();
    }

    public Asignacion consultarPorCodigo(Long codigo) {
        return asignacionRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));
    }

    public Asignacion crearAsignacion(String dniTrabajador, Long codSeccion, int horas) {
        Trabajador trabajador = trabajadorRepository.findById(dniTrabajador)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
        Seccion seccion = seccionRepository.findById(codSeccion)
                .orElseThrow(() -> new RuntimeException("Sección no encontrada"));

        Asignacion asignacion = new Asignacion();
        asignacion.setTrabajador(trabajador);
        asignacion.setSeccion(seccion);
        asignacion.setHorasAsignadas(horas);

        return asignacionRepository.save(asignacion);
    }

    public Asignacion editarAsignacion(Long codigo, String nuevoTrabajadorDni, Long nuevaSeccionCod, int nuevasHoras) {
        Asignacion asignacion = consultarPorCodigo(codigo);

        if (nuevoTrabajadorDni != null) {
            Trabajador trabajador = trabajadorRepository.findById(nuevoTrabajadorDni)
                    .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
            asignacion.setTrabajador(trabajador);
        }

        if (nuevaSeccionCod != null) {
            Seccion seccion = seccionRepository.findById(nuevaSeccionCod)
                    .orElseThrow(() -> new RuntimeException("Sección no encontrada"));
            asignacion.setSeccion(seccion);
        }

        asignacion.setHorasAsignadas(nuevasHoras);

        return asignacionRepository.save(asignacion);
    }

    public void eliminarAsignacion(Long cod) {
        asignacionRepository.deleteById(cod);
    }
}
