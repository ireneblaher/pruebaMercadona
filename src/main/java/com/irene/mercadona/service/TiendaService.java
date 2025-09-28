package com.irene.mercadona.service;

import com.irene.mercadona.model.Tienda;
import com.irene.mercadona.model.Trabajador;
import com.irene.mercadona.repository.TiendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Lógica de negocio correspondiente a las tiendas
 */
@Service
@RequiredArgsConstructor
public class TiendaService {

    private final TiendaRepository tiendaRepository;

    public List<Tienda> buscarTiendas(){
        return tiendaRepository.findAll();
    }

    public Optional<Tienda> consultarTiendaPorCodigo (Long codigo){
        return tiendaRepository.findById(codigo);
    }

    public Tienda crearTienda(Tienda tienda){
        return tiendaRepository.save(tienda);
    }

    public Optional<Tienda> editarTienda(Long codigo, Tienda tActualizada) {

        return tiendaRepository.findById(codigo).map(tAntigua -> {
            tAntigua.setNombre(tActualizada.getNombre());
            return tiendaRepository.save(tAntigua);
        });

    }

    public boolean eliminarTienda(Long codigo){

        if (tiendaRepository.existsById(codigo)) {
            tiendaRepository.deleteById(codigo);
            return true;
        }
        return false;
    }

}
