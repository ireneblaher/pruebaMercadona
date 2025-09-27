package com.irene.mercadona.repository;

import com.irene.mercadona.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
/**
 * Repositorio para acceder a la entidad trabajador.
 */
public interface TrabajadorRepository extends JpaRepository<Trabajador,String> {

}
