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
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private int horasAsignadas;

    @ManyToOne
    @JoinColumn(name = "dni")
    private Trabajador trabajador;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Seccion seccion;

}
