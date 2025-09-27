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
@Table(name = "tienda")
/**
 * Tabla Tienda
 */
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    //Relacion 1:N con trabajadores
  /*  @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    private List<Trabajador> trabajadores;*/

    //Relacion 1:N con secciones
    /*@OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    private List<Seccion> secciones;*/

}
