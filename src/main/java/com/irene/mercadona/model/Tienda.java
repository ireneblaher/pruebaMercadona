package com.irene.mercadona.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


/**
 * Tabla Tienda
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tiendas")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    @Size(min = 2, max = 20, message = "{error.nombre.tamanio}")
    private String nombre;

    //Relacion 1:N con trabajadores
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "tienda-trabajador")
    private List<Trabajador> trabajadores;

    //Relacion 1:N con secciones
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "tienda-seccion")
    private List<Seccion> secciones;

}
