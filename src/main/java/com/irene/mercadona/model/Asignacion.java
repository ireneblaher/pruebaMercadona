package com.irene.mercadona.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asignaciones")
/**
 * Tabla Asignacion
 */
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    @NotNull(message = "{error.horas.asignadas.obl}")
    @Min(value = 1, message = "{error.horas.min}")
    @Max(value = 8, message = "{error.horas.max}")
    private int horasAsignadas;

    //Relacion N:1 con trabajador
    @ManyToOne(optional = false)
    @JoinColumn(name = "trabajador_dni")
    @JsonBackReference(value = "trabajador-asignacion")
    private Trabajador trabajador;

    //Relacion N:1 con seccion
    @ManyToOne(optional = false)
    @JoinColumn(name = "seccion_codigo")
    @JsonBackReference(value = "seccion-asignacion")
    private Seccion seccion;

}
