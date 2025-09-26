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
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;
    private int horasDiarias;


    @ManyToOne
    @JoinColumn(name = "codigo")
    private Tienda tienda;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

}
