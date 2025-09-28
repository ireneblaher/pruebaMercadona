package com.irene.mercadona.service;

import com.irene.mercadona.model.Seccion;
import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.repository.SeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Lógica de negocio correspondiente a las secciones
 */
@Service
@RequiredArgsConstructor
public class SeccionService {

    private final SeccionRepository seccionRepository;

    public List<Seccion> consultarSecciones(){
        return seccionRepository.findAll();
    }

    public Optional<Seccion> consultarSeccionPorCod(Long codigo){
        return seccionRepository.findById(codigo);
    }

    public Seccion crearSeccion(Seccion seccion){
        return seccionRepository.save(seccion);
    }

    public Optional<Seccion> editarSeccion(Long codigo, Seccion sActualizada) {

        return seccionRepository.findById(codigo).map(sAntigua -> {
            sAntigua.setNombre(sActualizada.getNombre());
            sAntigua.setHorasNecesarias(sActualizada.getHorasNecesarias());
            return seccionRepository.save(sAntigua);
        });
    }

    public boolean eliminarSeccion(Long codigo) {

        if(seccionRepository.existsById(codigo)){
            seccionRepository.deleteById(codigo);
            return true;
        }
        return false;

    }
}
