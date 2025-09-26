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
public class Tienda {

    @Id
    private String codigo;

    private String nombre;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    private List<Trabajador> trabajadores;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    private List<Seccion> secciones;

}
