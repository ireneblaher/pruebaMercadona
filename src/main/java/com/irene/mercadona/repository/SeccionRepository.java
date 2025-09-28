package com.irene.mercadona.repository;

import com.irene.mercadona.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para acceder a la entidad seccion.
 */
@Repository
public interface SeccionRepository extends JpaRepository<Seccion,Long> {

}
