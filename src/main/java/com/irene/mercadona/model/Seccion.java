package com.irene.mercadona.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Tabla seccion
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "secciones")
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    @Size(min = 2, max = 20, message = "{error.nombre.tamanio}")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "{error.horas.necesarias.obl}")
    @Min(value = 1, message = "{error.horas.max8}")
    @Max(value = 16, message = "{error.horas.max16}")
    private int horasNecesarias;

    //Relacion N:1 con tienda
    @ManyToOne
    @JoinColumn(name = "tienda-seccion")
    @JsonBackReference(value = "tienda-seccion")
    private Tienda tienda;

    //Relacion 1:N con asignaciones
    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference(value = "seccion-asignacion")
    private List<Asignacion> asignaciones;

}
