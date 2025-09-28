package com.irene.mercadona.service;

import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Lógica de negocio correspondiente a los trabajadores
 */
@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public List<Trabajador> consultarTrabajadores(){
        return trabajadorRepository.findAll();
    }

    public Optional<Trabajador> consultarTrabajadorPorDni(String codigo){
        return trabajadorRepository.findById(codigo);
    }

    public Trabajador crearTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public Optional<Trabajador> editarTrabajador(String dni, Trabajador tActualizado) {

        return trabajadorRepository.findById(dni).map(tAntiguo -> {
            tAntiguo.setNombre(tActualizado.getNombre());
            tAntiguo.setApellidos(tActualizado.getApellidos());
            tAntiguo.setHorasDisponibles(tActualizado.getHorasDisponibles());
            tAntiguo.setTienda(tActualizado.getTienda());
            return trabajadorRepository.save(tAntiguo);
        });
    }

    public boolean eliminarTrabajadorPorDni(String dni) {

        if(trabajadorRepository.existsById(dni)){
            trabajadorRepository.deleteById(dni);
            return true;
        }
        return false;
    }
}
