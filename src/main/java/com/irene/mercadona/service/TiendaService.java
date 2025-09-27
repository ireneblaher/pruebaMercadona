package com.irene.mercadona.service;

import com.irene.mercadona.model.Tienda;
import com.irene.mercadona.repository.TiendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiendaService {

    private final TiendaRepository tiendaRepository;

    public List<Tienda> buscarTiendas(){
        return tiendaRepository.findAll();
    }

    public Tienda consultarTiendaPorCodigo (Long codigo){
        return tiendaRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));
    }

    public Tienda crearTienda(Tienda tienda){
        return tiendaRepository.save(tienda);
    }

    public Tienda editarTienda(Long codigo, Tienda tienda) {
        Tienda tiendaEditada = consultarTiendaPorCodigo(codigo);
        tiendaEditada.setNombre(tienda.getNombre());
        tiendaEditada.setCodigo(tienda.getCodigo());
        return tiendaRepository.save(tiendaEditada);

    }

    public void eliminarTienda(Long codigo){

        tiendaRepository.deleteById(codigo);

    }

}
