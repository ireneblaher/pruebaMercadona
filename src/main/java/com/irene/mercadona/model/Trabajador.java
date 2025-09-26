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
public class Trabajador {
    @Id
    private String dni;

    private String nombre;
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Tienda tienda;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

}
