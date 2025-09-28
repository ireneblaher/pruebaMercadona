package com.irene.mercadona.repository;

import com.irene.mercadona.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para acceder a la entidad trabajador.
 */
@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador,String> {

}
