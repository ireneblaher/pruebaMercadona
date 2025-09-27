package com.irene.mercadona.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seccion")
/**
 * Tabla seccion
 */
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int horasDiarias;

    //Relacion N:1 con tienda
    @ManyToOne
    @JoinColumn(name = "tienda_codigo")
    private Tienda tienda;

    //Relacion 1:N con asignaciones
   /* @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;*/

}
