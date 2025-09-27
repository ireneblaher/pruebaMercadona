package com.irene.mercadona.service;

import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
/**
 * Servicio para gestionar los trabajadores
 */
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public List<Trabajador> consultarTrabajadores(){
        return trabajadorRepository.findAll();
    }

    public Trabajador consultarTrabajadorPorDni(String codigo){
        return trabajadorRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
    }

    public Trabajador crearTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador editarTrabajador(String dni, Trabajador trabajador) {
        Trabajador trabajadorEditado = consultarTrabajadorPorDni(dni);
        trabajadorEditado.setNombre(trabajador.getNombre());
        trabajadorEditado.setApellidos(trabajador.getApellidos());
        return trabajadorRepository.save(trabajadorEditado);
    }

    public void eliminarTrabajador(String dni) {

        trabajadorRepository.deleteById(dni);

    }
}
