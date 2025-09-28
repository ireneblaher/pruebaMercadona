package com.irene.mercadona.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para el informe de horas faltantes
 */
@Data
@AllArgsConstructor
public class InformeResponseDTO {

    @NotEmpty(message = "El nombre de la tienda es obligatoria")
    private String nombreTienda;
    @NotEmpty(message = "El nombre de la seccion es obligatoria")
    private String nombreSeccion;
    @NotNull(message = "Horas Faltantes es obligatorio")
    private int horasFaltantes;

}
