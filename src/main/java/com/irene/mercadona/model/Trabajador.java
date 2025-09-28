package com.irene.mercadona.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Tabla Trabajador
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trabajadores")
public class Trabajador {

    @Id
    @Pattern(regexp = "[0-9]{8}[A-Z]", message = "{error.dni.invalido}")
    private String dni;

    @Column(nullable = false)
    @Size(min = 2, max = 20, message = "{error.nombre.tamanio}")
    private String nombre;

    @Column(nullable = false)
    @Size(min = 2, max = 40, message = "{error.apellidos.tamanio}")
    private String apellidos;

    @Column(nullable = false)
    @NotNull(message = "{error.horas.disponibles.obl}")
    @Min(value = 1, message = "Horas mínimo 1")
    @Max(value = 8, message = "Horas máximo 8")
    private int horasDisponibles;

    //Relacion N:1 con tienda
    @ManyToOne(optional = false)
    @JoinColumn(name = "tienda_codigo")
    @JsonBackReference(value = "tienda-trabajador")
    private Tienda tienda;

    //Relacion 1:N con asignaciones
    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "trabajador-asignacion")
    private List<Asignacion> asignaciones;

}
