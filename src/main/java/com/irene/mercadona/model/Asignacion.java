package com.irene.mercadona.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asignacion")
/**
 * Tabla Asignacion
 */
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private int horasAsignadas;

    //Relacion N:1 con trabajador
    @ManyToOne(optional = false)
    @JoinColumn(name = "trabajador_dni")
    private Trabajador trabajador;

    //Relacion N:1 con seccion
    @ManyToOne(optional = false)
    @JoinColumn(name = "seccion_codigo")
    private Seccion seccion;

}
