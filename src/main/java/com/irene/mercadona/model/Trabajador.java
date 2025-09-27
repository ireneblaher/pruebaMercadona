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
@Table(name = "trabajador")
/**
 * Tabla Trabajador
 */
public class Trabajador {

    @Id
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private int horasDisponibles;

    //Relacion N:1 con tienda
    @ManyToOne(optional = false)
    @JoinColumn(name = "tienda_codigo")
    private Tienda tienda;

    //Relacion 1:N con asignaciones
   /* @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;*/

}
