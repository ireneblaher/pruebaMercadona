package com.irene.mercadona.service;

import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.repository.SeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeccionService {

    private final SeccionRepository seccionRepository;

    public List<Seccion> consultarSecciones(){
        return seccionRepository.findAll();
    }

    public Seccion consultarSeccionPorCod(Long codigo){
        return seccionRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
    }

    public Seccion crearSeccion(Seccion seccion){
        return seccionRepository.save(seccion);
    }

    public Seccion editarSeccion(Long codigo, Seccion seccion) {
        Seccion seccionEditada = consultarSeccionPorCod(codigo);
        seccionEditada.setNombre(seccion.getNombre());
        seccionEditada.setHorasDiarias(seccion.getHorasDiarias());
        return seccionRepository.save(seccionEditada);
    }

    public void eliminarSeccion(Long codigo) {

        seccionRepository.deleteById(codigo);

    }
}
