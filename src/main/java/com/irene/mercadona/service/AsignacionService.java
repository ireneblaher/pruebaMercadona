package com.irene.mercadona.service;

import com.irene.mercadona.dto.AsignacionRequestDTO;
import com.irene.mercadona.model.Asignacion;
import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.repository.AsignacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Lógica de negocio correspondiente a las Asignaciones
 */
@Service
@RequiredArgsConstructor
public class AsignacionService {
    private final AsignacionRepository asignacionRepository;
    private final TrabajadorService trabajadorService;
    private final SeccionService seccionService;

    public List<Asignacion> consultarAsignaciones() {
        return asignacionRepository.findAll();
    }

    public Optional<Asignacion> consultarPorCodigo(Long codigo) {
        return asignacionRepository.findById(codigo);
    }

    public Asignacion crearAsignacion(AsignacionRequestDTO asignacionRequestDTO) {
        Trabajador trabajador = trabajadorService.consultarTrabajadorPorDni(asignacionRequestDTO.getDniTrabajador())
                .orElseThrow(() -> new IllegalArgumentException("{error.trabajador.no_encontrado}"));
        Seccion seccion = seccionService.consultarSeccionPorCod(asignacionRequestDTO.getCodSeccion())
                .orElseThrow(() -> new IllegalArgumentException("{error.seccion.no_encontrada}"));

        int horas = asignacionRequestDTO.getHorasAsignadas();

        int horasAsignadas = asignacionRepository.sumHorasByTrabajadorId(asignacionRequestDTO.getDniTrabajador()).orElse(0);
        if (horasAsignadas + horas > trabajador.getHorasDisponibles()) {
            throw new IllegalArgumentException("{error.trabajador.horasmax}");
        }

        Asignacion asignacion = new Asignacion();
        asignacion.setTrabajador(trabajador);
        asignacion.setSeccion(seccion);
        asignacion.setHorasAsignadas(horas);

        return asignacionRepository.save(asignacion);
    }

    public boolean eliminarAsignacion(Long cod) {

        if(asignacionRepository.existsById(cod)) {
            asignacionRepository.deleteById(cod);
            return true;
        }
        return false;
    }
}
