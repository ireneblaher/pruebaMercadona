package com.irene.mercadona.repository;

import com.irene.mercadona.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
/**
 * Repositorio para acceder a la entidad asignacion.
 */
public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {

}
