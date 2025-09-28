package com.irene.mercadona.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la peticion a la API de crear una asignacion
 * de un trabajador a una seccion
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AsignacionRequestDTO {

    @NotEmpty(message = "Nombre es obligatorio")
    private String dniTrabajador;

    @NotNull(message = "CodSeccion es obligatorio")
    private Long codSeccion;

    @NotEmpty(message = "Horas asignadas son obligatorias")
    private int horasAsignadas;

}
