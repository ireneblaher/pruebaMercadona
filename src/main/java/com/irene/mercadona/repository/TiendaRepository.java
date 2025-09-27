package com.irene.mercadona.repository;

import com.irene.mercadona.model.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Repositorio para acceder a la entidad tienda.
 */
public interface TiendaRepository extends JpaRepository<Tienda,Long> {

}
