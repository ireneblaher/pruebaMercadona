package com.irene.mercadona.repository;

import com.irene.mercadona.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositorio para acceder a la entidad asignacion.
 */
@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {

    @Query("SELECT SUM(a.horasAsignadas) FROM Asignacion a WHERE a.trabajador.dni = :dniTrabajador")
    Optional<Integer> sumHorasByTrabajadorId(@Param("dni") String dniTrabajador);

}
